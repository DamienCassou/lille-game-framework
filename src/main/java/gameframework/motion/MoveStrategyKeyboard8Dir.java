package gameframework.motion;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed. It is
 * possible to move to 8 directions. It is not possible to continue moving when
 * the keys are released
 * 
 * @author Arnaud Cojez
 */
public class MoveStrategyKeyboard8Dir extends MoveStrategyKeyboard {

	// Methods

	/**
	 * Constructor for the MoveStrategyKeyboard8Dir class
	 */
	public MoveStrategyKeyboard8Dir() {
		super(new SpeedVector(new Point(0, 0)));
	}

	/**
	 * Constructor for the MoveStrategyKeyboard8Dir class
	 * 
	 * @param speedVector
	 *            the speedVector we want to set to the Strategy
	 */
	public MoveStrategyKeyboard8Dir(SpeedVector speedVector) {
		super(speedVector);
	}

	/**
	 * Processes the direction according to the key pressed
	 * @param keyCode
	 */
	public void keyPressed(int keyCode) {
		int x = speedVector.getDirection().x;
		int y = speedVector.getDirection().y;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			x++;
			break;
		case KeyEvent.VK_LEFT:
			x--;
			break;
		case KeyEvent.VK_UP:
			y--;
			break;
		case KeyEvent.VK_DOWN:
			y++;
			break;
		}
		move(new Point(x, y));

	}

	/**
	 * Move according to the point parameter
	 * @param point 
	 */
	private void move(Point point) {
		speedVector.setDirection(point);
	}

	/**
	 * Processes the direction according to the key released
	 * @param keyCode
	 */
	public void keyReleased(int keyCode) {
		int x = speedVector.getDirection().x;
		int y = speedVector.getDirection().y;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			x--;
			break;
		case KeyEvent.VK_LEFT:
			x++;
			break;
		case KeyEvent.VK_UP:
			y++;
			break;
		case KeyEvent.VK_DOWN:
			y--;
			break;
		}
		move(new Point(x, y));
	}

}
