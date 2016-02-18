package gameframework.particles.behaviors;

import java.awt.Color;

import gameframework.particles.Particle;

/**
 * This behavior will remove the particle after a certain time
 */
public class DyingParticleBehavior extends ParticleBehavior {
	protected int timeToLive;
	protected boolean fadeOpacity;
	
	/**
	 * Constructor
	 * @param behavior Particle's behavior
	 * @param timeToLive Time before the removal of the particle
	 * @param fadeOpacity If this is true, the particle will gradually disappear (particle's opacity will
	 *  decrease as it's approaching its death)
	 */
	public DyingParticleBehavior(ParticleBehavior behavior, int timeToLive, boolean fadeOpacity) {
		super(behavior);
		this.timeToLive = timeToLive;
		this.fadeOpacity = fadeOpacity;
	}

	/**
	 * Return true if the particle's time to live has expired
	 * @see gameframework.particles.behaviors.ParticleBehavior#isDead(gameframework.particles.Particle)
	 */
	@Override
	public boolean isDead(Particle particle) {
		return particle.getTimeAlive() >= timeToLive;
	}

	/**
	 * Will gradually decrease the opacity of the particle if "fadeOpacity" was set to true
	 * @see gameframework.particles.behaviors.ParticleBehavior#update(gameframework.particles.Particle)
	 */
	@Override
	public void update(Particle particle) {
		super.update(particle);
		if (fadeOpacity) {
			int opacity = 255 - (int) ((particle.getTimeAlive() + 0f) / timeToLive * 255);
			Color previousColor = particle.getColor();
			Color color = new Color(previousColor.getRed(), previousColor.getGreen(), previousColor.getBlue(), opacity);
			particle.setColor(color);
		}
	}
	
}
