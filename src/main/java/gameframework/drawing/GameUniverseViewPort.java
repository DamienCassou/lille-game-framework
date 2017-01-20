package gameframework.drawing;

import gameframework.game.GameData;

/**
 * Draw all elements of the game universe on the canvas.
 */
public interface GameUniverseViewPort {
	
	public void paint();

	public void refresh();

	public void setGameData(GameData data);
	
	/**
	 * Set a background image to use in the canvas.
	 * @param path is the path of the Image to be set
	 */
	public void setBackgroundImage(String path);
}
