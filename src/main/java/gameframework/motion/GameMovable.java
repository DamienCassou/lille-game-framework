package gameframework.motion;

import gameframework.base.ObjectWithBoundedBox;

import java.awt.Point;

/**
 * 
 * Class of a movable object in the Canvas. this class implements @see ObjectWithBoundedBox.
 * a GameMovable provide tools to define the behavior of an entity : Is it movable ? What's his position ? At what speed is he moving ?
 * 
 * 
 */
public abstract class GameMovable implements ObjectWithBoundedBox {
	protected GameMovableDriver moveDriver ;
	protected Point position = new Point();
	protected SpeedVector speedVector = SpeedVector.createNullVector();
	
	/**
	 * Default Constructor, create a Default Implementation of GameMovable
	 */
	public GameMovable(){
		this(new GameMovableDriverDefaultImpl());
	}
	
	/**
	 * Specific constructor, set your own parameters with a GameMovableDriver
	 * @param driver is the GameMovableDriver containing your parameters
	 */
	public GameMovable(GameMovableDriver driver){
		moveDriver = driver;
	}

	public void setPosition(Point p) {
		position = (Point) p.clone();
	}

	public Point getPosition() {
		return position;
	}

	public void setSpeedVector(SpeedVector speedVector) {
		this.speedVector = (SpeedVector) speedVector.clone();
	}

	public SpeedVector getSpeedVector() {
		return (SpeedVector) speedVector.clone();
	}

	public void setDriver(GameMovableDriver driver) {
		moveDriver = driver;
	}

	public GameMovableDriver getDriver() {
		return moveDriver;
	}
	
	/**
	 * Move the GameMovable to the next position, based on the Speed and the Direction of the SpeedVector.
	 * Note that the GameMovable is moving one step at a time.
	 */
	public void oneStepMove() {
		SpeedVector m = moveDriver.getSpeedVector(this);
		speedVector.setDirection(m.getDirection());
		speedVector.setSpeed(m.getSpeed());
		position.translate((int) speedVector.getDirection().getX()
				* speedVector.getSpeed(), (int) speedVector.getDirection()
				.getY() * speedVector.getSpeed());
		oneStepMoveAddedBehavior();
	}
	
	/**
	 * This method is used to add a new Behavior to oneStepMove, allowing you to personnalize the comportment of your GameMovable.
	 * For example, you can create a entity that can regenerate his health at every step. 
	 * You can also define a comportment for entities that can't move.
	 */
	public abstract void oneStepMoveAddedBehavior();
	
	@Override
	public boolean isMovable(){
		return true;
	}
}
