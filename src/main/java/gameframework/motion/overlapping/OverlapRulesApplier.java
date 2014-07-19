package gameframework.motion.overlapping;

import gameframework.game.GameData;

import java.util.Vector;

public interface OverlapRulesApplier {
	public void setGameData(GameData data);
	/**
	 * Modify the Universe depending on all the overlaps in parameter.
	 */
	public void applyOverlapRules(Vector<Overlap> overlaps);
}
