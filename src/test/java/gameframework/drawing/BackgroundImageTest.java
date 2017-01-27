package gameframework.drawing;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BackgroundImageTest extends DrawableImageTest {

	int drawImageCalled = 0;

	@Test
	public void drawFullSize() {
		DrawableImage drawableImage = new BackgroundImage("/courbes.png",
				canvas);
		assertEquals(0, drawImageCalled);
		drawableImage.draw(createMockGraphics());
		assertEquals(1, drawImageCalled);
	}

	public Graphics createMockGraphics() {
		return new MockGraphics() {

			@Override
			public boolean drawImage(Image img, int x, int y, int width,
					int height, ImageObserver observer) {
				drawImageCalled++;
				assertTrue(width > 0);
				assertTrue(height > 0);
				assertEquals(canvas.getWidth(), width);
				assertEquals(canvas.getHeight(), height);
				return false;
			}

		};
	}

}
