package gameframework.game;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerRulesApplier;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapRulesApplier;

import java.util.ArrayList;
import java.util.List;

public class GameData {

	protected final GameCanvas canvas;
	protected final ObservableValue<Integer> score;
	protected final ObservableValue<Integer> life;
	protected final GameConfiguration configuration;
	protected final ObservableValue<Boolean> endOfGame;
	protected final List<GameLevel> levels;
	protected final MoveBlockerRulesApplier moveBlockerRulesApplier;
	protected final MoveBlockerChecker moveBlockerChecker;
	protected final OverlapRulesApplier overlapRulesApplier;
	protected final OverlapProcessor overlapProcessor;
	protected final GameUniverse universe;

	public GameData(GameConfiguration configuration) {
		this.configuration = configuration;

		canvas = configuration.createCanvas();
		score = new ObservableValue<Integer>(0);
		life = new ObservableValue<Integer>(configuration.getDefaultNbLives());
		endOfGame = new ObservableValue<Boolean>(false);
		levels = new ArrayList<GameLevel>();

		universe = configuration.createUniverse();
		universe.setGameData(this);

		moveBlockerRulesApplier = configuration.createMoveBlockerRulesApplier();
		moveBlockerRulesApplier.setGameData(this);
		moveBlockerChecker = configuration.createMoveBlockerChecker();
		moveBlockerChecker.setMoveBlockerRules(moveBlockerRulesApplier);

		overlapRulesApplier = configuration.createOverlapRulesApplier();
		overlapRulesApplier.setGameData(this);
		overlapProcessor = configuration.createOverlapProcessor();
		overlapProcessor.setOverlapRules(overlapRulesApplier);


	}

	public GameConfiguration getConfiguration() {
		return configuration;
	}

	public ObservableValue<Integer> getScore() {
		return score;
	}

	public GameCanvas getCanvas() {
		return canvas;
	}

	public ObservableValue<Integer> getLife() {
		return life;
	}
	
	public void increaseLife(int lifeToAdd) {
		life.setValue(life.getValue() + lifeToAdd);
	}
	
	public void decreaseLife(int lifeToRemove) {
		if(lifeToRemove >= life.getValue())
			life.setValue(0);
		else
			life.setValue(life.getValue() - lifeToRemove);
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

	public OverlapProcessor getOverlapProcessor() {
		return overlapProcessor;
	}

	public OverlapRulesApplier getOverlapRulesApplier() {
		return overlapRulesApplier;
	}

	public GameUniverse getUniverse() {
		return universe;
	}
}
