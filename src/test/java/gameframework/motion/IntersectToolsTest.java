package gameframework.motion;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class IntersectToolsTest extends GameMovable {

	private Point direction;
	private final Point position = new Point(0, 0);
	private final int height = 2;
	private final int width = 3;
	private int speed = 4;

	@Test
	public void gotoWest() throws Exception {
		direction = new Point(1, 0);
		assertShape(0, 0, width + speed, height);
	}

	@Test
	public void gotoEast() throws Exception {
		direction = new Point(-1, 0);
		assertShape(-speed, 0, width, height);
	}

	@Test
	public void gotoEastWithNegativeSpeed() throws Exception {
		direction = new Point(1, 0);
		speed = -4;
		assertShape(speed, 0, width, height);
	}

	@Test
	public void gotoSouth() throws Exception {
		direction = new Point(0, 1);
		assertShape(0, 0, width, height + speed);
	}

	@Test
	public void gotoNorth() throws Exception {
		direction = new Point(0, -1);
		assertShape(0, -speed, width, height);
	}

	@Test
	public void gotoNorthWest() throws Exception {
		direction = new Point(-1, -1);
		assertShape(//
				new Point(-speed, -speed), //
				new Point(-speed, -speed + height), //
				new Point(width, height));
	}

	@Test
	public void gotoNorthEast() throws Exception {
		direction = new Point(1, -1);
		assertShape(//
				new Point(speed + width, -speed), //
				new Point(speed + width, -speed + height), //
				new Point(0, height));
	}

	@Test
	public void gotoSouthWest() throws Exception {
		direction = new Point(-1, 1);
		assertShape(//
				new Point(-speed, speed), //
				new Point(-speed, speed + height), //
				new Point(width, 0));
	}

	@Test
	public void gotoSouthEast() throws Exception {
		direction = new Point(1, 1);
		assertShape(//
				new Point(speed + width, speed + height), //
				new Point(speed + width, speed), //
				new Point(0, 0));
	}

	@Test
	public void dontMove() throws Exception {
		direction = new Point(0, 0);
		assertShape(0, 0, width, height);
	}

	@Test
	public void gotoSomewhereElse() throws Exception {
		// this is something like East-South-East
		int directionX = 2;
		int directionY = 1;
		direction = new Point(directionX, directionY);
		assertShape(//
				new Point(directionX * speed + width, directionY * speed
						+ height), //
				new Point(directionX * speed + width, directionY * speed), //
				new Point(0, 0));
	}

	private void assertShape(Point... points) {
		Shape intersectShape = createIntersectionShape();
		assertTrue(intersectShape instanceof Polygon);
		Polygon polygon = (Polygon) intersectShape;
		for (Point point : points) {
			assertPolygonHasVertex(polygon, point);
		}
	}

	private void assertPolygonHasVertex(Polygon polygon, Point point) {
		for (int i = 0; i < polygon.npoints; i++) {
			if (new Point(polygon.xpoints[i], polygon.ypoints[i]).equals(point))
				return;
		}
		fail("Point " + point + " is not in polygon");
	}

	private void assertShape(int x1, int y1, int x2, int y2) {
		Shape intersectShape = createIntersectionShape();
		assertTrue(intersectShape instanceof Rectangle);
		Rectangle rectangle = (Rectangle) intersectShape;
		assertEquals(new Point(x1, y1), rectangle.getLocation());
		assertEquals(new Dimension(x2 - x1, y2 - y1), rectangle.getSize());
	}

	private Shape createIntersectionShape() {
		return IntersectTools.getIntersectShape(this, new SpeedVector(
				direction, speed));
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public SpeedVector getSpeedVector() {
		return new SpeedVector(direction, speed);
	}

	@Override
	public Rectangle getBoundingBox() {
		return new Rectangle(position, new Dimension(width, height));
	}

	@Override
	public void oneStepMove() {
		fail("No need to move this movable");
	}

	@Override
	public void setSpeedVector(SpeedVector m) {
		fail("No need to set the speed vector");
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		fail("No need to add a behavior");
	}
}
