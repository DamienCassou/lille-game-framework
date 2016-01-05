package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;

import java.lang.reflect.Method;
import java.util.Vector;

/**
 * Take care of special blocking rules for your game. By default, a
 * <code>MoveBlocker</code> always blocks a <code>Movable</code>. But you can
 * change this behavior by sub-classing
 * <code>MoveBlockerRulesApplierDefaultImpl</code> and implementing one or more
 * <code>moveBlockerRule</code> methods.
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

	@Override
	public boolean moveValidationProcessing(GameMovable movable,
			Vector<MoveBlocker> blockers) {
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

	private void moveBlockerRuleApply(GameMovable movable, MoveBlocker blocker)
			throws Exception {
		Method m = null;
		m = (getClass()).getMethod("moveBlockerRule", movable.getClass(),
				blocker.getClass());
		m.invoke(this, movable, blocker);
	}

	@Override
	public void setGameData(GameData gameData) {
		this.gameData = gameData;
	}
}
