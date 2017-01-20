package gameframework.motion;

import java.awt.Point;
/**
 *  * {@link MoveStrategy} which select the direction to reach the goal point
 *  {@link SpeedVector speed vectors} based on the goal point
 *
 */
public class MoveStrategyStraightLine implements MoveStrategy {

	protected int speed = 8;
	Point goal, currentPosition;

	/**
	 * if no speed parameter, the default speed is set to 8
	 * @param pos the current position of the object you want to move
	 * @param goal the point the object have to reach
	 */
	public MoveStrategyStraightLine(Point pos, Point goal) {
		this.goal = goal;
		this.currentPosition = pos;
	}
	/**
	 * 
	 * @param pos the current position of the object you want to move
	 * @param goal  the point the object have to reach
	 * @param speed  speed value of the object 
	 */
	public MoveStrategyStraightLine(Point pos, Point goal, int speed) {
		this(pos, goal);
		this.speed = speed;
	}
	
	@Override
	public int getSpeed() {
		return speed;
	}
	
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public SpeedVector getSpeedVector() {
		double dist = currentPosition.distance(goal);
		int xDirection = (int) Math.rint((goal.getX() - currentPosition.getX())
				/ dist);
		int yDirection = (int) Math.rint((goal.getY() - currentPosition.getY())
				/ dist);
		SpeedVector move = new SpeedVector(new Point(xDirection, yDirection), this.speed);
		return move;
	}
}
