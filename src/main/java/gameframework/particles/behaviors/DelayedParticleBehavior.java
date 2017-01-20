package gameframework.particles.behaviors;

import gameframework.particles.Particle;

/**
 * This behavior will add a delay before the next particle appears
 * So, if you emit 50 particles with this behavior, the first particle will be shown instantly, the second after
 * 1*delay, the third after 2*delay, and so on until the fiftieth particle (shown after 49*delay)
 */
public class DelayedParticleBehavior extends ParticleBehavior {
	protected int delay;
	
	/**
	 * Constructor
	 * @param behavior Particle's behavior
	 * @param delay Delay added between the particles
	 */
	public DelayedParticleBehavior(ParticleBehavior behavior, int delay) {
		super(behavior);
		this.delay = delay;
	}

	/**
	 * This will be true when the delay for the particle p has expired
	 * @see gameframework.particles.behaviors.ParticleBehavior#isDrawn(gameframework.particles.Particle)
	 */
	@Override
	public boolean isDrawn(Particle particle) {
		return particle.getTimeAlive() >= particle.getId() * delay;
	}
}
