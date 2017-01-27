package gameframework.drawing;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class MockGraphics extends Graphics {
	// The overrides below are empty and are not worth your time
	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height,
			ImageObserver observer) {
		return false;
	}

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
	public void fillArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
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
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
			int sx1, int sy1, int sx2, int sy2, Color bgcolor,
			ImageObserver observer) {
		// useless method override
		return false;
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2,
			int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
		// useless method override
		return false;
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height,
			Color bgcolor, ImageObserver observer) {
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
	public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
		// useless method override
		return false;
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle,
			int arcAngle) {
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
	public void copyArea(int x, int y, int width, int height, int dx, int dy) {
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
	public void translate(int x, int y) {
		// useless method override

	}

	@Override
	public void drawString(String str, int x, int y) {
		// useless method override
	}

	@Override
	public void drawString(AttributedCharacterIterator iterator, int x, int y) {
		// useless method override
	}
}
