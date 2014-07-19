package gameframework.game;

import gameframework.base.ObservableValue;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerRulesApplier;

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
	protected final MoveBlockerRulesApplier moveBlockerRulesApplier;
	protected final MoveBlockerChecker moveBlockerChecker;
	
	public GameData(GameConfiguration configuration) {
		super();
		this.configuration = configuration;

		canvas = configuration.createCanvas();
		score = new ObservableValue<Integer>(0);
		life = new ObservableValue<Integer>(configuration.getDefaultNbLives());
		endOfGame = new ObservableValue<Boolean>(false);
		levels = new ArrayList<GameLevel>();
		moveBlockerRulesApplier = configuration.createMoveBlockerRulesApplier();
		moveBlockerChecker = configuration.createMoveBlockerChecker();
		moveBlockerChecker.setMoveBlockerRules(moveBlockerRulesApplier);
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
	
	public MoveBlockerRulesApplier getMoveBlockerRulesApplier() {
		return moveBlockerRulesApplier;
	}
	
	public MoveBlockerChecker getMoveBlockerChecker() {
		return moveBlockerChecker;
	}
	
}
