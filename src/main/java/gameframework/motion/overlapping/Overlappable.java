package gameframework.motion.overlapping;

import gameframework.base.ObjectWithBoundedBox;

import java.awt.Point;

/**
 * This interface represent the entities that can overlap others.
 * Two entities are overlapping when their bounded box are one on eachother.
 * Overlappable entities must have a position, returned by the getPosition() method.
 *
 */
public interface Overlappable extends ObjectWithBoundedBox {
	public Point getPosition();
}
