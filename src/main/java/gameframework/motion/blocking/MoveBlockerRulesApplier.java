package gameframework.motion.blocking;

import gameframework.motion.Movable;

import java.util.Vector;

public interface MoveBlockerRulesApplier {
	public boolean moveValidationProcessing(Movable m, Vector<MoveBlocker> obs);
}
