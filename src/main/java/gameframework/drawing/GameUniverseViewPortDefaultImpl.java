package gameframework.drawing;

import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverse;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Iterator;

public class GameUniverseViewPortDefaultImpl implements GameUniverseViewPort {
	private Image buffer;
	protected BackgroundImage background;
	protected GameData data;

	public GameUniverseViewPortDefaultImpl() {}

	public GameUniverseViewPortDefaultImpl(GameData data) {
		setGameData(data);
	}

	protected URL backgroundImage() {
		return this.getClass().getResource("/images/background_image.gif");
	}

	@Override
	public void paint() {
		background.draw(getBufferGraphics());
		Iterator<GameEntity> gt = getUniverse().getGameEntitiesIterator();
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

	public GameCanvas getCanvas() {
		return data.getCanvas();
	}

	@Override
	public void setGameData(GameData data) {
		this.data = data;
		buffer = getCanvas().createBuffer();
		background = new BackgroundImage(backgroundImage(), getCanvas());
	}

	protected Graphics getBufferGraphics() {
		return buffer.getGraphics();
	}

	@Override
	public void refresh() {
		getCanvas().drawFullSizeImage(buffer, 0, 0);
	}
}
