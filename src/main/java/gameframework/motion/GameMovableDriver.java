package gameframework.motion;

import gameframework.motion.blocking.MoveBlockerChecker;

/**
 * Applies moveBlocker checker and moving strategies
 */
public interface GameMovableDriver {
	public void setStrategy(MoveStrategy strat);

	public void setmoveBlockerChecker(MoveBlockerChecker obst);

	public SpeedVector getSpeedVector(GameMovable m);
}
