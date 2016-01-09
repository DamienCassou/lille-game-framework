package gameframework.game;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * stores all the gameframework.game entities of a gameframework.game level:
 * oneStepMoveAll() makes all the entities move ; overlapAll() manages all the
 * interactions between the entities.
 */
public interface GameUniverse {

	public void addGameEntity(GameEntity gameEntity);

	public void removeGameEntity(GameEntity gameEntity);

	public ConcurrentLinkedQueue<GameEntity> getGameEntities();

	public Iterator<GameEntity> getGameEntitiesIterator();

	public void allOneStepMoves();

	public void processAllOverlaps();
	
	public void setGameData(GameData data);

}
