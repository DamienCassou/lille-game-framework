package gameframework.motion;

import java.awt.Point;

/**
 * {@link MoveStrategy} which listens to the keyboard and answers new
 * {@link SpeedVector speed vectors} based on what the user typed. It is
 * possible to move to 8 directions. It is not possible to continue moving when
 * the keys are released
 * 
 * @author Arnaud Cojez
 */
public class MoveStrategyKeyboard8Dir extends MoveStrategyKeyboard {
	/**
	 * Constructor for the MoveStrategyKeyboard8Dir class
	 */
	public MoveStrategyKeyboard8Dir() {
		this(true);
	}
	
	/**
	 * {@link MoveStrategyKeyboard#MoveStrategyKeyboard(Boolean)}
	 */
	public MoveStrategyKeyboard8Dir(Boolean alwaysMove) {
		this(alwaysMove, new SpeedVector(new Point(0, 0)));
	}

	/**
	 * {@link MoveStrategyKeyboard#MoveStrategyKeyboard(Boolean, SpeedVector)}
	 */
	public MoveStrategyKeyboard8Dir(Boolean alwaysMove, SpeedVector speedVector) {
		super(alwaysMove, speedVector, true);
	}
}