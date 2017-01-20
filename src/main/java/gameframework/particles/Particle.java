package gameframework.particles;

import java.awt.Color;
import java.awt.Rectangle;

import gameframework.particles.behaviors.ParticleBehavior;

/**
 * Stores every useful information about a single particle
 * like its position on the screen, its color...
 * 
 * This class is used internally by "ParticleGroup"
 * There's no reason to instantiate it directly
 */
public class Particle {
	protected double x;
	protected double y;
	protected double velocityY;
	protected int timeAlive;
	protected Color color;
	protected double randomness;
	protected int id;
	protected int width;
	protected int height;
	protected ParticleBehavior behavior;
	
	/**
	 * Constructor
	 * @param id Id of the particle relative to the group that the particle is part of
	 * @param color Color of the particle
	 * @param x Initial x position of the particle on the screen
	 * @param y Initial y position of the particle on the screen
	 * @param width Initial width of the particle on the screen
	 * @param height Initial height of the particle on the screen
	 * @param behavior Behavior used to update the particle
	 */
	protected Particle(int id, Color color, int x, int y, int width, int height, ParticleBehavior behavior) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.behavior = behavior;
		this.randomness = Math.random();
		this.color = color;
		this.id = id;
	}
	
	/**
	 * Constructor
	 * @param id Id of the particle relative to the group that the particle is part of
	 * @param color Color of the particle
	 * @param rectangle Rectangle defining the initial size and position of the particle
	 * @param behavior Behavior used to update the particle
	 */
	protected Particle(int id, Color color, Rectangle rectangle, ParticleBehavior behavior) {
		this(id, color, rectangle.x, rectangle.y, rectangle.width, rectangle.height, behavior);
	}
	
	/**
	 * @return the x position on the screen of the particle
	 */
	public double getX() {
		return x;
	}
	/**
	 * @param x the new x position on the screen of the particle
	 */
	public void setX(double x) {
		this.x = x;
	}
	/**
	 * @return the y position on the screen of the particle
	 */
	public double getY() {
		return y;
	}
	/**
	 * @param y the new y position on the screen of the particle
	 */
	public void setY(double y) {
		this.y = y;
	}
	/**
	 * @return the timeAlive of the particle
	 */
	public int getTimeAlive() {
		return timeAlive;
	}
	/**
	 * @param timeAlive the timeAlive to set
	 */
	public void setTimeAlive(int timeAlive) {
		this.timeAlive = timeAlive;
	}
	/**
	 * @return the color of the particle
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color of the particle to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @return the behavior of the particle
	 */
	public ParticleBehavior getBehavior() {
		return behavior;
	}
	
	/**
	 * @return the randomness of the particle
	 */
	public double getRandomness() {
		return randomness;
	}

	/**
	 * @return the id of the particle. This id is relative to the group that the particle
	 * is part of. A group is formed when {@link ParticleEmitter#emit(Color, Rectangle, int, ParticleBehavior)} is called
	 * An id of 0 means that this particle is the first of the group
	 */ 
	public int getId() {
		return id;
	}

	/**
	 * @return the velocityY of the particle
	 */
	public double getVelocityY() {
		return velocityY;
	}

	/**
	 * @param velocityY the velocityY to set
	 */
	public void setVelocityY(double velocityY) {
		this.velocityY = velocityY;
	}

	/**
	 * @return the width of the particle
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the new width of the particle
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height of the particle
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the new height of the particle
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	/**
	 * Increments the time alive of the particle
	 */
	public void incrementTimeAlive() {
		++this.timeAlive;
	}
	
	/**
	 * Determines if this particle is dead
	 * @return True if the particle is dead, false otherwise
	 */
	public boolean isDead() {
		return getBehavior().isDead(this);
	}
	
	/**
	 * Determines if this particle should be drawn
	 * @return True if the particle should be drawn, false otherwise
	 */
	public boolean isDrawn() {
		return getBehavior().isDrawn(this);
	}
	
	/**
	 * Updates this particle using its behavior
	 */
	public void update() {
		getBehavior().update(this);
	}
}
