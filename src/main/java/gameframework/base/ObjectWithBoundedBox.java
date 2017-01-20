package gameframework.base;

import java.awt.Rectangle;

/**
 * This interface is used to represents the bounding box of entities or objects.
 *
 */
public interface ObjectWithBoundedBox {
	
	/**
	 * 
	 * @return a Rectangle representing the "hitbox" of the entity
	 */
	Rectangle getBoundingBox();
	
	/**
	 * 
	 * @return true if the entity can be moved, false otherwise
	 */
	public boolean isMovable();
}
