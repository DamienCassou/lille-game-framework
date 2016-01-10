package gameframework.game;

import static org.junit.Assert.*;

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

	protected GameUniverseDefaultImpl GameUniverseDefaultImpl;
	
	@Before
	public void init() {
		GameUniverseDefaultImpl = new GameUniverseDefaultImpl();
		GameUniverseDefaultImpl.setGameData(new GameDataMock());
	}
	
	public void addAndRemoveEntity(GameEntity entity) {
		GameUniverseDefaultImpl.addGameEntity(entity);
		assertTrue(GameUniverseDefaultImpl.getGameEntities().contains(entity));
		
		GameUniverseDefaultImpl.removeGameEntity(entity);
		assertFalse(GameUniverseDefaultImpl.getGameEntities().contains(entity));
	}
	
	@Test
	public void addAndRemoveGameEntity() {
		GameEntityMock GameEntity = new GameEntityMock();
		this.addAndRemoveEntity(GameEntity);
	}
	
	@Test
	public void addAndRemoveOverlappableEntity() {
		GameOverlappableEntityMock OverlappableEntity = new GameOverlappableEntityMock();
		
		// OverlapProcessorDefaultImplMock is instanced by GameConfigurationMock, included in GameDataMock
		OverlapProcessorDefaultImplMock OverlapProcessor = (OverlapProcessorDefaultImplMock) GameUniverseDefaultImpl.getOverlapProcessor();

		GameUniverseDefaultImpl.addGameEntity(OverlappableEntity);
		assertTrue(GameUniverseDefaultImpl.getGameEntities().contains(OverlappableEntity));
		assertTrue(OverlapProcessor.test_isAdding(OverlappableEntity));
		
		GameUniverseDefaultImpl.removeGameEntity(OverlappableEntity);
		assertFalse(GameUniverseDefaultImpl.getGameEntities().contains(OverlappableEntity));
		assertFalse(OverlapProcessor.test_isAdding(OverlappableEntity));
	}
	
	@Test
	public void addAndRemoveMoveBlockerEntity() {
		GameMoveBlockerEntityMock MoveBlockerEntity = new GameMoveBlockerEntityMock();
		MoveBlockerChecker moveBlockerChecker = GameUniverseDefaultImpl.getMoveBlockerChecker();
		
		GameUniverseDefaultImpl.addGameEntity(MoveBlockerEntity);
		assertTrue(GameUniverseDefaultImpl.getGameEntities().contains(MoveBlockerEntity));
		assertTrue(moveBlockerChecker.getMoveBlockers().contains(MoveBlockerEntity));
		
		GameUniverseDefaultImpl.removeGameEntity(MoveBlockerEntity);
		assertFalse(GameUniverseDefaultImpl.getGameEntities().contains(MoveBlockerEntity));
		assertFalse(moveBlockerChecker.getMoveBlockers().contains(MoveBlockerEntity));
	}
	
	@Test
	public void addAndRemoveMovableEntity() {
		GameMovableEntityMock MovableEntity = new GameMovableEntityMock();
		this.addAndRemoveEntity(MovableEntity);
	}
	
	
	@Test
	public void testAllOneStepMoves() {
		GameMovableEntityMock MovableEntity1 = new GameMovableEntityMock();
		GameMovableEntityMock MovableEntity2 = new GameMovableEntityMock();
				
		GameUniverseDefaultImpl.addGameEntity(MovableEntity1);
		GameUniverseDefaultImpl.allOneStepMoves();
		
		assertTrue(MovableEntity1.getStateStepMove());
		assertFalse(MovableEntity2.getStateStepMove());
		
		MovableEntity1.setStateStepMove(false);
		
		GameUniverseDefaultImpl.addGameEntity(MovableEntity2);
		GameUniverseDefaultImpl.allOneStepMoves();
		
		assertTrue(MovableEntity1.getStateStepMove());
		assertTrue(MovableEntity2.getStateStepMove());
	}
}
