package gameframework.game;

import java.awt.Canvas;
import java.awt.Graphics;

public class CanvasDefaultImpl extends Canvas {

	private static final long serialVersionUID = 1L;
	private GameUniverseViewPort drawingGameBoard;
	private Graphics graphics;

	public void setDrawingGameBoard(GameUniverseViewPort drawingGameBoard) {
		this.drawingGameBoard = drawingGameBoard;
		graphics = getGraphics();
	}

	@Override
	public void paint(Graphics g) {
		// Graphics gReal = getGraphics();
		try {
			drawingGameBoard.paint();
		} catch (NullPointerException e) {
		}
	}

	@Override
	public void repaint() {
		paint(graphics);
	}

}
