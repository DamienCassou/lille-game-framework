package gameframework.motion;

import java.awt.Point;
import java.awt.event.KeyEvent;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed.
 */
public class MoveStrategyKeyboard extends MoveStrategyConfigurableKeyboard {
	public MoveStrategyKeyboard() {
		this(true);
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(Boolean)}
	 */
	public MoveStrategyKeyboard(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0)));
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(SpeedVector)}
	 */
	public MoveStrategyKeyboard(SpeedVector speedVector) {
		this(true, speedVector);
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(Boolean, SpeedVector)}
	 */
	public MoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector) {
		this(alwaysMove, speedVector, false);
	}
	
	/**
	 * {@link MoveStrategyConfigurableKeyboard#MoveStrategyKeyboard(Boolean, SpeedVector, Boolean)}
	 */
	public MoveStrategyKeyboard(Boolean alwaysMove, SpeedVector speedVector, Boolean combineDirections) {
		super(alwaysMove, speedVector, combineDirections);
		
		addKeyDirection(KeyEvent.VK_RIGHT, new Point(1, 0));
		addKeyDirection(KeyEvent.VK_LEFT, new Point(-1, 0));
		addKeyDirection(KeyEvent.VK_DOWN, new Point(0, 1));
		addKeyDirection(KeyEvent.VK_UP, new Point(0, -1));
	}
}
