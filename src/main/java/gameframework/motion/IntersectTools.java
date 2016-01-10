package gameframework.motion;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Utility class providing static methods to compute intersections
 */
public class IntersectTools {

	/**
	 * Hides the constructor
	 */
	private IntersectTools() {
		super();
	}

	/**
	 * Return a polygonal zone (with max 6 sides) containing the whole path
	 * along the next step move.
	 * 
	 * @return Either a {@link java.awt.Rectangle rectangle} or an
	 *         {@link java.awt.Polygon hexagon}.
	 */
	public static Shape getIntersectShape(GameMovable movable,
			SpeedVector speedVector) {
		// Compute the intersection shape using the movable properties
		int dX = (int) speedVector.getDirection().getX();
		int dY = (int) speedVector.getDirection().getY();
		int v = speedVector.getSpeed();

		// We need the bounding box of the movable
		int x1 = (int) movable.getPosition().getX();
		int y1 = (int) movable.getPosition().getY();
		int x2 = x1 + (int) movable.getBoundingBox().getWidth();
		int y2 = y1 + (int) movable.getBoundingBox().getHeight();

		// We normalize the computation for negative speeds
		if (v < 0) {
			dX = -dX;
			dY = -dY;
			v = -v;
		}

		// We build the intersection polygon now
		// As usual we need to consider the 8 direction to build different kind
		// of shape
		Shape intersectShape;

		// If X or Y is not on axis
		if ((dX != 0) && (dY != 0)) {
			intersectShape = new Polygon();

			// If it is not in the first quarter of the plane
			if (!((dX < 0) && (dY > 0))) {
				((Polygon) intersectShape).addPoint(x1, y1);
				((Polygon) intersectShape).addPoint(x2 + dX * v, y2 + dY * v);
			}
			// If it is not in the fourth quarter of the plane
			if (!((dX > 0) && (dY < 0))) {
				((Polygon) intersectShape).addPoint(x2, y2);
				((Polygon) intersectShape).addPoint(x1 + dX * v, y1 + dY * v);
			}
			// If it is not in the third quarter of the plane
			if (!((dX < 0) && (dY < 0))) {
				((Polygon) intersectShape).addPoint(x1, y2);
				((Polygon) intersectShape).addPoint(x2 + dX * v, y1 + dY * v);
			}
			// If it is not in the second quarter of the plane
			if (!((dX > 0) && (dY > 0))) {
				((Polygon) intersectShape).addPoint(x2, y1);
				((Polygon) intersectShape).addPoint(x1 + dX * v, y2 + dY * v);
			}
		}
		// And now the axis
		else if ((dX == 0) && (dY > 0)) {
			intersectShape = new Rectangle(x1, y1, x2 - x1, y2 - y1 + dY * v);
		} else if (dY < 0) { // we know that dX == 0
			intersectShape = new Rectangle(x1, y1 + dY * v, x2 - x1, y2 - (y1 + dY * v));
		} else if (dX > 0) { // we know that dY == 0
			intersectShape = new Rectangle(x1, y1, x2 - x1 + dX * v, y2 - y1);
		} else if (dX < 0) { // we know that dY == 0
			intersectShape = new Rectangle(x1 + dX * v, y1, x2 - (x1 + dX * v), y2 - y1);
		} else {
			intersectShape = new Rectangle(x1, y1, x2 - x1, y2 - y1);
		}
		return intersectShape;

	}

}
