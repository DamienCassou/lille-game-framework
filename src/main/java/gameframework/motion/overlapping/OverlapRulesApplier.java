package gameframework.motion.overlapping;

import gameframework.game.GameData;

import java.util.Vector;

/**
 * This interface allows implemented class to create rules to apply in case of an Overlap.
 * 
 */
public interface OverlapRulesApplier {
	
	public void setGameData(GameData data);
	
	/**
	 * Modify the Universe depending on all the overlaps in parameter.
	 */
	public void applyOverlapRules(Vector<Overlap> overlaps);
}
