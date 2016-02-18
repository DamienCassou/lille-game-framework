package gameframework.particles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.LinkedList;
import java.util.List;

import gameframework.particles.behaviors.ParticleBehavior;

/**
 * Represents a group of particles.
 * Every particles inside this group will have a unique id that could be used by behaviors
 * A group is created when you call {@link ParticleEmitter#emit(java.awt.Color, java.awt.Rectangle, int, gameframework.particles.behaviors.ParticleBehavior)} 
 */
public class ParticleGroup {
	/* List containing every "alive" particles that will be updated in the group */
	protected List<Particle> aliveParticles;
	/* List containing every particles that should be removed */
	protected List<Particle> deadParticles;
	/* Used to give a unique id to new particles */
	protected int particleId;
	
	/**
	 * Constructor
	 */
	public ParticleGroup() {
		aliveParticles = new LinkedList<>();
		deadParticles = new LinkedList<>();
		particleId = 0;
	}
	
	/**
	 * Update a particle according to its behavior
	 * @param particle Particle to update
	 */
	protected void update(Particle particle) {
		particle.incrementTimeAlive();
		
		if (particle.isDead()) {
			deadParticles.add(particle);
		}
		
		if (particle.isDrawn()) {
			particle.update();
		}
	}
	
	/**
	 * Remove every dead particles contained in deadParticles
	 */
	protected void removeDeadParticles() {
		aliveParticles.removeAll(deadParticles);
		deadParticles.clear();
	}
	
	/**
	 * Draw a single particle on a Graphics
	 * @param particle The particle to draw
	 * @param graphics The Graphics
	 */
	public void drawParticle(Particle particle, Graphics graphics) {
		if (particle.isDrawn()) {
			graphics.setColor(particle.getColor());
			graphics.fillRect((int) particle.getX(), (int) particle.getY(), particle.getWidth(), particle.getHeight());
		}
	}
	
	/**
	 * Draw every particles that are still alive in the group
	 */
	public void draw(Graphics g) {
		for (Particle p : aliveParticles) {
			update(p);
			drawParticle(p, g);
		}
		
		// We remove the particles after the loop to avoid concurrent modifications
		removeDeadParticles();
	}
	
	/**
	 * Adds a particle to the group
	 * @param color Color of this particle
	 * @param rectangle Rectangle defining the initial position and size of the particle
	 * @param behavior Behavior of the newly created particle
	 */
	public void addParticle(Color color, Rectangle rectangle, ParticleBehavior behavior) {
		aliveParticles.add(new Particle(++particleId, color, rectangle, behavior));
	}
	
	/**
	 * Determines if the group is empty (has no particle alive)
	 * @return True if the group is empty, false otherwise
	 */
	public boolean isEmpty() {
		return aliveParticles.isEmpty();
	}
}
