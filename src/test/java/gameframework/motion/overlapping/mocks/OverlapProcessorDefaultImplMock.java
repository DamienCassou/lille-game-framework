package gameframework.motion.overlapping.mocks;

import gameframework.game.GameEntity;
import gameframework.motion.overlapping.OverlapProcessorDefaultImpl;

public class OverlapProcessorDefaultImplMock extends OverlapProcessorDefaultImpl {

	public Boolean test_isAdding(GameEntity entity) {
		return this.nonMovableOverlappables.contains(entity) ||	this.movableOverlappables.contains(entity);
	}
}
