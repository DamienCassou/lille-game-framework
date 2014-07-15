package gameframework.drawing;

import gameframework.game.GameUniverseViewPort;

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
		if (drawingGameBoard == null) {
			System.out.println("CanvasDefaultImpl.drawingGameBoard not yet set");
		} else {
			drawingGameBoard.paint();
		}
	}

	@Override
	public void repaint() {
		paint(graphics);
	}

}
