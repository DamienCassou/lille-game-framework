package gameframework.particles.behaviors;

import org.junit.Test;
import static org.junit.Assert.*;

public class GravityParticleBehaviorTest extends ParticleBehaviorTest {

	@Override
	public ParticleBehavior createBehavior(ParticleBehavior parentBehavior) {
		return new GravityParticleBehavior(parentBehavior, 1, 2);
	}
	
	@Test
	public void verticalPositionOfTheParticleIsGreaterAfterUpdate() {
		double previousY = particle.getY();
		behavior.update(particle);
		assertTrue(previousY < particle.getY());
	}
}
