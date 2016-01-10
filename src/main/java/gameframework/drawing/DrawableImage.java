package gameframework.drawing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

public class DrawableImage implements Drawable {
	protected Image image;
	protected GameCanvas canvas;

	public DrawableImage(URL imageUrl, GameCanvas gameCanvas) throws IllegalArgumentException {
		
		if (imageUrl == null) {
			throw new IllegalArgumentException("Null imageUrl parameter");
		}
		
		this.canvas = gameCanvas;
		handleImage(imageUrl);
	}
	
	/**
	 * Use a MediaTracker to load the image in the canvas, and throw an
	 * exception if there is a problem
	 * 
	 * @param imageUrl
	 *            is the path to the image
	 */
	protected void handleImage(URL imageUrl) throws IllegalArgumentException {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.createImage(imageUrl);
		MediaTracker tracker = canvas.createMediaTracker();
		tracker.addImage(image, 0);
		
		try {
			tracker.waitForAll();
			if (tracker.isErrorAny()) {
				throw new IllegalArgumentException("Problem while loading an image " + imageUrl);
			}
		} catch (InterruptedException e) {
			tracker.removeImage(image);
		}
	}

	public DrawableImage(String filename, GameCanvas canvas) {
		this(DrawableImage.class.getResource(filename), canvas);
	}

	public Image getImage() {
		return image;
	}

	@Override
	public void draw(Graphics graphics) {
		canvas.drawImage(graphics, image, 0, 0);
	}

	public int getWidth() {
		return getImage().getWidth(null);
	}

	public int getHeight() {
		return getImage().getHeight(null);
	}
}
