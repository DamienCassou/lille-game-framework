package gameframework.motion.overlapping;

import gameframework.motion.overlapping.mocks.OverlappableMock;
import gameframework.motion.overlapping.mocks.OverlappableMovableMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

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
				new ArrayList<>(Collections.singletonList(
					new Overlap(overlappable, overlappableMovable)
				)));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testApplyRuleInReverseOrder() {
		ruleApplier.applyOverlapRules(
				new ArrayList<>(Collections.singletonList(
						new Overlap(overlappableMovable, overlappable)
				)));
		assertEquals(1, rulesApplied);
	}

	@Test
	public void testApplyNonExistingRule() {
		ruleApplier.applyOverlapRules(
				new ArrayList<>(Collections.singletonList(
					new Overlap(overlappable, overlappable)
				)));
		assertEquals(0, rulesApplied);
	}

	@Test
	public void testApplyCrashingRule() {
		ruleShouldCrash = true;
		try {
			ruleApplier.applyOverlapRules(
					new ArrayList<>(Collections.singletonList(
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