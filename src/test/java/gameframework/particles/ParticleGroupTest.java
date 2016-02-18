package gameframework.particles;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.Rectangle;

import gameframework.particles.behaviors.DefaultParticleBehavior;
import gameframework.particles.behaviors.ParticleBehaviorMock;

import org.junit.Before;
import org.junit.Test;

public class ParticleGroupTest {
	protected ParticleGroupMock group;
	protected ParticleBehaviorMock behavior;
	
	@Before
	public void intializeEmitter() {
		group = new ParticleGroupMock();
		behavior = new ParticleBehaviorMock(new DefaultParticleBehavior());
	}
	
	@Test
	public void particlesAreCorrectlyCreated() {
		assertEquals(0, group.aliveParticles.size());
		group.addParticle(Color.WHITE, new Rectangle(), behavior);
		group.addParticle(Color.WHITE, new Rectangle(), behavior);
		assertEquals(2, group.aliveParticles.size());
	}
	
	@Test
	public void particlesAreCorrectlyRemoved() {
		assertEquals(0, group.aliveParticles.size());
		assertEquals(0, group.deadParticles.size());
		group.addParticle(Color.WHITE, new Rectangle(), behavior);
		// When a particle is in deadParticles, it should be removed after a call to removeDeadParticles
		assertEquals(1, group.aliveParticles.size());
		group.deadParticles.add(group.aliveParticles.get(0));
		group.removeDeadParticles();
		assertEquals(0, group.aliveParticles.size());
		assertEquals(0, group.deadParticles.size());
	}
	
	@Test
	public void particlesAreCorrectlyUpdated() {
		assertEquals(0, behavior.getNbUpdate());
		group.addParticle(Color.WHITE, new Rectangle(), behavior);
		group.addParticle(Color.WHITE, new Rectangle(), behavior);
		group.addParticle(Color.WHITE, new Rectangle(), behavior);
		// We simulate a draw that should updates our particles
		group.draw(null);
		assertEquals(3, behavior.getNbUpdate());
	}
}
