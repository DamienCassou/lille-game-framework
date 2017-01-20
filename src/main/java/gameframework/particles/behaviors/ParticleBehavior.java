package gameframework.particles.behaviors;

import gameframework.particles.Particle;

/**
 * Class to extend in order to create a new particle behavior
 */
public abstract class ParticleBehavior {
	protected ParticleBehavior behavior;
	
	/**
	 * Constructor
	 * @param behavior Particle's behavior
	 */
	public ParticleBehavior(ParticleBehavior behavior) {
		this.behavior = behavior;
	}
	
	/**
	 * Determines whether a particle is dead (and should be removed) or not
	 * @param particle The particle to test
	 * @return True if the particle is dead, false otherwise
	 */
	public boolean isDead(Particle particle) {
		return behavior.isDead(particle);
	}
	
	/**
	 * Update a particle according to its behavior
	 * @param particle Particle to update
	 */
	public void update(Particle particle) {
		behavior.update(particle);
	}

	/**
	 * Determines whether a particle should be drawn or not
	 * @param particle Particle to test
	 * @return True if the particle should be drawn, false otherwise
	 */
	public boolean isDrawn(Particle particle) {
		return behavior.isDrawn(particle);
	}
}
