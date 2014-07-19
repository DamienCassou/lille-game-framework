package gameframework.game;

import gameframework.drawing.CanvasDefaultImpl;

import java.awt.Canvas;

public class GameConfiguration {

	public int getNbRows() {
		return 31;
	}
	
	public int getNbColumns() {
		return 28;
	}
	
	public int getSpriteSize() {
		return 16;
	}
	
	public int getDefaultNbLives() {
		return 1;
	}
	
	public Canvas createCanvas() {
		return new CanvasDefaultImpl();
	}

	public Object getLevels() {
		// TODO Auto-generated method stub
		return null;
	}
}
