package gameframework.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

import gameframework.game.mocks.MockGameEntity;

public abstract class GameUniverseTest {

	public abstract GameUniverse createGameUniverse();

	@Test
	public void removeGameEntityTest() {
		GameUniverse universe = this.createGameUniverse();
		GameEntity gameEntity = new MockGameEntity();
		universe.addGameEntity(gameEntity);
		assertTrue(universe.getGameEntitiesIterator().hasNext());
		universe.removeGameEntity(gameEntity);
		assertFalse(universe.getGameEntitiesIterator().hasNext());
	}

	@Test
	public void shoundNotRemoveGameEntity() {
		GameUniverse universe = this.createGameUniverse();
		GameEntity gameEntity1 = new MockGameEntity();
		GameEntity gameEntity2 = new MockGameEntity();
		universe.addGameEntity(gameEntity1);
		assertTrue(universe.getGameEntitiesIterator().hasNext());
		universe.removeGameEntity(gameEntity2);
		assertTrue(universe.getGameEntitiesIterator().hasNext());
	}

	@Test
	public void removeAllGameEntitiesTest() {
		GameUniverse universe = this.createGameUniverse();
		for (int i = 0; i < 5; i++)
			universe.addGameEntity(new MockGameEntity());
		assertTrue(universe.getGameEntitiesIterator().hasNext());
		universe.removeAllGameEntities();
		assertFalse(universe.getGameEntitiesIterator().hasNext());
	}

	@Test
	public void removeGameEntitiesTest() {
		GameUniverse universe = this.createGameUniverse();
		Collection<GameEntity> gameEntities = new HashSet<GameEntity>();
		for (int i = 0; i < 5; i++) {
			GameEntity gameEntity = new MockGameEntity();
			universe.addGameEntity(gameEntity);
			gameEntities.add(gameEntity);
		}
		assertTrue(universe.getGameEntitiesIterator().hasNext());
		universe.removeGameEntities(gameEntities);
		assertFalse(universe.getGameEntitiesIterator().hasNext());
	}
}
