package gameframework.game.mocks;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.SpeedVector;

public class GameMovableEntityMock extends GameMovable implements GameEntity {

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

	@Override
	public void oneStepMoveAddedBehavior() {
		
	}

	@Override
	public void draw(Graphics g) {
		
	}
}
