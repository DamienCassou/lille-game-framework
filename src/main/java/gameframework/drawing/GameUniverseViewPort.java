package gameframework.drawing;

import gameframework.game.GameData;

/**
 * Draw all elements of the game universe on the canvas.
 */
public interface GameUniverseViewPort {
	public void paint();

	public void refresh();

	public void setGameData(GameData data);
}
