package gameframework.motion.overlapping;

import gameframework.game.GameData;
import gameframework.motion.GameMovable;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OverlapProcessorDefaultImplTest {

	OverlapProcessorDefaultImpl overlapProcessor;
	Vector<Overlap> actualOverlaps;

	@Before
	public void createOverlapProcessor() {
		overlapProcessor = new OverlapProcessorDefaultImpl();
		overlapProcessor.setOverlapRules(new OverlapRulesApplier() {

			@Override
			public void applyOverlapRules(Vector<Overlap> overlaps) {
				actualOverlaps = overlaps;
			}

			@Override
			public void setGameData(GameData data) {
			}
		});
	}

	@Test
	public void twoOverlappingMovables() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);
		int width2 = 10;
		int height2 = 20;
		Overlappable overlappable2 = createOverlappableMovable(5, 0, width2,
				height2);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);

		overlapProcessor.processOverlapsAll();
		assertOverlaps(new Overlap(overlappable1, overlappable2));
	}

	@Test
	public void removingOverlappables() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);
		int width2 = 10;
		int height2 = 20;

		// first try with a movable
		Overlappable overlappable2 = createOverlappableMovable(5, 0, width2,
				height2);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);

		overlapProcessor.processOverlapsAll();
		assertOverlaps(new Overlap(overlappable1, overlappable2));

		overlapProcessor.removeOverlappable(overlappable2);
		overlapProcessor.processOverlapsAll();
		assertOverlaps();

		// then try with a non movable
		overlappable2 = createOverlappable(5, 0, width2, height2);
		overlapProcessor.addOverlappable(overlappable2);
		overlapProcessor.processOverlapsAll();
		assertOverlaps(new Overlap(overlappable1, overlappable2));

		overlapProcessor.removeOverlappable(overlappable2);
		overlapProcessor.processOverlapsAll();
		assertOverlaps();
	}

	@Test
	public void threeOverlappingMovables() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);

		int width2 = 10;
		int height2 = 20;
		Overlappable overlappable2 = createOverlappableMovable(5, 0, width2,
				height2);

		int width3 = 10;
		int height3 = 20;
		Overlappable overlappable3 = createOverlappableMovable(-6, 0, width3,
				height3);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);
		overlapProcessor.addOverlappable(overlappable3);

		overlapProcessor.processOverlapsAll();
		assertOverlaps(new Overlap(overlappable1, overlappable2), new Overlap(
				overlappable1, overlappable3));
	}

	@Test
	public void threeOverlappingMovablesThatAreAllOverlapping()
			throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);

		int width2 = 10;
		int height2 = 20;
		Overlappable overlappable2 = createOverlappableMovable(5, 0, width2,
				height2);

		int width3 = 10;
		int height3 = 20;

		// only difference with threeOverlappingMovables is the 'x' attribute
		// there:
		Overlappable overlappable3 = createOverlappableMovable(-4, 0, width3,
				height3);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);
		overlapProcessor.addOverlappable(overlappable3);

		overlapProcessor.processOverlapsAll();
		assertOverlaps(new Overlap(overlappable1, overlappable2), new Overlap(
				overlappable1, overlappable3), new Overlap(overlappable2,
				overlappable3));
	}

	@Test
	public void twoNonOverlappingMovables() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);
		int width2 = 10;
		int height2 = 20;
		Overlappable overlappable2 = createOverlappableMovable(1000, 1000,
				width2, height2);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);

		overlapProcessor.processOverlapsAll();
		assertOverlaps();
	}

	@Test
	public void twoNonOverlappingWithOneNonMovable() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);
		int width2 = 10;
		int height2 = 20;
		Overlappable overlappable2 = createOverlappable(1000, 1000, width2,
				height2);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);

		overlapProcessor.processOverlapsAll();
		assertOverlaps();
	}

	@Test
	public void twoOverlappingWithOneNonMovable() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);
		int width2 = 10;
		int height2 = 20;
		Overlappable overlappable2 = createOverlappable(5, 0, width2, height2);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable2);

		overlapProcessor.processOverlapsAll();
		assertOverlaps(new Overlap(overlappable1, overlappable2));
	}

	@Test
	public void twoIdenticalOverlappable() throws Exception {
		int width1 = 10;
		int height1 = 20;
		Overlappable overlappable1 = createOverlappableMovable(0, 0, width1,
				height1);

		overlapProcessor.addOverlappable(overlappable1);
		overlapProcessor.addOverlappable(overlappable1);

		overlapProcessor.processOverlapsAll();
		assertOverlaps();
	}

	void assertOverlaps(Overlap... overlaps) {
		// Because Overlap(a,b) should be seen as equivalent to Overlap(b,a),
		// this method is a bit complex. A better solution would be to implement
		// equals/hashCode in the Overlap class but this would require
		// implementing equals/hashCode for all overlappable classes : I don't
		// want to change this at this time.
		Set<Set<Overlappable>> actualOverlaps = getOverlaps(this.actualOverlaps);
		Set<Set<Overlappable>> expectedOverlaps = getOverlaps(Arrays
				.asList(overlaps));
		assertEquals(expectedOverlaps, actualOverlaps);
	}

	Set<Set<Overlappable>> getOverlaps(Collection<Overlap> overlaps) {
		Set<Set<Overlappable>> result = new HashSet<Set<Overlappable>>();
		for (Overlap overlap : overlaps) {
			result.add(overlap.getOverlappables());
		}
		return result;
	}

	public MovableOverlappable createOverlappableMovable(final int x,
			final int y, final int width, final int height) {
		return new MovableOverlappable() {

			@Override
			public Rectangle getBoundingBox() {
				return new Rectangle(x, y, width, height);
			}

			@Override
			public Point getPosition() {
				return new Point(x, y);
			}

		};
	}

	public Overlappable createOverlappable(final int x, final int y,
			final int width, final int height) {
		return new Overlappable() {

			@Override
			public Rectangle getBoundingBox() {
				return new Rectangle(x, y, width, height);
			}

			@Override
			public Point getPosition() {
				return new Point(x, y);
			}

			@Override
			public boolean isMovable() {
				return false;
			}

		};
	}

}

abstract class MovableOverlappable extends GameMovable implements Overlappable {
	@Override
	public void oneStepMoveAddedBehavior() {
	}
}