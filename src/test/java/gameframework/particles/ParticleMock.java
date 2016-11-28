package gameframework.particles;

import gameframework.particles.behaviors.ParticleBehavior;

import java.awt.Color;
import java.awt.Rectangle;

/**
 * Change the visibility of the constructors
 * Like that we can instantiate a Particle
 */
public class ParticleMock extends Particle {
	public ParticleMock(int id, Color color, int x, int y, int width, int height, ParticleBehavior behavior) {
		super(id, color, x, y, width, height, behavior);
	}
	
	public ParticleMock(int id, Color color, Rectangle rectangle, ParticleBehavior behavior) {
		super(id, color, rectangle, behavior);
	}
}
