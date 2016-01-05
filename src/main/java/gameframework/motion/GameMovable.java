package gameframework.motion;

import gameframework.base.ObjectWithBoundedBox;

import java.awt.Point;

public abstract class GameMovable implements ObjectWithBoundedBox {
	protected GameMovableDriver moveDriver ;
	protected Point position = new Point();
	protected SpeedVector speedVector = SpeedVector.createNullVector();

	public GameMovable(){
		this(new GameMovableDriverDefaultImpl());
	}

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

	public void oneStepMove() {
		SpeedVector m = moveDriver.getSpeedVector(this);
		speedVector.setDirection(m.getDirection());
		speedVector.setSpeed(m.getSpeed());
		position.translate((int) speedVector.getDirection().getX()
				* speedVector.getSpeed(), (int) speedVector.getDirection()
				.getY() * speedVector.getSpeed());
		oneStepMoveAddedBehavior();
	}

	public abstract void oneStepMoveAddedBehavior();
	
	public boolean isMovable(){
		return true;
	}
}
