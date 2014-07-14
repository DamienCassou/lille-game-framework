package gameframework.game;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Manage sprite libraries by displaying the right sprite based on a set of
 * types and an increment for the animation.
 */
public interface SpriteManager {

	/**
	 * Set the different types that the entity being displayed can have. The
	 * types order must be the same as the one in the picture. For example, if
	 * in the picture the first row represents the entity going to the left and
	 * the second row represents the entity going to the right, you would call:
	 * <code>setTypes("left","right")</code>
	 */
	void setTypes(String... types);

	/**
	 * Set the current type the entity has. Throws an
	 * {@link IllegalArgumentException} if the type is not in the types list as
	 * set using {@link #setTypes(String...)}.
	 * 
	 * @param type
	 */
	void setType(String type);

	/**
	 * Draw the sprite at the given position. Uses the current type and
	 * increment to choose the right sprite to display.
	 * 
	 * @see #increment()
	 * @see #setType(String)
	 */
	void draw(Graphics g, Point position);

	/**
	 * Go to the next sprite in the animation without changing the type.
	 */
	void increment();

	/**
	 * Sets the increment to 0.
	 */
	void reset();

	/**
	 * Manually set the increment. You won't need that most of the time and will
	 * only require {@link #increment()}.
	 * 
	 * @see #increment()
	 */
	void setIncrement(int increment);

}
