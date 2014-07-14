package gameframework.base;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

public class DrawableImage implements Drawable {
	protected Image image;
	protected Canvas canvas;

	public DrawableImage(String filename, Canvas canvas) {
		this.canvas = canvas;
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.createImage(filename);
		MediaTracker tracker = new MediaTracker(canvas);
		tracker.addImage(image, 0);
		try {
			tracker.waitForAll();
		} catch (InterruptedException e) {
		}
	}

	public Image getImage() {
		return image;
	}

	public void draw(Graphics g) {
		g.drawImage(image, 0, 0, canvas);
	}
}
