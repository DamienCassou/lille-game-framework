package gameframework.game;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerRulesApplier;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapRulesApplier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameData {

	private static final String SCORE_KEY = "score";
	private static final String LIFE_KEY = "life";
	protected final GameCanvas canvas;
	/**
	 * Map of observable values to save any needed data.
	 */
	protected final Map<String, ObservableValue<?>> observableValues;
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
		observableValues = new HashMap<>();
		observableValues.put(SCORE_KEY, new ObservableValue<Integer>(0));
		observableValues.put(LIFE_KEY, new ObservableValue<Integer>(configuration.getDefaultNbLives()));
		endOfGame = new ObservableValue<Boolean>(false);
		levels = new ArrayList<GameLevel>();

		universe = configuration.createUniverse(this);

		moveBlockerRulesApplier = configuration.createMoveBlockerRulesApplier();
		moveBlockerRulesApplier.setGameData(this);
		moveBlockerChecker = configuration.createMoveBlockerChecker();
		moveBlockerChecker.setMoveBlockerRules(moveBlockerRulesApplier);

		overlapRulesApplier = configuration.createOverlapRulesApplier();
		overlapRulesApplier.setGameData(this);
		overlapProcessor = configuration.createOverlapProcessor();
		overlapProcessor.setOverlapRules(overlapRulesApplier);


	}
	
	public ObservableValue<?> getObservableValue(String key) {
		return this.observableValues.get(key);
	}
	
	public void setObservableValue(String key, ObservableValue<?> value) {
		this.observableValues.put(key, value);
	}

	public GameConfiguration getConfiguration() {
		return configuration;
	}

	public ObservableValue<Integer> getScore() {
		return (ObservableValue<Integer>) observableValues.get(SCORE_KEY);
	}

	public GameCanvas getCanvas() {
		return canvas;
	}

	public ObservableValue<Integer> getLife() {
		return (ObservableValue<Integer>) observableValues.get(LIFE_KEY);
	}
	
	public void increaseLife(int lifeToAdd) {
		getLife().setValue(getLife().getValue() + lifeToAdd);
	}
	
	public void decreaseLife(int lifeToRemove) {
		if(lifeToRemove >= getLife().getValue())
			getLife().setValue(0);
		else
			getLife().setValue(getLife().getValue() - lifeToRemove);
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
