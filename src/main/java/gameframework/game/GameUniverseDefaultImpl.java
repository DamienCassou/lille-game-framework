package gameframework.game;

import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.Overlappable;
import gameframework.motion.GameMovable;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class GameUniverseDefaultImpl implements GameUniverse {
	protected ConcurrentLinkedQueue<GameEntity> gameEntities = new ConcurrentLinkedQueue<GameEntity>();
	protected GameData data;

	@Override
	public Iterator<GameEntity> getGameEntitiesIterator() {
		return gameEntities.iterator();
	}

	@Override
	public synchronized void addGameEntity(GameEntity gameEntity) {
		gameEntities.add(gameEntity);
		if (gameEntity instanceof Overlappable) {
			getOverlapProcessor().addOverlappable((Overlappable) gameEntity);
		}
		if (gameEntity instanceof MoveBlocker) {
			getMoveBlockerChecker().addMoveBlocker((MoveBlocker) gameEntity);
		}
	}

	@Override
	public synchronized void removeGameEntity(GameEntity gameEntity) {
		gameEntities.remove(gameEntity);
		if (gameEntity instanceof Overlappable) {
			getOverlapProcessor().removeOverlappable((Overlappable) gameEntity);
		}
		if (gameEntity instanceof MoveBlocker) {
			getMoveBlockerChecker().removeMoveBlocker((MoveBlocker) gameEntity);
		}
	}

	@Override
	public void allOneStepMoves() {
		for (GameEntity entity : gameEntities) {
			if (entity.isMovable()) {
				((GameMovable) entity).oneStepMove();
			}
		}
	}

	@Override
	public void processAllOverlaps() {
		getOverlapProcessor().processOverlapsAll();
	}

	protected MoveBlockerChecker getMoveBlockerChecker() {
		return data.getMoveBlockerChecker();
	}

	protected OverlapProcessor getOverlapProcessor() {
		return data.getOverlapProcessor();
	}

	@Override
	public void setGameData(GameData data) {
		this.data = data;
	}

}
