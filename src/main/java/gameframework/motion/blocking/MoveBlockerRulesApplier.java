package gameframework.motion.blocking;

import gameframework.game.GameData;
import gameframework.motion.Movable;

import java.util.Vector;

public interface MoveBlockerRulesApplier {
	public boolean moveValidationProcessing(Movable m, Vector<MoveBlocker> obs);

	public void setGameData(GameData gameData);
}
