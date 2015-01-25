package gameframework.motion;

public class MoveStrategyDefaultImpl implements MoveStrategy {
	@Override
	public SpeedVector getSpeedVector() {
		return SpeedVector.createNullVector();
	}
	
	@Override
	public int getSpeed() {
		return 0;
	}
	
	@Override
	public void setSpeed(int speed) {
	}
}
