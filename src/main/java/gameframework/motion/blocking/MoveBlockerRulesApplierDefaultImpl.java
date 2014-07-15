package gameframework.motion.blocking;

import gameframework.motion.Movable;

import java.lang.reflect.Method;
import java.util.Vector;

public class MoveBlockerRulesApplierDefaultImpl implements
		MoveBlockerRulesApplier {

	public boolean moveValidationProcessing(Movable movable,
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

	private void moveBlockerRuleApply(Movable movable, MoveBlocker blocker)
			throws Exception {
		Method m = null;
		m = (getClass()).getMethod("moveBlockerRule", movable.getClass(),
				blocker.getClass());
		m.invoke(this, movable, blocker);
	}
}
