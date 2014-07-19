package gameframework.game;

import gameframework.base.ObservableValue;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.List;

public class GameData {

	protected final Canvas canvas;
	protected final ObservableValue<Integer> score;
	protected final ObservableValue<Integer> life;
	protected final GameConfiguration configuration;
	protected final ObservableValue<Boolean> endOfGame;
	protected final List<GameLevel> levels;
	
	public GameData(GameConfiguration configuration) {
		super();
		this.canvas = configuration.createCanvas();
		this.score = new ObservableValue<Integer>(0);
		this.life = new ObservableValue<Integer>(configuration.getDefaultNbLives());
		this.endOfGame = new ObservableValue<Boolean>(false);
		this.configuration = configuration;
		this.levels = new ArrayList<GameLevel>();
	}
	
	public GameConfiguration getConfiguration() {
		return configuration;
	}
	
	public ObservableValue<Integer> getScore() {
		return score;
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public ObservableValue<Integer> getLife() {
		return life;
	}

	public ObservableValue<Boolean> getEndOfGame() {
		return endOfGame;
	}

	public List<GameLevel> getLevels() {
		return levels;
	}

	public void addLevel(GameLevel level) {
		levels.add(level);
	}
	
}
