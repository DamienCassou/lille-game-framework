package gameframework.motion.overlapping;

import java.awt.Rectangle;

public class UnmovableOverlappable extends AbstractOverlappable
{
	public UnmovableOverlappable()
	{
		super();
	}
	
	public UnmovableOverlappable(Rectangle boundingBox)
	{
		super(boundingBox);
	}
	
	public UnmovableOverlappable(int boundingBoxXAxis, int boundingBoxYAxis, int boundingBoxWidth, int boundingBoxHeight)
	{
		super(boundingBoxXAxis, boundingBoxYAxis, boundingBoxWidth, boundingBoxHeight);
	}
	
	@Override
	public boolean isMovable()
	{
		return false;
	}
}
