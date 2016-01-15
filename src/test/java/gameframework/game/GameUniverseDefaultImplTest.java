package gameframework.game;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.mocks.GameDataMock;
import gameframework.game.mocks.GameEntityMock;
import gameframework.game.mocks.GameMovableEntityMock;
import gameframework.game.mocks.GameMoveBlockerEntityMock;
import gameframework.game.mocks.GameOverlappableEntityMock;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.overlapping.mocks.OverlapProcessorDefaultImplMock;

public class GameUniverseDefaultImplTest {

	protected GameUniverseDefaultImpl gameUniverseDefaultImpl;
	protected MoveBlockerChecker moveBlockerChecker;
	
	@Before
	public void init() {
		gameUniverseDefaultImpl = new GameUniverseDefaultImpl();
		gameUniverseDefaultImpl.setGameData(new GameDataMock());

		moveBlockerChecker = gameUniverseDefaultImpl.getMoveBlockerChecker();
	}

	public Boolean entityExist(Iterator<?> i, GameEntity entity) {
		while(i.hasNext()) {
			if(entity.equals(i.next())) {
				return true;
			}
		}

		return false;
	}

	public Boolean hasGameEntity(GameEntity entity) {
		return entityExist(gameUniverseDefaultImpl.getGameEntitiesIterator(), entity);
	}

	public Boolean moveBlockerEntityAdded(GameEntity entity) {
		return entityExist(moveBlockerChecker.getMoveBlockerIterator(), entity);
	}
	
	public void addAndRemoveEntity(GameEntity entity) {
		gameUniverseDefaultImpl.addGameEntity(entity);
		assertTrue(hasGameEntity(entity));
		
		gameUniverseDefaultImpl.removeGameEntity(entity);
		assertFalse(hasGameEntity(entity));
	}
	
	@Test
	public void addAndRemoveGameEntity() {
		GameEntityMock gameEntity = new GameEntityMock();
		addAndRemoveEntity(gameEntity);
	}
	
	@Test
	public void addAndRemoveOverlappableEntity() {
		GameOverlappableEntityMock overlappableEntity = new GameOverlappableEntityMock();
		
		// OverlapProcessorDefaultImplMock is instanced by GameConfigurationMock, included in GameDataMock
		OverlapProcessorDefaultImplMock overlapProcessor = (OverlapProcessorDefaultImplMock) gameUniverseDefaultImpl.getOverlapProcessor();

		gameUniverseDefaultImpl.addGameEntity(overlappableEntity);
		assertTrue(hasGameEntity(overlappableEntity));
		assertTrue(overlapProcessor.test_isAdding(overlappableEntity));
		
		gameUniverseDefaultImpl.removeGameEntity(overlappableEntity);
		assertFalse(hasGameEntity(overlappableEntity));
		assertFalse(overlapProcessor.test_isAdding(overlappableEntity));
	}
	
	@Test
	public void addAndRemoveMoveBlockerEntity() {
		GameMoveBlockerEntityMock moveBlockerEntity = new GameMoveBlockerEntityMock();
		
		gameUniverseDefaultImpl.addGameEntity(moveBlockerEntity);
		assertTrue(hasGameEntity(moveBlockerEntity));
		assertTrue(moveBlockerEntityAdded(moveBlockerEntity));
		
		gameUniverseDefaultImpl.removeGameEntity(moveBlockerEntity);
		assertFalse(hasGameEntity(moveBlockerEntity));
		assertFalse(moveBlockerEntityAdded(moveBlockerEntity));
	}
	
	@Test
	public void addAndRemoveMovableEntity() {
		GameMovableEntityMock movableEntity = new GameMovableEntityMock();
		this.addAndRemoveEntity(movableEntity);
	}
	
	
	@Test
	public void testAllOneStepMoves() {
		GameMovableEntityMock movableEntity1 = new GameMovableEntityMock();
		GameMovableEntityMock movableEntity2 = new GameMovableEntityMock();
				
		gameUniverseDefaultImpl.addGameEntity(movableEntity1);
		gameUniverseDefaultImpl.allOneStepMoves();
		
		assertTrue(movableEntity1.getStateStepMove());
		assertFalse(movableEntity2.getStateStepMove());
		
		movableEntity1.setStateStepMove(false);
		
		gameUniverseDefaultImpl.addGameEntity(movableEntity2);
		gameUniverseDefaultImpl.allOneStepMoves();
		
		assertTrue(movableEntity1.getStateStepMove());
		assertTrue(movableEntity2.getStateStepMove());
	}
}
