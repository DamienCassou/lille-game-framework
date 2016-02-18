package gameframework.particles.behaviors;

import static org.junit.Assert.assertTrue;
import gameframework.particles.Particle;
import gameframework.particles.ParticleMock;

import java.awt.Color;
import java.awt.Rectangle;

import org.junit.Test;

public class MovingParticleBehaviorTest extends ParticleBehaviorTest {

	@Override
	public ParticleBehavior createBehavior(ParticleBehavior parentBehavior) {
		return new MovingParticleBehavior(parentBehavior, 1, 0, 0);
	}
	
	@Test
	public void particleGoesRightWhenAngleIsZero() {
		ParticleBehavior particleBehavior = new MovingParticleBehavior(new DefaultParticleBehavior(), 1, 0, 0);
		double previousX = particle.getX();
		particleBehavior.update(particle);
		assertTrue(previousX < particle.getX());
	}
	
	@Test
	public void particleGoesLeftWhenAngleIsPI() {
		ParticleBehavior particleBehavior = new MovingParticleBehavior(new DefaultParticleBehavior(), 1, Math.PI, Math.PI);
		double previousX = particle.getX();
		particleBehavior.update(particle);
		assertTrue(previousX > particle.getX());
	}
	
	@Test
	public void greaterSpeedMakesTheParticleGoesFurther() {
		ParticleBehavior slowBehavior = new MovingParticleBehavior(new DefaultParticleBehavior(), 1, 0, 0);
		ParticleBehavior fastBehavior = new MovingParticleBehavior(new DefaultParticleBehavior(), 42, 0, 0);
		
		Particle slowParticle = new ParticleMock(0, Color.BLACK, new Rectangle(), slowBehavior);
		Particle fastParticle = new ParticleMock(0, Color.BLACK, new Rectangle(), fastBehavior);
		
		slowBehavior.update(slowParticle);
		fastBehavior.update(fastParticle);
		
		assertTrue(slowParticle.getX() < fastParticle.getX());
	}
}
