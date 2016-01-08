package gameframework.motion.overlapping;

import gameframework.game.GameData;
import gameframework.game.GameUniverse;

import java.lang.reflect.Method;
import java.util.Vector;

public class OverlapRulesApplierDefaultImpl implements OverlapRulesApplier {

	protected GameData data;
	
	@Override
	public void applyOverlapRules(Vector<Overlap> overlaps) {
		for (Overlap col : overlaps) {
			applySpecificOverlapRule(col.getOverlappable1(), col.getOverlappable2(),
					true);
		}
	}

	/**
	 * The method is commutative between <code>e1</code> and <code>e2</code>. To
	 * use the commutativity, see the parameter
	 * <code>tryToReverseParameters</code>
	 * 
	 * @param tryToReverseParameters
	 *            if true and the order of the parameters is not correct, the
	 *            method will try to reverse the e1 and e2 parameters, else it
	 *            will not affect anything
	 */
	protected void applySpecificOverlapRule(Overlappable e1, Overlappable e2,
			boolean tryToReverseParameters) {
		Method m;
		try {
			m = getClass().getMethod("overlapRule", e1.getClass(),
					e2.getClass());
		} catch (NoSuchMethodException e) {
			if (tryToReverseParameters)
				applySpecificOverlapRule(e2, e1, false);
			return;
		}
		invoke(m, e1, e2);
	}

	protected void invoke(Method m, Overlappable e1, Overlappable e2) {
		try {
			m.invoke(this, e1, e2);
		} catch (Exception e) {
			throw new RuntimeException("Reflective invocation exception", e);
		}
	}

	public GameUniverse getUniverse() {
		return data.getUniverse();
	}
	
	@Override
	public void setGameData(GameData data) {
		this.data = data;
	}
}
