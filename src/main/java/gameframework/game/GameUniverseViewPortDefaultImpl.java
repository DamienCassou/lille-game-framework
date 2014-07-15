package gameframework.game;

import gameframework.drawing.BackgroundImage;
import gameframework.drawing.Drawable;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Iterator;

public class GameUniverseViewPortDefaultImpl implements GameUniverseViewPort {
	private Image buffer;
	private Graphics bufferGraphics;
	protected Canvas canvas;
	protected BackgroundImage background;
	protected GameUniverse universe;

	public GameUniverseViewPortDefaultImpl(Canvas canvas, GameUniverse universe) {
		this.canvas = canvas;
		buffer = canvas.createImage(canvas.getWidth(), canvas.getHeight());
		bufferGraphics = buffer.getGraphics();
		background = new BackgroundImage(backgroundImage(), canvas);
		this.universe = universe;
	}

	protected URL backgroundImage() {
		return this.getClass().getResource("/images/background_image.gif");
	}

	public void paint() {
		background.draw(bufferGraphics);
		Iterator<GameEntity> gt = universe.gameEntities();
		for (; gt.hasNext();) {
			GameEntity tmp = gt.next();
			if (tmp instanceof Drawable) {
				((Drawable) tmp).draw(bufferGraphics);
			}
		}
		refresh();
	}

	public void refresh() {
		canvas.getGraphics().drawImage(buffer, 0, 0, canvas.getWidth(),
				canvas.getHeight(), canvas);
	}
}
