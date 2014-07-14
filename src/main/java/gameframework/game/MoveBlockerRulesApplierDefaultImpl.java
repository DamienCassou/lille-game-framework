package gameframework.game;

import gameframework.base.Movable;

import java.lang.reflect.Method;
import java.util.Vector;

public class MoveBlockerRulesApplierDefaultImpl implements
		MoveBlockerRulesApplier {

	public boolean moveValidationProcessing(Vector<MoveBlocker> moveBlockers,
			Movable m) {
		for (MoveBlocker moveBlocker : moveBlockers) {
			try {
				moveBlockerRuleApply(m, moveBlocker);
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

	private void moveBlockerRuleApply(Movable e1, MoveBlocker e2)
			throws Exception {
		Method m = null;
		m = (getClass()).getMethod("moveBlockerRule", e1.getClass(),
				e2.getClass());
		m.invoke(this, e1, e2);
	}
}
