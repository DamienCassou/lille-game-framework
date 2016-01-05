package gameframework.motion.overlapping;

import gameframework.motion.IntersectTools;
import gameframework.motion.SpeedVector;
import gameframework.motion.GameMovable;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentLinkedQueue;

public class OverlapProcessorDefaultImpl implements OverlapProcessor {

	/**
	 * These two lists contain all overlappables for which we want to compute
	 * overlaps. We distinguish between movable and non-movable because two
	 * non-movables never overlap.
	 */
	protected ConcurrentLinkedQueue<Overlappable> nonMovableOverlappables;
	protected ConcurrentLinkedQueue<Overlappable> movableOverlappables;

	protected OverlapRulesApplier overlapRules;

	public OverlapProcessorDefaultImpl() {
		nonMovableOverlappables = new ConcurrentLinkedQueue<Overlappable>();
		movableOverlappables = new ConcurrentLinkedQueue<Overlappable>();
	}

	@Override
	public void addOverlappable(Overlappable p) {
		if (p.isMovable()) {
			movableOverlappables.add(p);
		} else {
			nonMovableOverlappables.add(p);
		}
	}

	@Override
	public void removeOverlappable(Overlappable p) {
		if (p.isMovable()) {
			movableOverlappables.remove(p);
		} else {
			nonMovableOverlappables.remove(p);
		}
	}

	@Override
	public void setOverlapRules(OverlapRulesApplier overlapRules) {
		this.overlapRules = overlapRules;
	}

	// for optimization purpose : prevents to compute two times the overlaps
	private List<Overlappable> movablesTmp;

	@Override
	public void processOverlapsAll() {
		Vector<Overlap> overlaps = new Vector<Overlap>();

		movablesTmp = new Vector<Overlappable>(movableOverlappables);
		for (Overlappable movableOverlappable : movableOverlappables) {
			movablesTmp.remove(movableOverlappable);
			computeOneOverlap(movableOverlappable, overlaps);
		}
		overlapRules.applyOverlapRules(overlaps);
	}

	protected void computeOneOverlap(Overlappable movableOverlappable,
			Vector<Overlap> overlaps) {
		Area overlappableArea, targetArea;
		Rectangle boundingBoxTarget, boundingBoxOverlappable;
		assert movableOverlappable.isMovable();
		Shape intersectShape = intersectionComputation(movableOverlappable);

		overlappableArea = new Area(intersectShape);
		boundingBoxOverlappable = intersectShape.getBounds();

		for (Overlappable targetNonMovableOverlappable : nonMovableOverlappables) {
			if (targetNonMovableOverlappable != movableOverlappable) {
				// NOTE I don't see how this test could fail
				Shape targetShape;
				targetShape = targetNonMovableOverlappable.getBoundingBox();
				boundingBoxTarget = targetShape.getBounds();

				if (boundingBoxOverlappable.intersects(boundingBoxTarget)) {
					targetArea = new Area(targetShape);
					targetArea.intersect(overlappableArea);
					if (!targetArea.isEmpty()) {
						// NOTE I don't see how this test could fail
						overlaps.add(new Overlap(movableOverlappable,
								targetNonMovableOverlappable));
					}
				}
			}
		}

		for (Overlappable targetOverlappable : movablesTmp) {
			if (targetOverlappable != movableOverlappable) {
				Shape targetShape;
				targetShape = IntersectTools.getIntersectShape(
						(GameMovable) targetOverlappable, new SpeedVector(
								((GameMovable) targetOverlappable).getSpeedVector()
										.getDirection(),
								-((GameMovable) targetOverlappable)
										.getSpeedVector().getSpeed()));
				boundingBoxTarget = targetShape.getBounds();

				if (boundingBoxOverlappable.intersects(boundingBoxTarget)) {
					targetArea = new Area(targetShape);
					targetArea.intersect(overlappableArea);
					if (!targetArea.isEmpty()) {
						// NOTE I don't see how this test could fail
						overlaps.add(new Overlap(movableOverlappable,
								targetOverlappable));
					}
				}
			}
		}
	}

	protected Shape intersectionComputation(Overlappable movableOverlappable) {
		assert movableOverlappable.isMovable();
		GameMovable movable = (GameMovable) movableOverlappable;
		SpeedVector speedVector = movable.getSpeedVector();
		SpeedVector oppositeSpeedVector = new SpeedVector(
				speedVector.getDirection(), -1 * speedVector.getSpeed());
		return IntersectTools.getIntersectShape(movable, oppositeSpeedVector);

	}
}
