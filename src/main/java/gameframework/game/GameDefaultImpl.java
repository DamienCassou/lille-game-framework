package gameframework.game;

import java.util.Observable;
import java.util.Observer;

/**
 * Create a basic game application with menus and displays of lives and score
 */
public class GameDefaultImpl implements Game, Observer {

	private GameLevelDefaultImpl currentPlayedLevel = null;

	protected final GameData data;

	public GameDefaultImpl(GameData data) {
		this.data = data;
		data.getScore().addObserver(this);
		data.getLife().addObserver(this);
		data.getEndOfGame().addObserver(this);
	}

	@Override
	public void start() {
		for (GameLevel level : data.getLevels()) {
			data.getEndOfGame().setValue(false);
			if (currentPlayedLevel != null && currentPlayedLevel.isAlive()) {
				currentPlayedLevel.interrupt();
				currentPlayedLevel = null;
			}
			currentPlayedLevel = (GameLevelDefaultImpl) level;
			currentPlayedLevel.start();
			try {
				currentPlayedLevel.join();
			} catch (InterruptedException e) {
				// that's ok, we just haven't finished sleeping
			}
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		if (data.getEndOfGame().getValue() || data.getLife().getValue() <= 0) {
			currentPlayedLevel.interrupt();
			currentPlayedLevel.end();
		}
	}
}
