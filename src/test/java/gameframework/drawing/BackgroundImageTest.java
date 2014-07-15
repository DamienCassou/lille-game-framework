package gameframework.drawing;

import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.text.AttributedCharacterIterator;
import java.util.Map;

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

	public Graphics2D createMockGraphics() {
		return new Graphics2D() {

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

			// The other overrides below are empty and are not worth your time

			@Override
			public void setXORMode(Color c1) {
				// useless method override
			}

			@Override
			public void setPaintMode() {
				// useless method override
			}

			@Override
			public void setFont(Font font) {
				// useless method override
			}

			@Override
			public void setColor(Color c) {
				// useless method override
			}

			@Override
			public void setClip(int x, int y, int width, int height) {
				// useless method override
			}

			@Override
			public void setClip(Shape clip) {
				// useless method override
			}

			@Override
			public FontMetrics getFontMetrics(Font f) {
				// useless method override
				return null;
			}

			@Override
			public Font getFont() {
				// useless method override
				return null;
			}

			@Override
			public Color getColor() {
				// useless method override
				return null;
			}

			@Override
			public Rectangle getClipBounds() {
				// useless method override
				return null;
			}

			@Override
			public Shape getClip() {
				// useless method override
				return null;
			}

			@Override
			public void fillRoundRect(int x, int y, int width, int height,
					int arcWidth, int arcHeight) {
				// useless method override

			}

			@Override
			public void fillRect(int x, int y, int width, int height) {
				// useless method override

			}

			@Override
			public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// useless method override

			}

			@Override
			public void fillOval(int x, int y, int width, int height) {
				// useless method override

			}

			@Override
			public void fillArc(int x, int y, int width, int height,
					int startAngle, int arcAngle) {
				// useless method override

			}

			@Override
			public void drawRoundRect(int x, int y, int width, int height,
					int arcWidth, int arcHeight) {
				// useless method override

			}

			@Override
			public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
				// useless method override

			}

			@Override
			public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
				// useless method override

			}

			@Override
			public void drawOval(int x, int y, int width, int height) {
				// useless method override

			}

			@Override
			public void drawLine(int x1, int y1, int x2, int y2) {
				// useless method override

			}

			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2,
					int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor,
					ImageObserver observer) {
				// useless method override
				return false;
			}

			@Override
			public boolean drawImage(Image img, int dx1, int dy1, int dx2,
					int dy2, int sx1, int sy1, int sx2, int sy2,
					ImageObserver observer) {
				// useless method override
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y, int width,
					int height, Color bgcolor, ImageObserver observer) {
				// useless method override
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y, Color bgcolor,
					ImageObserver observer) {
				// useless method override
				return false;
			}

			@Override
			public boolean drawImage(Image img, int x, int y,
					ImageObserver observer) {
				// useless method override
				return false;
			}

			@Override
			public void drawArc(int x, int y, int width, int height,
					int startAngle, int arcAngle) {
				// useless method override

			}

			@Override
			public void dispose() {
				// useless method override

			}

			@Override
			public Graphics create() {
				// useless method override
				return null;
			}

			@Override
			public void copyArea(int x, int y, int width, int height, int dx,
					int dy) {
				// useless method override

			}

			@Override
			public void clipRect(int x, int y, int width, int height) {
				// useless method override

			}

			@Override
			public void clearRect(int x, int y, int width, int height) {
				// useless method override

			}

			@Override
			public void translate(double tx, double ty) {
				// useless method override

			}

			@Override
			public void translate(int x, int y) {
				// useless method override

			}

			@Override
			public void transform(AffineTransform Tx) {
				// useless method override

			}

			@Override
			public void shear(double shx, double shy) {
				// useless method override

			}

			@Override
			public void setTransform(AffineTransform Tx) {
				// useless method override

			}

			@Override
			public void setStroke(Stroke s) {
				// useless method override

			}

			@Override
			public void setRenderingHints(Map<?, ?> hints) {
				// useless method override

			}

			@Override
			public void setRenderingHint(Key hintKey, Object hintValue) {
				// useless method override

			}

			@Override
			public void setPaint(Paint paint) {
				// useless method override

			}

			@Override
			public void setComposite(Composite comp) {
				// useless method override

			}

			@Override
			public void setBackground(Color color) {
				// useless method override

			}

			@Override
			public void scale(double sx, double sy) {
				// useless method override

			}

			@Override
			public void rotate(double theta, double x, double y) {
				// useless method override

			}

			@Override
			public void rotate(double theta) {
				// useless method override

			}

			@Override
			public boolean hit(Rectangle rect, Shape s, boolean onStroke) {
				// useless method override
				return false;
			}

			@Override
			public AffineTransform getTransform() {
				// useless method override
				return null;
			}

			@Override
			public Stroke getStroke() {
				// useless method override
				return null;
			}

			@Override
			public RenderingHints getRenderingHints() {
				// useless method override
				return null;
			}

			@Override
			public Object getRenderingHint(Key hintKey) {
				// useless method override
				return null;
			}

			@Override
			public Paint getPaint() {
				// useless method override
				return null;
			}

			@Override
			public FontRenderContext getFontRenderContext() {
				// useless method override
				return null;
			}

			@Override
			public GraphicsConfiguration getDeviceConfiguration() {
				// useless method override
				return null;
			}

			@Override
			public Composite getComposite() {
				// useless method override
				return null;
			}

			@Override
			public Color getBackground() {
				// useless method override
				return null;
			}

			@Override
			public void fill(Shape s) {
				// useless method override

			}

			@Override
			public void drawString(AttributedCharacterIterator iterator,
					float x, float y) {
				// useless method override

			}

			@Override
			public void drawString(AttributedCharacterIterator iterator, int x,
					int y) {
				// useless method override

			}

			@Override
			public void drawString(String str, float x, float y) {
				// useless method override

			}

			@Override
			public void drawString(String str, int x, int y) {
				// useless method override

			}

			@Override
			public void drawRenderedImage(RenderedImage img,
					AffineTransform xform) {
				// useless method override

			}

			@Override
			public void drawRenderableImage(RenderableImage img,
					AffineTransform xform) {
				// useless method override

			}

			@Override
			public void drawImage(BufferedImage img, BufferedImageOp op, int x,
					int y) {
				// useless method override

			}

			@Override
			public boolean drawImage(Image img, AffineTransform xform,
					ImageObserver obs) {
				// useless method override
				return false;
			}

			@Override
			public void drawGlyphVector(GlyphVector g, float x, float y) {
				// useless method override

			}

			@Override
			public void draw(Shape s) {
				// useless method override

			}

			@Override
			public void clip(Shape s) {
				// useless method override

			}

			@Override
			public void addRenderingHints(Map<?, ?> hints) {
				// useless method override

			}
		};
	}

}
