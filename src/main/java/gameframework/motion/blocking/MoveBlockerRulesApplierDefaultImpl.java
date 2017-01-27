package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.IllegalMoveException;

import java.lang.reflect.Method;
import java.util.Vector;

/**
 * Take care of special blocking rules for your game. By default, a
 * <code>MoveBlocker</code> always blocks a <code>Movable</code>. But you can
 * change this behavior by sub-classing
 * <code>MoveBlockerRulesApplierDefaultImpl</code> and implementing different
 * behaviours for the <code>moveBlockerRule</code> methods, depending on
 * which parameters you give to it.
 *
 * For example, in a typical Pacman game, a <code>moveBlockerRule</code> method
 * could look like:
 *
 * <pre>
 * {@code
 * public void moveBlockerRule(Ghost ghost, Wall wall) throws IllegalMoveException {
 *   // The default case is when a ghost is active and not able to cross a
 *   // wall. As soon as the ghost has been eaten by Pacman, the ghost becomes
 *   // inactive and will cross walls to return to its jail in straight line.
 *   if (ghost.isActive()) {
 *     throw new IllegalMoveException();
 *   }
 * }
 * }
 * </pre>
 *
 */
public class MoveBlockerRulesApplierDefaultImpl implements
		MoveBlockerRulesApplier {

	protected GameData gameData;

	/**
	 * @see gameframework.motion.blocking.MoveBlockerRulesApplier#moveValidationProcessing(gameframework.motion.GameMovable, java.util.Vector)
	 */
	@Override
	public boolean moveValidationProcessing(GameMovable movable, Vector<MoveBlocker> blockers) {
		for (MoveBlocker moveBlocker : blockers) {
			try {
				moveBlockerRuleApply(movable, moveBlocker);
			} catch (Exception e) {
				/*
				 * by default the moveBlocker implies the invalidation of the
				 * move (in particular, if no method has been found by
				 * moveBlockerRuleApply)
				 */
				return false;
			}
		}
		return true;
	}

	/**
	 * Applies the moveBlockerRule by calling the correct method depending of the
	 * parameters type.
	 * @param movable
	 * @param blocker
	 * @throws Exception
	 */
	protected void moveBlockerRuleApply(GameMovable movable, MoveBlocker blocker)
			throws Exception {
		Method m = (getClass()).getMethod("moveBlockerRule", movable.getClass(),
				blocker.getClass());
		m.invoke(this, movable, blocker);
	}


	/**
	 * This method checks if the movable is allowed to move by the blocker.
	 * If not, this method will throw an IllegalMoveException. Otherwise, it
	 * does nothing.
	 *
	 * It is a default behaviour, that you can expend by adding other moveBlockerRule
	 * methods to have different behaviours depending on the type of the parameters.
	 * @param movable the movable to check
	 * @param blocker the blocker that might block the movable
	 * @throws IllegalMoveException
	 */
	protected void moveBlockerRule(GameMovable movable, MoveBlocker blocker)
			throws IllegalMoveException {
		throw new IllegalMoveException();
	}

	@Override
	public void setGameData(GameData gameData) {
		this.gameData = gameData;
	}
}
