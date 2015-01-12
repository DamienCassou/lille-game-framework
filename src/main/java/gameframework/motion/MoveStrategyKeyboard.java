package gameframework.motion;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class MoveStrategyKeyboard extends KeyAdapter implements MoveStrategy {
	protected SpeedVector speedVector = new SpeedVector(new Point(0, 0));

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
			return;
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
}
