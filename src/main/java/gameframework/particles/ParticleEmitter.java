package gameframework.particles;

import gameframework.game.GameEntity;
import gameframework.particles.behaviors.ParticleBehavior;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A game entity that can be added to a game universe
 * This entity can emit, draw and update an infinite number of particles
 */
public class ParticleEmitter implements GameEntity {
	/* List containing every group of particles */
	protected Queue<ParticleGroup> groups;
	
	/**
	 * Constructor
	 */
	public ParticleEmitter() {
		groups = new ConcurrentLinkedQueue<>();
	}
	
	/**
	 * Draw every group of particles
	 * @param graphics Graphics used to draw
	 */
	@Override
	public void draw(Graphics graphics) {
		for (ParticleGroup group : groups) {
			group.draw(graphics);
			
			if (group.isEmpty()) {
				groups.remove(group);
			}
		}
	}
	
	/**
	 * Creates a group of particle
	 * @return The instance of the newly created ParticleGroup
	 */
	protected ParticleGroup createParticleGroup() {
		return new ParticleGroup();
	}
	
	/**
	 * Emits a certain amount of particles that will react
	 * according to the specified behavior
	 * @param color Color of these particle
	 * @param rectangle Rectangle defining the initial position and size of the particles to emit
	 * @param nb Number of particles to emit
	 * @param behavior Behavior of these newly created particles
	 */
	public void emit(Color color, Rectangle rectangle, int nb, ParticleBehavior behavior) {
		ParticleGroup group = createParticleGroup();
		for (; nb > 0; --nb) {
			group.addParticle(color, rectangle, behavior);
		}
		groups.add(group);
	}

	/**
	 * Returns always false as this entity is not movable and shouldn't be tested for collisions
	 * @see gameframework.game.GameEntity#isMovable()
	 */
	@Override
	public boolean isMovable() {
		return false;
	}
}
