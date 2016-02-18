package gameframework.particles.behaviors;

import gameframework.particles.Particle;

/**
 * This behavior applies a gravitational force to every particle
 * So it will gradually increase the y position of every particle
 */
public class GravityParticleBehavior extends ParticleBehavior {
	protected double minGravity, maxGravity;
	
	/**
	 * Constructor
	 * @param behavior Particle's behavior
	 * @param minGravity Minimum strength of the gravity
	 * @param maxGravity Maximum strength of the gravity
	 * minGravity and maxGravity represent a range. That way, each particle has a random value chosen in that range
	 * If you want every particle to have the same gravity strength, just set minGravity and maxGravity to the same value
	 */
	public GravityParticleBehavior(ParticleBehavior behavior, double minGravity, double maxGravity) {
		super(behavior);
		this.minGravity = minGravity;
		this.maxGravity = maxGravity;
	}
	/**
	 * Will apply gravity to the particle
	 * @see gameframework.particles.behaviors.ParticleBehavior#update(gameframework.particles.Particle)
	 */
	@Override
	public void update(Particle particle) {
		super.update(particle);
		// Get the gravity corresponding to the randomness of the particle
		double gravity = minGravity + (particle.getRandomness() * (maxGravity - minGravity));
		particle.setVelocityY(particle.getVelocityY() + gravity);
		particle.setY(particle.getY() + particle.getVelocityY());
	}
	
}
