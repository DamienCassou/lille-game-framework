package gameframework.motion.blocking;

import java.util.Iterator;
import gameframework.motion.GameMovable;
import gameframework.motion.SpeedVector;

public interface MoveBlockerChecker {

	public void addMoveBlocker(MoveBlocker blocker);

	public void removeMoveBlocker(MoveBlocker blocker);
	
	public Iterator<MoveBlocker> getMoveBlockerIterator();

	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);

	public boolean moveValidation(GameMovable movable,
			SpeedVector requestedSpeedVector);
}
