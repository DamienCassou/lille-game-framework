package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;

import java.util.Vector;

public interface MoveBlockerRulesApplier {
	public boolean moveValidationProcessing(GameMovable m, Vector<MoveBlocker> obs);

	public void setGameData(GameData gameData);
}
