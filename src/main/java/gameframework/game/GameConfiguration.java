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

	public GameConfiguration(int nbRows, int nbColumns, int spriteSize,
			int nbLives) {
		this.nbRows = nbRows;
		this.nbColumns = nbColumns;
		this.spriteSize = spriteSize;
		this.nbLives = nbLives;
	}

	public GameConfiguration() {
		this.nbRows = 31;
		this.nbColumns = 28;
		this.spriteSize = 16;
		this.nbLives = 2;
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
