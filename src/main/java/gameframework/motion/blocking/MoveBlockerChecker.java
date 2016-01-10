package gameframework.motion.blocking;

import java.util.concurrent.ConcurrentLinkedQueue;

import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

public interface MoveBlockerChecker {
	public void addMoveBlocker(MoveBlocker blocker);

	public void removeMoveBlocker(MoveBlocker blocker);
	
	public ConcurrentLinkedQueue<MoveBlocker> getMoveBlockers();

	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);

	public boolean moveValidation(Movable movable,
			SpeedVector requestedSpeedVector);
}
