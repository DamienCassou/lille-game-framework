package gameframework.game;

import java.util.Iterator;

/**
 * stores all the gameframework.game entities of a gameframework.game level:
 * oneStepMoveAll() makes all the entities move ; overlapAll() manages all the
 * interactions between the entities.
 */
public interface GameUniverse {

	public void addGameEntity(GameEntity gameEntity);

	public void removeGameEntity(GameEntity gameEntity);

	Iterator<GameEntity> gameEntities();

	public void allOneStepMoves();

	public void processAllOverlaps();

}
