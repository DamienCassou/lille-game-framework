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
	protected int keys[];

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
		this.keys = new int[4];
		this.keys[0] = KeyEvent.VK_UP;
		this.keys[1] = KeyEvent.VK_RIGHT;
		this.keys[2] = KeyEvent.VK_DOWN;
		this.keys[3] = KeyEvent.VK_LEFT;
	}

	@Override
	public SpeedVector getSpeedVector() {
		return speedVector;
	}

	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}

	public int getUpKey() {
		return this.keys[0];
	}

	public int getRightKey() {
		return this.keys[1];
	}

	public int getDownKey() {
		return this.keys[2];
	}

	public int getLeftKey() {
		return this.keys[3];
	}

	public void setUpKey(int keyCode) {
		this.keys[0] = keyCode;
	}

	public void setRightKey(int keyCode) {
		this.keys[1] = keyCode;
	}

	public void setDownKey(int keyCode) {
		this.keys[2] = keyCode;
	}

	public void setLeftKey(int keyCode) {
		this.keys[3] = keyCode;
	}

	public void keyPressed(int keyCode) {
		if (keyCode == this.getUpKey()) {
			goUp();
		} else if (keyCode == this.getRightKey()) {
			goRight();
		} else if (keyCode == this.getDownKey()) {
			goDown();
		} else if (keyCode == this.getLeftKey()) {
			goLeft();
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		keyReleased(event.getKeyCode());
	}

	public void keyReleased(int keyCode) {
		if (!alwaysMove) {
			int n = this.keys.length;
			for (int i = 0; i < n; i++) {
				if (keyCode == this.keys[i]) {
					stay();
					return;
				}
			}
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
