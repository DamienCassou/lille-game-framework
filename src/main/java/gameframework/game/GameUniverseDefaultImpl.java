package gameframework.game;

import gameframework.motion.Movable;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.Overlappable;

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
		addMotionEntity(gameEntity);
	}

	protected void addMotionEntity(GameEntity gameEntity) {
		
	}
	
	protected void addMotionEntity(Overlappable motionEntity) {
		getOverlapProcessor().addOverlappable(motionEntity);
	}
	
	protected void addMotionEntity(MoveBlocker motionEntity) {
		getMoveBlockerChecker().addMoveBlocker(motionEntity);
	}
	
	
	@Override
	public synchronized void removeGameEntity(GameEntity gameEntity) {
		gameEntities.remove(gameEntity);
		removeMotionEntity(gameEntity);
	}

	protected void removeMotionEntity(GameEntity gameEntity) {

	}
	
	protected void removeMotionEntity(Overlappable motionEntity) {
		getOverlapProcessor().removeOverlappable(motionEntity);
	}

	protected void removeMotionEntity(MoveBlocker motionEntity) {
		getMoveBlockerChecker().removeMoveBlocker(motionEntity);
	}
	

	@Override
	public void allOneStepMoves() {
		for (GameEntity entity : gameEntities) {
			onStepMove(entity);
		}
	}
	
	protected void onStepMove(GameEntity entity) {
		
	}
	
	protected void onStepMove(Movable entity) {
		entity.oneStepMove();
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
