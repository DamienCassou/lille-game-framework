package gameframework.motion.overlapping;

import java.awt.Rectangle;

public class MovableOverlappable extends AbstractOverlappable implements Overlappable
{
	public MovableOverlappable()
	{
		super();
	}
	
	public MovableOverlappable(Rectangle boundingBox)
	{
		super(boundingBox);
	}
	
	public MovableOverlappable(int boundingBoxXAxis, int boundingBoxYAxis, int boundingBoxWidth, int boundingBoxHeight)
	{
		super(boundingBoxXAxis, boundingBoxYAxis, boundingBoxWidth, boundingBoxHeight);
	}
	
	@Override
	public boolean isMovable()
	{
		return true;
	}
}
