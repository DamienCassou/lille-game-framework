package gameframework.motion.blocking;

import gameframework.motion.IntersectTools;
import gameframework.motion.GameMovable;
import gameframework.motion.SpeedVector;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Default implementation of the MoveBLockerChecker interface. For more informations,
 * please refer to the MoveBlockerChecker interface.
 */
public class MoveBlockerCheckerDefaultImpl implements MoveBlockerChecker {
	/**
	 * A queue containing all the moveBlockers to check for when verifying if a
	 * GameMovable can move
	 */
	protected ConcurrentLinkedQueue<MoveBlocker> moveBlockers;

	/**
	 * The rule applier used when checking if a GameMovable can move
	 */
	protected MoveBlockerRulesApplier moveBlockerRuleApplier;

	public MoveBlockerCheckerDefaultImpl() {
		moveBlockers = new ConcurrentLinkedQueue<MoveBlocker>();
		this.moveBlockerRuleApplier = new MoveBlockerRulesApplierDefaultImpl();
	}

	/**
	 * @see gameframework.motion.blocking.MoveBlockerChecker#addMoveBlocker(gameframework.motion.blocking.MoveBlocker)
	 */
	@Override
	public void addMoveBlocker(MoveBlocker p) {
		moveBlockers.add(p);
	}

	/**
	 * @see gameframework.motion.blocking.MoveBlockerChecker#removeMoveBlocker(gameframework.motion.blocking.MoveBlocker)
	 */
	@Override
	public void removeMoveBlocker(MoveBlocker p) {
		moveBlockers.remove(p);
	}

	/**
	 * @see gameframework.motion.blocking.MoveBlockerChecker#setMoveBlockerRules(gameframework.motion.blocking.MoveBlockerRulesApplier)
	 */
	@Override
	public void setMoveBlockerRules(MoveBlockerRulesApplier moveBlockerRules) {
		this.moveBlockerRuleApplier = moveBlockerRules;
	}

	/**
	 * @see gameframework.motion.blocking.MoveBlockerChecker#moveValidation(gameframework.motion.GameMovable, gameframework.motion.SpeedVector)
	 */
	@Override
	public boolean moveValidation(GameMovable m, SpeedVector mov) {
		Shape intersectShape = IntersectTools.getIntersectShape(m, mov);
		Vector<MoveBlocker> moveBlockersInIntersection = new Vector<MoveBlocker>();
		Area intersectArea = new Area(intersectShape);
		Rectangle tmpIntersec = (intersectShape.getBounds());

		for (MoveBlocker moveBlocker : moveBlockers) {
			Rectangle tmpB = moveBlocker.getBoundingBox();
			if (m != moveBlocker && tmpIntersec.intersects(tmpB)) {
				Area tmpArea = new Area(tmpB);
				tmpArea.intersect(intersectArea);
				if (!tmpArea.isEmpty()) {
					// NOTE I don't understand how this test can fail. To me,
					// if tmpIntersec intersects with tmpB then tmpArea is not
					// empty
					moveBlockersInIntersection.add(moveBlocker);
				}
			}
		}

		if (!moveBlockersInIntersection.isEmpty()) {
			return moveBlockerRuleApplier.moveValidationProcessing(m,
					moveBlockersInIntersection);
		}

		return true;
	}
}
