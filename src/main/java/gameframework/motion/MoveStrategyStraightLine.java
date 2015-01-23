package gameframework.motion;

import java.awt.Point;

public class MoveStrategyStraightLine implements MoveStrategy {

	protected int speed = 8;
	Point goal, currentPosition;

	public MoveStrategyStraightLine(Point pos, Point goal) {
		this.goal = goal;
		this.currentPosition = pos;
	}
	
	public MoveStrategyStraightLine(Point pos, Point goal, int speed) {
		this(pos, goal);
		this.speed = speed;
	}
	
	public int getSpeed() {
		return speed;
	}
	
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
