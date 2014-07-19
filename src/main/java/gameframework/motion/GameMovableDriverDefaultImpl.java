package gameframework.motion;

import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

public class GameMovableDriverDefaultImpl implements GameMovableDriver {
	protected MoveBlockerChecker moveBlockerChecker;
	protected MoveStrategy moveStrategy;

	public GameMovableDriverDefaultImpl() {
		moveBlockerChecker = new MoveBlockerCheckerDefaultImpl();
		moveStrategy = new MoveStrategyDefaultImpl();
	}

	public void setStrategy(MoveStrategy strat) {
		moveStrategy = strat;
	}

	public void setmoveBlockerChecker(MoveBlockerChecker obst) {
		moveBlockerChecker = obst;
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
