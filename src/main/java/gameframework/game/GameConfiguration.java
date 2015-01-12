package gameframework.game;

import gameframework.drawing.GameCanvas;
import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;
import gameframework.motion.blocking.MoveBlockerRulesApplier;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapProcessorDefaultImpl;
import gameframework.motion.overlapping.OverlapRulesApplier;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class GameConfiguration {

	protected final int nbRows;
	protected final int nbColumns;
	protected final int spriteSize;
	protected final int nbLives;

	// CONSTRUCTORS
	
	/**
	 * Constructor with parameterisable size. Create a new GameConfiguration with the specified
	 * parameters. If 0 is specified as one of the parameter, the constructor uses the default
	 * value for this parameter. 
	 * @param nbRows The number of rows of the window (default value: 31).
	 * @param nbColumns The number of columns of the window (default value: 28). 
	 * @param spriteSize The size of the sprites displayed (default value: 16).
	 * @param nbLives The number of lives of the player (default value: 2).
	 */
	public GameConfiguration(int nbRows, int nbColumns, int spriteSize,
			int nbLives) {

		if (nbRows == 0)
			this.nbRows = 31;
		else
			this.nbRows = nbRows;

		if (nbColumns == 0)
			this.nbColumns = 28;
		else
			this.nbColumns = nbColumns;

		if (spriteSize == 0)
			this.spriteSize = 16;
		else
			this.spriteSize = spriteSize;

		if (nbLives == 0)
			this.nbLives = 2;
		else
			this.nbLives = nbLives;
	}

	public GameConfiguration() {
		this(31, 28, 16, 2);
	}

	// METHODS

	public int getNbRows() {
		return nbRows;
	}

	public int getNbColumns() {
		return nbColumns;
	}

	public int getSpriteSize() {
		return spriteSize;
	}

	public int getDefaultNbLives() {
		return nbLives;
	}

	public GameCanvas createCanvas() {
		return new GameCanvasDefaultImpl();
	}

	public MoveBlockerRulesApplier createMoveBlockerRulesApplier() {
		return new MoveBlockerRulesApplierDefaultImpl();
	}

	public MoveBlockerChecker createMoveBlockerChecker() {
		return new MoveBlockerCheckerDefaultImpl();
	}

	public OverlapRulesApplier createOverlapRulesApplier() {
		return new OverlapRulesApplierDefaultImpl();
	}

	public OverlapProcessor createOverlapProcessor() {
		return new OverlapProcessorDefaultImpl();
	}

	public GameUniverse createUniverse() {
		return new GameUniverseDefaultImpl();
	}

}

