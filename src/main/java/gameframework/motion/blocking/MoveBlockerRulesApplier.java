package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;

import java.util.Vector;

/**
 *  The classes implementing this interface are used to apply movement rules
 *  to a movable.
 *
 *  To move, a movable must not be blocked by a MoveBlocker. It's this interface
 *  role to provide a way to check if this is occuring.
 */
public interface MoveBlockerRulesApplier {

	/**
	 * This method checks if the movable can move according to the moveblockers
	 * in obs.
	 *
	 * If true, this means that no MoveBlocker blocks the way of the GameMovable.
	 * @param m the movable to test
	 * @param obs the MoveBlocker vector
	 * @return true if the movable is allowed to move, false otherwise
	 */
	public boolean moveValidationProcessing(GameMovable m, Vector<MoveBlocker> obs);

	public void setGameData(GameData gameData);
}
