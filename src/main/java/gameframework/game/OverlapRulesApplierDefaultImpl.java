package gameframework.game;

import gameframework.base.Overlap;
import gameframework.base.Overlappable;

import java.lang.reflect.Method;
import java.util.Vector;

public abstract class OverlapRulesApplierDefaultImpl implements
		OverlapRulesApplier {

	public void applyOverlapRules(Vector<Overlap> overlaps) {
		for (Overlap col : overlaps) {
			applySpecificOverlapRule(col.getOverlappable1(),
					col.getOverlappable2());
		}
	}

	protected void applySpecificOverlapRule(Overlappable e1, Overlappable e2) {
		Method m;
		try {
			m = getClass().getMethod("overlapRule", e1.getClass(),
					e2.getClass());
		} catch (NoSuchMethodException e) {
			// automatic commutativity handling
			reverseParameters(e1, e2);
			return;
		}
		invoke(m, e1, e2);
	}

	protected void reverseParameters(Overlappable e1, Overlappable e2) {
		Method m;
		try {
			m = getClass().getMethod("overlapRule", e2.getClass(),
					e1.getClass());
		} catch (NoSuchMethodException e) {
			return;
		}
		invoke(m, e2, e1);
	}

	protected void invoke(Method m, Overlappable e1, Overlappable e2) {
		try {
			m.invoke(this, e1, e2);
		} catch (Exception e) {
			throw new RuntimeException("Reflective invocation exception", e);
		}
	}
}
