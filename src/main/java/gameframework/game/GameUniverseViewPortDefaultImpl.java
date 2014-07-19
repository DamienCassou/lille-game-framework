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
	protected BackgroundImage background;
	protected GameData data;

	protected URL backgroundImage() {
		return this.getClass().getResource("/images/background_image.gif");
	}

	@Override
	public void paint() {
		background.draw(getBufferGraphics());
		Iterator<GameEntity> gt = getUniverse().gameEntities();
		for (; gt.hasNext();) {
			GameEntity tmp = gt.next();
			if (tmp instanceof Drawable) {
				((Drawable) tmp).draw(getBufferGraphics());
			}
		}
		refresh();
	}

	protected GameUniverse getUniverse() {
		return data.getUniverse();
	}

	public Canvas getCanvas() {
		return data.getCanvas();
	}

	@Override
	public void setGameData(GameData data) {
		this.data = data;
		buffer = getCanvas().createImage(getCanvas().getWidth(),
				getCanvas().getHeight());
		background = new BackgroundImage(backgroundImage(), getCanvas());
	}

	protected Graphics getBufferGraphics() {
		return buffer.getGraphics();
	}

	@Override
	public void refresh() {
		getCanvas().getGraphics().drawImage(buffer, 0, 0,
				getCanvas().getWidth(), getCanvas().getHeight(), getCanvas());
	}
}
