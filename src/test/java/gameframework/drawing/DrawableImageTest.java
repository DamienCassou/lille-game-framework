package gameframework.drawing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.net.URL;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class DrawableImageTest {

	GameCanvas canvas;
	Graphics graphics;
	Image actualImg;

	@Before
	public void createGraphics() {
		graphics = new MockGraphics() {
			@Override
			public boolean drawImage(Image img, int x, int y,
					ImageObserver observer) {
				actualImg = img;
				return false;
			}
		};
	}

	@Before
	public void createCanvas() {
		canvas = new GameCanvasDefaultImpl();
		canvas.setBounds(0, 0, 200, 200);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCantCreateFromNull() throws Exception {
		new DrawableImage((URL) null, canvas);
	}

	@Test(expected = IllegalArgumentException.class)
	public void cantCreateFromNonExisting() throws Exception {
		new DrawableImage("non existing file name.gif", canvas);
	}

	@Test
	public void createFromFilename() {
		DrawableImage drawableImage = new DrawableImage("/courbes.png", canvas);
		Image image = drawableImage.getImage();
		assertNotNull(image);
		assertNull(actualImg);
		drawableImage.draw(graphics);
		assertSame(image, actualImg);
	}

	@Test(expected = IllegalArgumentException.class)
	public void createFromBadFilename() throws Exception {
		URL imageUrl = new URL("file://non existing file name.git");
		new DrawableImage(imageUrl, canvas);
	}

	@Test
	public void width() throws Exception {
		DrawableImage drawableImage = new DrawableImage("/courbes.png", canvas);
		assertEquals(300, drawableImage.getWidth());
	}
	
	@Test
	public void height() throws Exception {
		DrawableImage drawableImage = new DrawableImage("/courbes.png", canvas);
		assertEquals(60, drawableImage.getHeight());
	}

}
