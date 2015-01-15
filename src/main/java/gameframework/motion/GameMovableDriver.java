package gameframework.motion;

import gameframework.motion.blocking.MoveBlockerChecker;

/**
 * Applies moveBlocker checker and moving strategies
 */
public abstract class GameMovableDriver {
	protected MoveStrategy moveStrategy;
	protected MoveBlockerChecker moveBlockerChecker;
	
	public abstract SpeedVector getSpeedVector(Movable m);
	
	public void setStrategy(MoveStrategy strat) {
		moveStrategy = strat;
	}

	public void setmoveBlockerChecker(MoveBlockerChecker obst) {
		moveBlockerChecker = obst;
	}
}
