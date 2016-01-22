package gameframework.game.mocks;

import java.awt.Graphics;

import gameframework.game.GameEntity;

public class GameEntityMock implements GameEntity {

	protected boolean isMovable = false;
	
	@Override
	public void draw(Graphics g) {
			
	}

	public void setIsMovable(boolean value) {
		isMovable = value;
	}
	
	@Override
	public boolean isMovable() {
		return isMovable;
	}
}