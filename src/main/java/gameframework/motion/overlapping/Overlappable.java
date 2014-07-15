package gameframework.motion.overlapping;

import gameframework.base.ObjectWithBoundedBox;

import java.awt.Point;

public interface Overlappable extends ObjectWithBoundedBox {
	public Point getPosition();
}
