package gameframework.game;

import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapProcessorDefaultImpl;
import gameframework.motion.overlapping.Overlappable;

import static org.junit.Assert.assertEquals;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

public class GameUniverseDefaultTest {

	protected GameUniverseDefaultImpl game;
	protected int cptMoveBlockerChecker;
	protected int cptOverlapProcessor;

	@Before
	public void init() {
		this.game = new GameUniverseDefaultImpl();
		this.game.setGameData(new GameData(new GameConfigurationTest()));
		this.cptMoveBlockerChecker = 0;
		this.cptOverlapProcessor = 0;
	}

	@Test
	public void testAddAndRemoveGameEntity() {
		GameEntityMoveBlocker entityMoveBlocker = createGameEntityMoveBlocker();
		GameEntityOverlappable entityOverlappable = createGameEntityOverlappable();
		this.game.addGameEntity(entityMoveBlocker);
		assertEquals(1, cptMoveBlockerChecker);
		assertEquals(0, cptOverlapProcessor);
		this.game.addGameEntity(entityOverlappable);
		assertEquals(1, cptMoveBlockerChecker);
		assertEquals(1, cptOverlapProcessor);
		this.game.removeGameEntity(entityMoveBlocker);
		assertEquals(0, cptMoveBlockerChecker);
		assertEquals(1, cptOverlapProcessor);
		this.game.removeGameEntity(entityOverlappable);
		assertEquals(0, cptMoveBlockerChecker);
		assertEquals(0, cptOverlapProcessor);
	}
	
	protected GameEntityOverlappable createGameEntityOverlappable() {
		return new GameEntityOverlappable();
	}
	
	protected GameEntityMoveBlocker createGameEntityMoveBlocker() {
		return new GameEntityMoveBlocker();
	}
	
	public class GameEntityMoveBlocker implements GameEntity, MoveBlocker{
		
		@Override
		public Rectangle getBoundingBox() {
			return null;
		}

		@Override
		public void draw(Graphics g) {}

		@Override
		public boolean isMovable() {
			return false;
		}
	}
	
	public class GameEntityOverlappable implements GameEntity, Overlappable{
		
		@Override
		public Rectangle getBoundingBox() {
			return null;
		}

		@Override
		public void draw(Graphics g) {}

		@Override
		public boolean isMovable() {
			return false;
		}

		@Override
		public Point getPosition() {
			return null;
		}
	}
	
	// add a count to test
	// we don't need to do the super call OverlapProcessorDefaultImpl.addOverlappable in this context of unit tests
	// we don't need to do OverlapProcessorDefaultImpl.removeOverlappable too
	public class OverlapProcessorTest extends OverlapProcessorDefaultImpl {
		@Override
		public void addOverlappable(Overlappable p) {
			cptOverlapProcessor++;
		}

		@Override
		public void removeOverlappable(Overlappable p) {
			cptOverlapProcessor--;
		}
	}
	
	// add a count to test
	public class MoveBlockerCheckerTest extends MoveBlockerCheckerDefaultImpl {
		@Override
		public void addMoveBlocker(MoveBlocker p) {
			cptMoveBlockerChecker++;
		}

		@Override
		public void removeMoveBlocker(MoveBlocker p) {
			cptMoveBlockerChecker--;
		}
	}
	
	// it's necessary to change the configuration to test
	public class GameConfigurationTest extends GameConfiguration {
		public OverlapProcessor createOverlapProcessor() {
			return new OverlapProcessorTest();
		}
		
		public MoveBlockerChecker createMoveBlockerChecker() {
			return new MoveBlockerCheckerTest();
		}
	}

}
