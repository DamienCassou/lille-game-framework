package gameframework.game;

import gameframework.drawing.CanvasDefaultImpl;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;
import gameframework.motion.blocking.MoveBlockerRulesApplier;
import gameframework.motion.blocking.MoveBlockerRulesApplierDefaultImpl;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapProcessorDefaultImpl;
import gameframework.motion.overlapping.OverlapRulesApplier;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

import java.awt.Canvas;

public class GameConfiguration {

	public int getNbRows() {
		return 31;
	}

	public int getNbColumns() {
		return 28;
	}

	public int getSpriteSize() {
		return 16;
	}

	public int getDefaultNbLives() {
		return 2;
	}

	public Canvas createCanvas() {
		return new CanvasDefaultImpl();
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
