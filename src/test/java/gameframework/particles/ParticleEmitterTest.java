package gameframework.particles;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Rectangle;

import gameframework.particles.behaviors.DefaultParticleBehavior;
import gameframework.particles.behaviors.ParticleBehaviorMock;

import org.junit.Before;
import org.junit.Test;

public class ParticleEmitterTest {
	protected ParticleEmitter emitter;
	protected ParticleBehaviorMock behavior;
	
	@Before
	public void intializeEmitter() {
		emitter = new ParticleEmitterMock();
		behavior = new ParticleBehaviorMock(new DefaultParticleBehavior());
	}
	
	public void groupAreCorrectlyCreated() {
		assertEquals(0, emitter.groups.size());
		emitter.emit(Color.WHITE, new Rectangle(), 42, behavior);
		emitter.emit(Color.WHITE, new Rectangle(), 42, behavior);
		assertEquals(2, emitter.groups.size());
	}

	@Test
	public void particlesAreCorrectlyUpdated() {
		assertEquals(0, behavior.getNbUpdate());
		emitter.emit(Color.WHITE, new Rectangle(), 42, behavior);
		// We simulate a draw that should updates our particles
		emitter.draw(null);
		assertEquals(42, behavior.getNbUpdate());
	}
}
