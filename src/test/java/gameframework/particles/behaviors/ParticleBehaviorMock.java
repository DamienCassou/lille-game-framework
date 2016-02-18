package gameframework.particles.behaviors;

import gameframework.particles.Particle;

public class ParticleBehaviorMock extends ParticleBehavior {
	protected int nbUpdate;
	protected int nbIsDead;
	protected int nbIsDrawn;

	public ParticleBehaviorMock(ParticleBehavior behavior) {
		super(behavior);
		nbUpdate = 0;
		nbIsDead = 0;
		nbIsDrawn = 0;
	}

	/**
	 * @see gameframework.particles.behaviors.ParticleBehavior#update(gameframework.particles.Particle)
	 */
	@Override
	public void update(Particle particle) {
		super.update(particle);
		++nbUpdate;
	}
	
	

	/**
	 * @see gameframework.particles.behaviors.ParticleBehavior#isDead(gameframework.particles.Particle)
	 */
	@Override
	public boolean isDead(Particle particle) {
		++nbIsDead;
		return super.isDead(particle);
	}

	/**
	 * @see gameframework.particles.behaviors.ParticleBehavior#isDrawn(gameframework.particles.Particle)
	 */
	@Override
	public boolean isDrawn(Particle particle) {
		++nbIsDrawn;
		return super.isDrawn(particle);
	}

	/**
	 * @return Number of times "update" was called 
	 */
	public int getNbUpdate() {
		return nbUpdate;
	}

	/**
	 * @return Number of times "isDead" was called
	 */
	public int getNbIsDead() {
		return nbIsDead;
	}

	/**
	 * @return Number of times "isDrawn" was called
	 */
	public int getNbIsDrawn() {
		return nbIsDrawn;
	}
}
