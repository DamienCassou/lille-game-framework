package gameframework.motion.overlapping;

import java.awt.Point;
import java.awt.Rectangle;

public abstract class AbstractOverlappable implements Overlappable
{
	protected Rectangle boundingBox;
	
	public AbstractOverlappable(){}
	
	public AbstractOverlappable(Rectangle boundingBox)
	{
		this.boundingBox = boundingBox;
	}
	
	public AbstractOverlappable(int boundingBoxXAxis, int boundingBoxYAxis, int boundingBoxWidth, int boundingBoxHeight)
	{
		this.boundingBox = new Rectangle(boundingBoxXAxis, boundingBoxYAxis, boundingBoxWidth, boundingBoxHeight);
	}
	
	@Override
	public Rectangle getBoundingBox()
	{
		return this.boundingBox;
	}
	
	@Override
	public Point getPosition()
	{
		return new Point(this.boundingBox.x, this.boundingBox.y);
	}
}
