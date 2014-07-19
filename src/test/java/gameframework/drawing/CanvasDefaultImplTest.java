package gameframework.drawing;

import gameframework.game.GameData;
import gameframework.game.GameUniverseViewPort;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CanvasDefaultImplTest {

	GameUniverseViewPort viewPort;
	int paintCalled = 0;

	@Before
	public void createViewPort() {
		viewPort = new GameUniverseViewPort() {

			@Override
			public void refresh() {
			}

			@Override
			public void paint() {
				paintCalled++;
			}

			@Override
			public void setGameData(GameData data) {
			}
		};
	}

	@Test
	public void paintDelegatesToViewPort() {
		CanvasDefaultImpl canvas = new CanvasDefaultImpl();
		canvas.setDrawingGameBoard(viewPort);
		canvas.paint(new MockGraphics());
		assertEquals(1, paintCalled);
	}

	@Test
	public void repaintDelegatesToViewPort() {
		CanvasDefaultImpl canvas = new CanvasDefaultImpl();
		canvas.setDrawingGameBoard(viewPort);
		canvas.repaint();
		assertEquals(1, paintCalled);
	}

	@Test
	public void painWithNoViewPort() throws Exception {
		CanvasDefaultImpl canvas = new CanvasDefaultImpl();
		canvas.paint(new MockGraphics());
		assertEquals(0, paintCalled);
	}

}
