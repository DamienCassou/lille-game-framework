package gameframework.motion.overlapping;

import gameframework.base.ObjectWithBoundedBox;

import java.awt.Point;

/**
 * This interface represent the entities that can overlap others
 *
 */
public interface Overlappable extends ObjectWithBoundedBox {
	public Point getPosition();
}
