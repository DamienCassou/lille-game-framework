package gameframework.base;

import java.awt.Canvas;
import java.awt.Graphics;

public class BackgroundImage extends DrawableImage {

	public BackgroundImage(String filename, Canvas canvas) {
		super(filename, canvas);
	}

	@Override
	public void draw(Graphics g) {
		g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), canvas);
	}
}
