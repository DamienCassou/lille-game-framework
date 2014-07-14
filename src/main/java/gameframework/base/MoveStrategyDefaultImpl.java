package gameframework.base;

public class MoveStrategyDefaultImpl implements MoveStrategy {
	public SpeedVector getSpeedVector() {
		return SpeedVectorDefaultImpl.createNullVector();
	}
}
