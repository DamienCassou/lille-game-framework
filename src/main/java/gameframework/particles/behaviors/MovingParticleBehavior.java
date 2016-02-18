package gameframework.particles.behaviors;

import gameframework.particles.Particle;

/**
 * This behavior will move the particles at a specified speed and angle
 */
public class MovingParticleBehavior extends ParticleBehavior {
	protected int speed;
	protected double minAngle, maxAngle;
	
	/**
	 * Constructor
	 * @param behavior Particle's behavior
	 * @param speed Speed of the movement
	 * @param minAngle Minimum angle of the movement (in radian)
	 * @param maxAngle Maximum angle of the movement (in radian)
	 * minAngle and maxAngle represent a range. That way, each particle has a random angle chosen in that range
	 * If you want every particle to move at the same angle, just set minAngle and maxAngle to the same value
	 */
	public MovingParticleBehavior(ParticleBehavior behavior, int speed, double minAngle, double maxAngle) {
		super(behavior);
		this.speed = speed;
		this.minAngle = minAngle;
		this.maxAngle = maxAngle;
	}
	/**
	 * Will move the particle according to its speed and angle
	 * @see gameframework.particles.behaviors.ParticleBehavior#update(gameframework.particles.Particle)
	 */
	@Override
	public void update(Particle particle) {
		super.update(particle);
		// Get the angle corresponding to the randomness of the particle
		double angle = minAngle + (particle.getRandomness() * (maxAngle - minAngle));
		
		particle.setX(particle.getX() + Math.cos(angle) * speed);
		particle.setY(particle.getY() + Math.sin(angle) * speed);
	}
}
