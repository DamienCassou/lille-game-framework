package gameframework.game;

import gameframework.base.Movable;
import gameframework.base.SpeedVector;
import gameframework.base.SpeedVectorDefaultImpl;

import java.awt.Point;

public abstract class GameMovable implements Movable {
	GameMovableDriver moveDriver = new GameMovableDriverDefaultImpl();

	Point position = new Point();
	SpeedVector speedVector = SpeedVectorDefaultImpl.createNullVector();

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
}
