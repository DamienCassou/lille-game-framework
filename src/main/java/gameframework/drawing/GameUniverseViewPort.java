package gameframework.drawing;

import gameframework.game.GameData;

/**
 * Draw all elements of the game universe on the canvas.
 * Implementing this interface allow you to put a background image on your canvas, and paint different elements (like entities).
 */
public interface GameUniverseViewPort {
	
	public void paint();

	public void refresh();

	public void setGameData(GameData data);
	
	public void setBackgroundImage(String path);
	
}
