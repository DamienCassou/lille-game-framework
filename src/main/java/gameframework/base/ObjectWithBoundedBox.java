package gameframework.base;

import java.awt.Rectangle;

public interface ObjectWithBoundedBox {
	Rectangle getBoundingBox();
	
	public boolean isMovable();
}
