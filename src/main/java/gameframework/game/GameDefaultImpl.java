package gameframework.game;

import gameframework.base.ObservableValue;
import gameframework.drawing.CanvasDefaultImpl;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Create a basic game application with menus and displays of lives and score
 */
public class GameDefaultImpl implements Game, Observer {

	protected static final int NB_ROWS = 31;
	protected static final int NB_COLUMNS = 28;
	protected static final int SPRITE_SIZE = 16;
	public static final int NUMBER_OF_LIVES = 1;

	protected CanvasDefaultImpl defaultCanvas = null;
	protected ObservableValue<Integer> score = new ObservableValue<Integer>(0);
	protected ObservableValue<Integer> life = new ObservableValue<Integer>(
			NUMBER_OF_LIVES);

	// initialized before each level
	protected ObservableValue<Boolean> endOfGame = null;

	private Frame f;
	private GameLevelDefaultImpl currentPlayedLevel = null;

	protected ArrayList<GameLevel> gameLevels;

	public GameDefaultImpl() {
		createGUI();
	}

	public void createGUI() {
		f = new Frame("Default Game");
		f.dispose();
		f.setMenuBar(new GameMenuBar().getComponent());

		defaultCanvas = new CanvasDefaultImpl();
		defaultCanvas.setSize(SPRITE_SIZE * NB_COLUMNS, SPRITE_SIZE * NB_ROWS);
		f.add(defaultCanvas);
		f.add(new GameStatusBar(score, life).getContainer(), BorderLayout.NORTH);
		f.pack();
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	public Canvas getCanvas() {
		return defaultCanvas;
	}

	public void start() {
		score.addObserver(this);
		life.addObserver(this);
		life.setValue(NUMBER_OF_LIVES);
		for (GameLevel level : gameLevels) {
			endOfGame = new ObservableValue<Boolean>(false);
			endOfGame.addObserver(this);
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

	public ObservableValue<Integer> score() {
		return score;
	}

	public ObservableValue<Integer> life() {
		return life;
	}

	public ObservableValue<Boolean> endOfGame() {
		return endOfGame;
	}

	public void setLevels(ArrayList<GameLevel> levels) {
		gameLevels = levels;
	}

	public void update(Observable o, Object arg) {
		if (endOfGame.getValue() || life.getValue() <= 0) {
			currentPlayedLevel.interrupt();
			currentPlayedLevel.end();
		}
	}
}
