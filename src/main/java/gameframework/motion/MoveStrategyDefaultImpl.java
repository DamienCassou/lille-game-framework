package gameframework.motion;

public class MoveStrategyDefaultImpl implements MoveStrategy {
	@Override
	public SpeedVector getSpeedVector() {
		return SpeedVector.createNullVector();
	}
}
