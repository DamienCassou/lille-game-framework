package gameframework.motion;

import gameframework.base.ObjectWithBoundedBox;

import java.awt.Point;

/**
 * 
 * Class of a movable object in the Canvas
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
	 * Realize a single movement based on the Speed and the Direction of the SpeedVector
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
	 * this method is used to add a new Behavior to oneStepMove
	 */
	public abstract void oneStepMoveAddedBehavior();
	
	@Override
	public boolean isMovable(){
		return true;
	}
}
