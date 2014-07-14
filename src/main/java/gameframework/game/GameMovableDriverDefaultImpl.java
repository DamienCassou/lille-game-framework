package gameframework.game;

import gameframework.base.Movable;
import gameframework.base.MoveStrategy;
import gameframework.base.MoveStrategyDefaultImpl;
import gameframework.base.SpeedVector;
import gameframework.base.SpeedVectorDefaultImpl;

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

	public SpeedVector getSpeedVector(Movable m) {
		SpeedVector possibleSpeedVector;

		possibleSpeedVector = moveStrategy.getSpeedVector();
		if (moveBlockerChecker.moveValidation(m, possibleSpeedVector)) {
			return possibleSpeedVector;
		}

		// If the strategy did not provide a valid vector, try to keep the
		// current vector.
		possibleSpeedVector = m.getSpeedVector();
		if (moveBlockerChecker.moveValidation(m, possibleSpeedVector)) {
			return possibleSpeedVector;
		}

		return SpeedVectorDefaultImpl.createNullVector();
	}
}
