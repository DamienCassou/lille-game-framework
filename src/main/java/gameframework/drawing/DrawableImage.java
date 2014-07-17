package gameframework.drawing;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

public class DrawableImage implements Drawable {
	protected Image image;
	protected Canvas canvas;

	public DrawableImage(URL imageUrl, Canvas canvas) {
		this.canvas = canvas;
		if (imageUrl == null) {
			throw new IllegalArgumentException("Null imageUrl parameter");
		}
		handleImage(imageUrl);
	}

	protected void handleImage(URL imageUrl) {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.createImage(imageUrl);
		MediaTracker tracker = new MediaTracker(canvas);
		tracker.addImage(image, 0);
		try {
			tracker.waitForAll();
			if (tracker.isErrorAny()) {
				throw new IllegalArgumentException(
						"Problem while loading an image " + imageUrl);
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public DrawableImage(String filename, Canvas canvas) {
		this(DrawableImage.class.getResource(filename), canvas);
	}

	public Image getImage() {
		return image;
	}

	public void draw(Graphics g) {
		g.drawImage(image, 0, 0, canvas);
	}

	public int getWidth() {
		return getImage().getWidth(null);
	}
}
