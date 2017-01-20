package gameframework.particles.behaviors;

import gameframework.particles.Particle;

/**
 * Default behavior of a particle
 * This behavior should do nothing to the particle
 */
public class DefaultParticleBehavior extends ParticleBehavior {

	public DefaultParticleBehavior() {
		super(null);
	}

	/**
	 * By default, the particle cant die
	 * @see gameframework.particles.behaviors.ParticleBehavior#isDead(gameframework.particles.Particle)
	 */
	@Override
	public boolean isDead(Particle particle) {
		return false;
	}

	/**
	 * By default, nothing is done
	 * @see gameframework.particles.behaviors.ParticleBehavior#update(gameframework.particles.Particle)
	 */
	@Override
	public void update(Particle particle) {
		// Does nothing
	}

	/**
	 * By default, the particle is always drawn
	 * @see gameframework.particles.behaviors.ParticleBehavior#isDrawn(gameframework.particles.Particle)
	 */
	@Override
	public boolean isDrawn(Particle p) {
		return true;
	}
}
