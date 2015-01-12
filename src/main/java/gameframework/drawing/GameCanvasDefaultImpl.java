package gameframework.drawing;

import java.awt.Canvas;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyListener;

public class GameCanvasDefaultImpl implements GameCanvas {

	protected final Canvas canvas;

	public GameCanvasDefaultImpl() {
		canvas = new Canvas();
	}

	@Override
	public Image createBuffer() {
		return canvas.createImage(canvas.getWidth(), canvas.getHeight());
	}

	@Override
	public MediaTracker createMediaTracker() {
		return new MediaTracker(canvas);
	}

	@Override
	public void drawImage(Graphics graphics, Image image, int x, int y) {
		if(x <= canvas.getHeight() && y <= canvas.getWidth() )
			graphics.drawImage(image, x, y, canvas);
		else
			graphics.drawImage(image, 0, 0, canvas);
	}

	@Override
	public void drawFullSizeImage(Graphics graphics, Image image) {
		graphics.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(),
				canvas);
	}

	@Override

	public void drawFullSizeImage(Image image, int x, int y) {
		if(x <= canvas.getHeight() && y <= canvas.getWidth() )
			getGraphics().drawImage(image, x, y, canvas.getWidth(), canvas.getHeight(), canvas);
		else
			getGraphics().drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), canvas);			
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		canvas.setBounds(x, y, width, height);
	}

	@Override
	public int getWidth() {
		return canvas.getWidth();
	}

	@Override
	public int getHeight() {
		return canvas.getHeight();
	}

	@Override
	public void setSize(int width, int height) {
		canvas.setSize(width, height);
	}

	@Override
	public void addTo(Frame frame) {
		frame.add(canvas);
	}

	@Override
	public void addKeyListener(KeyListener keyStr) {
		canvas.addKeyListener(keyStr);
	}

	@Override
	public Graphics getGraphics() {
		return canvas.getGraphics();
	}

}
