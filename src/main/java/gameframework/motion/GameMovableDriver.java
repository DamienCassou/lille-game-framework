package gameframework.motion;

/**
 * Applies moveBlocker checker and moving strategies
 */
public interface GameMovableDriver {
	public SpeedVector getSpeedVector(Movable m);
}
