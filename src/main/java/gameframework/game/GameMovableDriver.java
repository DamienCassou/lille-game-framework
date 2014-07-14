package gameframework.game;

import gameframework.base.Movable;
import gameframework.base.SpeedVector;

/**
 * Applies moveBlocker checker and moving strategies
 */
public interface GameMovableDriver {
	public SpeedVector getSpeedVector(Movable m);
}
