package gameframework.game;

import gameframework.base.IntersectTools;
import gameframework.base.Movable;
import gameframework.base.Overlap;
import gameframework.base.Overlappable;
import gameframework.base.SpeedVector;
import gameframework.base.SpeedVectorDefaultImpl;

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
	private ConcurrentLinkedQueue<Overlappable> overlappablesNonMovable;
	private ConcurrentLinkedQueue<Overlappable> overlappablesMovable;

	private OverlapRulesApplier overlapRules;

	public OverlapProcessorDefaultImpl() {
		overlappablesNonMovable = new ConcurrentLinkedQueue<Overlappable>();
		overlappablesMovable = new ConcurrentLinkedQueue<Overlappable>();
	}

	public void addOverlappable(Overlappable p) {
		if (p instanceof Movable) {
			overlappablesMovable.add(p);
		} else {
			overlappablesNonMovable.add(p);
		}
	}

	public void removeOverlappable(Overlappable p) {
		if (p instanceof Movable) {
			overlappablesMovable.remove(p);
		} else {
			overlappablesNonMovable.remove(p);
		}
	}

	public void setOverlapRules(OverlapRulesApplier overlapRules) {
		this.overlapRules = overlapRules;
	}

	// for optimization purpose : prevents to compute two times the overlaps
	private List<Overlappable> movablesTmp;

	public void processOverlapsAll() {
		Vector<Overlap> overlaps = new Vector<Overlap>();

		movablesTmp = new Vector<Overlappable>(overlappablesMovable);
		for (Overlappable overlappable : overlappablesMovable) {
			movablesTmp.remove(overlappable);
			computeOneOverlap(overlappable, overlaps);
		}
		overlapRules.applyOverlapRules(overlaps);
	}

	private void computeOneOverlap(Overlappable overlappable,
			Vector<Overlap> overlaps) {
		Area overlappableArea, targetArea;
		Rectangle boundingBoxTarget, boundingBoxOverlappable;

		Shape intersectShape = intersectionComputation(overlappable);

		overlappableArea = new Area(intersectShape);
		boundingBoxOverlappable = intersectShape.getBounds();

		for (Overlappable targetOverlappable : overlappablesNonMovable) {
			if (targetOverlappable != overlappable) {
				Shape targetShape;
				targetShape = targetOverlappable.getBoundingBox();
				boundingBoxTarget = targetShape.getBounds();

				if (boundingBoxOverlappable.intersects(boundingBoxTarget)) {
					targetArea = new Area(targetShape);
					targetArea.intersect(overlappableArea);
					if (!targetArea.isEmpty()) {
						overlaps.add(new Overlap(overlappable,
								targetOverlappable));
					}
				}
			}
		}

		for (Overlappable targetOverlappable : movablesTmp) {
			if (targetOverlappable != overlappable) {
				Shape targetShape;
				targetShape = IntersectTools.getIntersectShape(
						(Movable) targetOverlappable,
						new SpeedVectorDefaultImpl(
								((Movable) targetOverlappable).getSpeedVector()
										.getDirection(),
								-((Movable) targetOverlappable)
										.getSpeedVector().getSpeed()));
				boundingBoxTarget = targetShape.getBounds();

				if (boundingBoxOverlappable.intersects(boundingBoxTarget)) {
					targetArea = new Area(targetShape);
					targetArea.intersect(overlappableArea);
					if (!targetArea.isEmpty()) {
						overlaps.add(new Overlap(overlappable,
								targetOverlappable));
					}
				}
			}
		}
	}

	private Shape intersectionComputation(Overlappable overlappable) {
		if (overlappable instanceof Movable) {
			Movable movable = (Movable) overlappable;
			SpeedVector speedVector = movable.getSpeedVector();
			SpeedVectorDefaultImpl oppositeSpeedVector = new SpeedVectorDefaultImpl(
					speedVector.getDirection(), -1 * speedVector.getSpeed());
			return IntersectTools.getIntersectShape(movable,
					oppositeSpeedVector);
		} else {
			return overlappable.getBoundingBox();
		}
	}
}
