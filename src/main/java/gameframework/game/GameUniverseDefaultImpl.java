package gameframework.game;

import gameframework.motion.Movable;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.Overlappable;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameUniverseDefaultImpl implements GameUniverse {
	private ConcurrentLinkedQueue<GameEntity> gameEntities = new ConcurrentLinkedQueue<GameEntity>();
	private OverlapProcessor overlapProcessor;
	private MoveBlockerChecker moveBlockerChecker;

	@Override
	public Iterator<GameEntity> gameEntities() {
		return gameEntities.iterator();
	}

	public GameUniverseDefaultImpl(MoveBlockerChecker obs, OverlapProcessor col) {
		overlapProcessor = col;
		moveBlockerChecker = obs;
	}

	@Override
	public synchronized void addGameEntity(GameEntity gameEntity) {
		gameEntities.add(gameEntity);
		if (gameEntity instanceof Overlappable) {
			overlapProcessor.addOverlappable((Overlappable) gameEntity);
		}
		if (gameEntity instanceof MoveBlocker) {
			moveBlockerChecker.addMoveBlocker((MoveBlocker) gameEntity);
		}
	}

	@Override
	public synchronized void removeGameEntity(GameEntity gameEntity) {
		gameEntities.remove(gameEntity);
		if (gameEntity instanceof Overlappable) {
			overlapProcessor.removeOverlappable((Overlappable) gameEntity);
		}
		if (gameEntity instanceof MoveBlocker) {
			moveBlockerChecker.removeMoveBlocker((MoveBlocker) gameEntity);
		}
	}

	@Override
	public void allOneStepMoves() {
		for (GameEntity entity : gameEntities) {
			if (entity instanceof Movable) {
				((Movable) entity).oneStepMove();
			}
		}
	}

	@Override
	public void processAllOverlaps() {
		overlapProcessor.processOverlapsAll();
	}

}
