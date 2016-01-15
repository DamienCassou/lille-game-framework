package gameframework.motion.overlapping;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class OverlapRulesApplierDefaultImplTest {

	int rulesApplied = 0;
	OverlapRulesApplierDefaultImpl ruleApplier;
	boolean ruleShouldCrash = false;
	String error_message = "Something bad happened";

	@Before
	public void createRuleApplier() {
		ruleApplier = new OverlapRulesApplierDefaultImpl() {

			@SuppressWarnings("unused")
			// this method is only called using reflection, tools can't see that
			public void overlapRule(Overlappable1 overlappable1,
					Overlappable2 overlappable2) {
				rulesApplied++;
				if (ruleShouldCrash) {
					throw new RuntimeException(error_message);
				}
			}

		};
	}

	@Test
	public void testApplyRuleInCorrectOrder() {
		ruleApplier.applyOverlapRules(new Vector<Overlap>(Arrays
				.asList(new Overlap(//
						new Overlappable1(),//
						new Overlappable2()))));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testApplyRuleInReverseOrder() {
		ruleApplier.applyOverlapRules(new Vector<Overlap>(Arrays
				.asList(new Overlap(//
						new Overlappable2(), //
						new Overlappable1()))));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testApplyNonExistingRule() {
		ruleApplier.applyOverlapRules(new Vector<Overlap>(Arrays
				.asList(new Overlap(//
						new Overlappable1(), //
						new Overlappable1()))));
		assertEquals(0, rulesApplied);
	}

	@Test
	public void testApplyCrashingRule() {
		ruleShouldCrash = true;
		try {
			ruleApplier.applyOverlapRules(new Vector<Overlap>(Arrays
					.asList(new Overlap(//
							new Overlappable1(), //
							new Overlappable2()))));
			fail("Previous instruction should have crashed");
		} catch (RuntimeException e) {
			assertEquals(1, rulesApplied);
			assertTrue(e.getCause().getCause().getMessage()
					.matches(error_message));
		}
	}

}

class Overlappable1 implements Overlappable {

	@Override
	public Rectangle getBoundingBox() {
		return null;
	}

	@Override
	public Point getPosition() {
		return null;
	}

	@Override
	public boolean isMovable() {
		return false;
	}
}

class Overlappable2 implements Overlappable {

	@Override
	public Rectangle getBoundingBox() {
		return null;
	}

	@Override
	public Point getPosition() {
		return null;
	}

	@Override
	public boolean isMovable() {
		return false;
	}
}