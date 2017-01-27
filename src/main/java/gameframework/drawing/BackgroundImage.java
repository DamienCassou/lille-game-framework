package gameframework.drawing;

import java.awt.Graphics;
import java.net.URL;

public class BackgroundImage extends DrawableImage {

	public BackgroundImage(URL url, GameCanvas gameCanvas) {
		super(url, gameCanvas);
	}

	public BackgroundImage(String string, GameCanvas canvas) {
		super(string, canvas);
	}

	@Override
	public void draw(Graphics graphics) {
		canvas.drawFullSizeImage(graphics, image);
	}
}
