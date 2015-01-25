package gameframework.motion;

public interface MoveStrategy {
	public SpeedVector getSpeedVector();
	
	public int getSpeed();
	
	public void setSpeed(int speed);
}
