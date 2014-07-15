package gameframework.motion.blocking;

import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

public interface MoveBlockerChecker {
	public void addMoveBlocker(MoveBlocker p);

	public void removeMoveBlocker(MoveBlocker p);

	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);

	public boolean moveValidation(Movable m, SpeedVector mov);
}
