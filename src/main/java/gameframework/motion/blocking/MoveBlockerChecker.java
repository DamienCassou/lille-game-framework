package gameframework.motion.blocking;

import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

public interface MoveBlockerChecker {
	public void addMoveBlocker(MoveBlocker blocker);

	public void removeMoveBlocker(MoveBlocker blocker);

	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);

	public boolean moveValidation(Movable movable,
			SpeedVector requestedSpeedVector);
}
