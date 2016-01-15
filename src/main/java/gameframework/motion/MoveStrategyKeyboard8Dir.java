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
		super(true);
	}

	public MoveStrategyKeyboard8Dir(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0)));
	}

	/**
	 * {@link MoveStrategyKeyboard#MoveStrategyKeyboard(Boolean, SpeedVector)}
	 */
	public MoveStrategyKeyboard8Dir(Boolean alwaysMove, SpeedVector speedVector) {
		super(alwaysMove, speedVector);
	}

	/**
	 * Processes the direction according to the key pressed
	 * 
	 * @param keyCode
	 *            the code of the key pressed
	 */
	@Override
	public void keyPressed(int keyCode) {
		int x = speedVector.getDirection().x;
		int y = speedVector.getDirection().y;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			x = 1;
			break;
		case KeyEvent.VK_LEFT:
			x = -1;
			break;
		case KeyEvent.VK_UP:
			y = -1;
			break;
		case KeyEvent.VK_DOWN:
			y = 1;
			break;
		default:
			return;
		}
		move(new Point(x, y));

	}

	/**
	 * Move according to the point parameter
	 * 
	 * @param point
	 *            the new direction of the movement
	 */
	private void move(Point point) {
		speedVector.setDirection(point);
	}

	/**
	 * Processes the direction according to the key released
	 * 
	 * @param keyCode
	 *            the code of the key released
	 */
	@Override
	public void keyReleased(int keyCode) {
		if (!alwaysMove) {
			int x = speedVector.getDirection().x;
			int y = speedVector.getDirection().y;
			switch (keyCode) {
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_LEFT:
				x = 0;
				break;
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				y = 0;
				break;
			default:
				return;
			}
			move(new Point(x, y));
		}
	}

}
