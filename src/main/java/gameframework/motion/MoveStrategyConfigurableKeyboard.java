package gameframework.motion;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class MoveStrategyConfigurableKeyboard extends KeyAdapter implements MoveStrategy {
	/* Used to store the direction and speed currently applied */
	protected SpeedVector speedVector;
	
	/* Used to know if we should still move even when all the keys are up */
	protected final Boolean alwaysMove;
	
	/* Used to associate a key with a direction */
	protected Map<Integer, Point> directions;
	
	/* Used to remember every pressed key */
	protected Set<Integer> keyPressed;
	
	/* Used to know if we combine the directions when multiple keys are pressed */
	protected boolean combineDirections;

	public MoveStrategyConfigurableKeyboard() {
		this(true);
	}

	/**
	 * @param alwaysMove is a boolean value that decides if a player moves continually or not. (so even if the keys are released,
	 *  the object will still move in the last direction he was) (True by default)
	 */
	public MoveStrategyConfigurableKeyboard(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0)));
	}

	/**
	 * @param speedVector is a given custom speedVector for the strategy.
	 */
	public MoveStrategyConfigurableKeyboard(SpeedVector speedVector) {
		this(true, speedVector);
	}
	
	/**
	 * @param alwaysMove is a boolean value that decides if a player moves continually or not. (so even if the keys are released,
	 *  the object will still move in the last direction he was) (True by default)
	 * @param speedVector is a given custom speedVector for the strategy.
	 */
	public MoveStrategyConfigurableKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		this(alwaysMove, speedVector, false);
	}

	/**
	 * @param alwaysMove is a boolean value that decides if a player moves continually or not. (so even if the keys are released,
	 *  the object will still move in the last direction he was) (True by default)
	 * @param speedVector is a given custom speedVector for the strategy.
	 * @param combineDirections is a boolean value that decides if directions are combined (so if this is true and the player press 
	 *  the key for direction (0, -1) and the key for (1, 0) then this will result in moving in the direction (1, -1))
	 */
	public MoveStrategyConfigurableKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		this.alwaysMove = alwaysMove;
		this.speedVector = speedVector;
		this.directions = new HashMap<>();
		this.keyPressed = new HashSet<>();
		this.combineDirections = combineDirections;
	}
	
	/**
	 * Adds a direction controlled by a key
	 * @param key The key associated with the direction
	 * @param direction The direction used when the key is pressed
	 */
	public void addKeyDirection(int key, Point direction) {
		directions.put(key, direction);
	}

	@Override
	public SpeedVector getSpeedVector() {
		return speedVector;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}
	
	@Override
	public void keyReleased(KeyEvent event) {
		keyReleased(event.getKeyCode());
	}
	
	protected void keyPressed(int keyCode) {
		keyPressed.add(keyCode);
		updateDirection();
	}
	
	protected void keyReleased(int keyCode) {
		keyPressed.remove(keyCode);
		updateDirection();
	}
	
	/**
	 * Update the direction depending on the keys pressed
	 */
	protected void updateDirection() {
		final Point newDirection = new Point(0, 0);
		
		for (Integer keyCode : keyPressed) {
			final Point keyDirection = directions.get(keyCode);
			if (keyDirection != null) {
				newDirection.x += keyDirection.x;
				newDirection.y += keyDirection.y;
				
				// If we don't combine directions, then we should stop here
				if (!combineDirections) {
					break;
				}
			}
		}
		
		if (newDirection.x != 0 || newDirection.y != 0 || !alwaysMove)
			speedVector.setDirection(newDirection);
	}

	@Override
	public int getSpeed() {
		return this.speedVector.getSpeed();
	}

	@Override
	public void setSpeed(int speed) {
		this.speedVector.setSpeed(speed);
	}
}
