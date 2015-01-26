package gameframework.motion;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class MoveStrategyKeyboard extends KeyAdapter implements MoveStrategy {
	protected SpeedVector speedVector;
	protected final Boolean alwaysMove;

	public MoveStrategyKeyboard() {
		this(true);
	}

	public MoveStrategyKeyboard(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0)));
	}

	public MoveStrategyKeyboard(SpeedVector speedVector) {
		this(true, speedVector);
	}

	/**
	 * @param alwaysMove is a boolean value that decide if a player moves continually or not. (True by default)
	 * @param speedVector is a given custom speedVector for the strategy.
	 */
	public MoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		this.alwaysMove = alwaysMove;
		this.speedVector = speedVector;
	}

	@Override
	public SpeedVector getSpeedVector() {
		return speedVector;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}

	public void keyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			goRight();
			break;
		case KeyEvent.VK_LEFT:
			goLeft();
			break;
		case KeyEvent.VK_UP:
			goUp();
			break;
		case KeyEvent.VK_DOWN:
			goDown();
			break;
		default:
			stay();
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		keyReleased(event.getKeyCode());
	}

	public void keyReleased(int keyCode) {
		if (!alwaysMove) {
			stay();
		}
	}

	public void goRight() {
		speedVector.setDirection(new Point(1, 0));
	}

	public void goLeft() {
		speedVector.setDirection(new Point(-1, 0));
	}

	public void goUp() {
		speedVector.setDirection(new Point(0, -1));
	}

	public void goDown() {
		speedVector.setDirection(new Point(0, 1));
	}

	public void stay() {
		speedVector.setDirection(new Point(0, 0));
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
