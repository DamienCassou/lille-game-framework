package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.IllegalMoveException;

import java.lang.reflect.InvocationTargetException;
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
	
	/**
	 * The last moveBlocker in date to provoke a blocking rule that forbid a movement 
	 */
	protected MoveBlocker lastBlockingBlocker = null;

	@Override
	public boolean moveValidationProcessing(GameMovable movable,
			Vector<MoveBlocker> blockers) {
		for (MoveBlocker moveBlocker : blockers) {
			try {
				moveBlockerRuleApply(movable, moveBlocker);
			} catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
				/*
				 * by default the moveBlocker implies the invalidation of the
				 * move (in particular, if no method has been found by
				 * moveBlockerRuleApply)
				 */
				lastBlockingBlocker = moveBlocker;
				return false;
			} catch (Exception exception) {
				exception.printStackTrace();
				return false;
			}
		}
		return true;
	}

	protected void moveBlockerRuleApply(GameMovable movable, MoveBlocker blocker) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Method m = null;
		m = (getClass()).getMethod("moveBlockerRule", movable.getClass(),
				blocker.getClass());
		m.invoke(this, movable, blocker);
	}

	@Override
	public void setGameData(GameData gameData) {
		this.gameData = gameData;
	}
	
	@Override
	public MoveBlocker getLastBlockingBlocker() {
		return lastBlockingBlocker;
	}
}
