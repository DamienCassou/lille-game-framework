package gameframework.particles.behaviors;

import org.junit.Test;
import static org.junit.Assert.*;

public class DyingParticleBehaviorTest extends ParticleBehaviorTest {

	@Override
	public ParticleBehavior createBehavior(ParticleBehavior parentBehavior) {
		return new DyingParticleBehavior(parentBehavior, 42, true);
	}

	/**
	 * @see gameframework.particles.behaviors.ParticleBehaviorTest#isDeadIntercepted()
	 */
	@Override
	public boolean isDeadIntercepted() {
		// DyingParticleBehavior intercept the call of isDead
		return true;
	}
	
	@Test
	public void particleIsAliveAtBegining() {
		assertFalse(behavior.isDead(particle));
	}
	
	@Test
	public void particleIsDeadWhenItsTimeToLiveHasExpired() {
		assertFalse(behavior.isDead(particle));
		particle.setTimeAlive(42);
		assertTrue(behavior.isDead(particle));
	}
	
	@Test
	public void particleOpacityIsLowerIfNearDeath() {
		assertEquals(255, particle.getColor().getAlpha());
		particle.setTimeAlive(21);
		behavior.update(particle);
		assertTrue(particle.getColor().getAlpha() < 255);
	}
}
