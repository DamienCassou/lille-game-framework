package gameframework.motion.blocking;

import java.util.Iterator;
import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;

public interface MoveBlockerChecker {

	public void addMoveBlocker(MoveBlocker blocker);

	public void removeMoveBlocker(MoveBlocker blocker);
	
	public Iterator<MoveBlocker> getMoveBlockerIterator();

	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);

	public boolean moveValidation(Movable movable,
			SpeedVector requestedSpeedVector);
}
