package gameframework.motion;
/**
 * Define how to build a {@link SpeedVector} with a particular strategy
 * 
 *
 */
public interface MoveStrategy {
	/**
	 * Build a specific {@link SpeedVector} depending of the MoveStrategy used
	 * @return the speedvector built
	 */
	public SpeedVector getSpeedVector();
	
	public int getSpeed();
	
	public void setSpeed(int speed);
}
