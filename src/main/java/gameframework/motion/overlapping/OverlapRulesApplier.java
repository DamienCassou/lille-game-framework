package gameframework.motion.overlapping;

import gameframework.game.GameUniverse;

import java.util.Vector;

public interface OverlapRulesApplier {
	public void setUniverse(GameUniverse universe);

	/**
	 * Modify the Universe depending on all the overlaps in parameter.
	 */
	public void applyOverlapRules(Vector<Overlap> overlaps);
}
