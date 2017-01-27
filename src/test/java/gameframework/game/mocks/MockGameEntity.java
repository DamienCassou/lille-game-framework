package gameframework.game.mocks;

import java.awt.Graphics;

import gameframework.game.GameEntity;

public class MockGameEntity implements GameEntity {

	@Override
	public void draw(Graphics g) {
	}

	@Override
	public boolean isMovable() {
		return false;
	}

}
