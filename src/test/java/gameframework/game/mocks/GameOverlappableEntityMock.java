package gameframework.game.mocks;

import java.awt.Point;
import java.awt.Rectangle;

import gameframework.motion.overlapping.Overlappable;

public class GameOverlappableEntityMock extends GameEntityMock implements Overlappable {

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle();
	}

	@Override
	public Point getPosition() {
		return new Point(0, 0);
	}
}
