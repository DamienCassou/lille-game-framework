package gameframework.motion;

import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

public class GameMovableDriverDefaultImpl extends GameMovableDriver {
	
	public GameMovableDriverDefaultImpl() {
		moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveStrategy = new MoveStrategyDefaultImpl();
	}

	@Override
	public SpeedVector getSpeedVector(Movable movable) {
		SpeedVector possibleSpeedVector;

		possibleSpeedVector = moveStrategy.getSpeedVector();
		if (moveBlockerChecker.moveValidation(movable, possibleSpeedVector)) {
			return possibleSpeedVector;
		}

		// If the strategy did not provide a valid vector, try to keep the
		// current vector.
		possibleSpeedVector = movable.getSpeedVector();
		if (moveBlockerChecker.moveValidation(movable, possibleSpeedVector)) {
			return possibleSpeedVector;
		}

		return SpeedVector.createNullVector();
	}
}
