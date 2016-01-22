package gameframework.game.mocks;

import java.awt.Graphics;
import java.awt.Rectangle;

import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class GameMoveBlockerEntityMock implements GameEntity, MoveBlocker {

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle();
	}

	@Override
	public void draw(Graphics g) {

	}

	@Override
	public boolean isMovable() {
		return false;
	}
}
