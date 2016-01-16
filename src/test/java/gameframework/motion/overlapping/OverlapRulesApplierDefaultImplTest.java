package gameframework.motion.overlapping;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Arrays;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import gameframework.motion.overlapping.mocks.OverlappableMock;
import gameframework.motion.overlapping.mocks.OverlappableMovableMock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class OverlapRulesApplierDefaultImplTest {

	protected int rulesApplied = 0;
	protected OverlapRulesApplierDefaultImpl ruleApplier;
	protected boolean ruleShouldCrash = false;
	protected String error_message = "Something bad happened";

	protected OverlappableMock overlappable;
	protected OverlappableMovableMock overlappableMovable;

	@Before
	public void createRuleApplier() {
		overlappable 		= new OverlappableMock();
		overlappableMovable = new OverlappableMovableMock();
		ruleApplier 		= new OverlapRulesApplierDefaultImpl() {

			@SuppressWarnings("unused")
			// this method is only called using reflection, tools can't see that
			public void overlapRule(
					OverlappableMock overlappable,
					OverlappableMovableMock overlappableMovable )
			{
				rulesApplied++;
				if (ruleShouldCrash) {
					throw new RuntimeException(error_message);
				}
			}
		};
	}

	@Test
	public void testApplyRuleInCorrectOrder() {
		ruleApplier.applyOverlapRules(
			new Vector<Overlap>(Arrays.asList(
					new Overlap(overlappable, overlappableMovable)
				)));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testApplyRuleInReverseOrder() {
		ruleApplier.applyOverlapRules(
			new Vector<Overlap>(Arrays.asList(
					new Overlap(overlappableMovable, overlappable)
				)));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testApplyNonExistingRule() {
		ruleApplier.applyOverlapRules(
			new Vector<Overlap>(Arrays.asList(
					new Overlap(overlappable, overlappable)
				)));
		assertEquals(0, rulesApplied);
	}

	@Test
	public void testApplyCrashingRule() {
		ruleShouldCrash = true;
		try {
			ruleApplier.applyOverlapRules(
				new Vector<Overlap>(Arrays.asList(
						new Overlap(overlappable, overlappableMovable)
					)));
			fail("Previous instruction should have crashed");
		} catch (RuntimeException e) {
			assertEquals(1, rulesApplied);
			assertTrue(e.getCause().getCause().getMessage()
					.matches(error_message));
		}
	}

}