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

	private static final int DEFAULT_NBROWS = 31;
	private static final int DEFAULT_NBCOL = 28;
	private static final int DEFAULT_SPRITESIZE = 16;
	private static final int DEFAULT_NBLIVES = 2;

	// CONSTRUCTORS
	
	/**
	 * Constructor with parameterisable size. Create a new GameConfiguration with the specified
	 * parameters. If 0 is specified as one of the parameter, the constructor uses the default
	 * value for this parameter. 
	 * @param nbRows The number of rows of the window (default value: {@value #DEFAULT_NBROWS}).
	 * @param nbColumns The number of columns of the window (default value: {@value #DEFAULT_NBCOL}). 
	 * @param spriteSize The size of the sprites displayed (default value: {@value #DEFAULT_SPRITESIZE}).
	 * @param nbLives The number of lives of the player (default value: {@value #DEFAULT_NBLIVES}).
	 */
	public GameConfiguration(int nbRows, int nbColumns, int spriteSize,
			int nbLives) {

		this.nbRows = nbRows <= 0
					? DEFAULT_NBROWS
					: nbRows;

		this.nbColumns = nbColumns <= 0
					 ? DEFAULT_NBCOL
					 : nbColumns;

		this.spriteSize = spriteSize <= 0
						? DEFAULT_SPRITESIZE
						: spriteSize;
		
		this.nbLives = nbLives <= 0
					 ? DEFAULT_NBLIVES
					 : nbLives;
	}

	public GameConfiguration() {
		this(DEFAULT_NBROWS, DEFAULT_NBCOL, DEFAULT_SPRITESIZE, DEFAULT_NBLIVES);
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

