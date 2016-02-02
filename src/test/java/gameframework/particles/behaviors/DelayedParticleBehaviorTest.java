package gameframework.particles.behaviors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import gameframework.particles.Particle;
import gameframework.particles.ParticleMock;

import java.awt.Color;
import java.awt.Rectangle;

import org.junit.Test;

public class DelayedParticleBehaviorTest extends ParticleBehaviorTest {

	@Override
	public ParticleBehavior createBehavior(ParticleBehavior parentBehavior) {
		return new DelayedParticleBehavior(parentBehavior, 2);
	}

	/**
	 * @see gameframework.particles.behaviors.ParticleBehaviorTest#isDrawnIntercepted()
	 */
	@Override
	public boolean isDrawnIntercepted() {
		// DelayedParticleBehavior intercept the call of isDrawn
		return true;
	}
	
	@Test
	public void firstParticleShouldBeDrawnInstantly() {
		Particle p = new ParticleMock(0, Color.BLACK, new Rectangle(), behavior);
		assertTrue(behavior.isDrawn(p));
	}
	
	@Test
	public void secondParticleShouldBeDrawnAfterDelayExpired() {
		Particle p = new ParticleMock(1, Color.BLACK, new Rectangle(), behavior);
		assertFalse(behavior.isDrawn(p));
		// Delay was set to 5 (according to createBehavior)
		p.setTimeAlive(5);
		assertTrue(behavior.isDrawn(p));
	}
	
}
