package gameframework.motion.blocking;

import gameframework.motion.GameMovable;
import gameframework.motion.SpeedVector;

/**
 * The classes that implement this interface are used to check whether a
 * movable can move. To do so, it checks if the movable is blocked by
 * any of the MoveBlocker it contains.
 */
public interface MoveBlockerChecker {
	/**
	 * Adds a MoveBlocker. The validation of a movement will now require
	 * that the MoveBlockerRules are satisfied for this new blocker.
	 * @param blocker the MoveBlocker to add
	 */
	public void addMoveBlocker(MoveBlocker blocker);

	/**
	 * Removes a MoveBlocker. The validation of a movement doesn't require
	 * that the MoveBlockerRules are satisfied for this blocker anymore.
	 * @param blocker the MoveBlocker to remove
	 */
	public void removeMoveBlocker(MoveBlocker blocker);

	/**
	 * Sets the rules that must be followed by a GameMovable according to
	 * the MoveBlocker contained in this class so as to be able to move.
	 * @param moveBlockerRules the MoveBlockerRules to set
	 */
	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);


	/**
	 * Checks if the movable can move.
	 * If true, the movable is not blocked and can move. Otherwise, the movable
	 * is blocker by a MoveBlocker according to this MoveBlockerRules.
	 * @param movable the movable to test
	 * @param requestedSpeedVector the movement that the movable whishes to do
	 * @return
	 */
	public boolean moveValidation(GameMovable movable,
			SpeedVector requestedSpeedVector);
}
