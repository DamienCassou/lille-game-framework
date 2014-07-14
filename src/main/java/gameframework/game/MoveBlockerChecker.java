package gameframework.game;

import gameframework.base.Movable;
import gameframework.base.SpeedVector;

public interface MoveBlockerChecker {
	public void addMoveBlocker(MoveBlocker p);

	public void removeMoveBlocker(MoveBlocker p);

	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules);

	public boolean moveValidation(Movable m, SpeedVector mov);
}
