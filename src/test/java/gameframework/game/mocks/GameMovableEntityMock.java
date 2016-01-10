package gameframework.game.mocks;

import java.awt.Point;
import java.awt.Rectangle;

import gameframework.motion.Movable;
import gameframework.motion.SpeedVector;
import gameframework.motion.blocking.MoveBlocker;

public class GameMovableEntityMock extends GameEntityMock implements Movable {

	protected SpeedVector speedVector;
	protected Boolean stateStepMove = false;
	
	
	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle();
	}

	@Override
	public Point getPosition() {
		return new Point(0,0);
	}

	@Override
	public SpeedVector getSpeedVector() {
		return speedVector;
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		speedVector = m;
	}

	@Override
	public void oneStepMove() {
		stateStepMove = true;
	}
	
	public Boolean getStateStepMove() {
		return stateStepMove;
	}
	
	public void setStateStepMove(Boolean state) {
		stateStepMove = state;
	}
}
