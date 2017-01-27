package gameframework.drawing;

import static org.junit.Assert.*;

import java.awt.event.KeyListener;

import org.junit.Before;
import org.junit.Test;

import gameframework.drawing.mocks.KeyListenerMock;

public class GameCanvasDefaultImplTest {

	protected GameCanvasDefaultImpl gameCanvas;
	protected KeyListenerMock keyListener;
	
	@Before
	public void init() {
		gameCanvas  = new GameCanvasDefaultImpl();
		keyListener = new KeyListenerMock();
	}
	
	public KeyListener getLatestKeyListenerAdded() {
		int lastIndex = gameCanvas.getKeyListeners().length - 1;
		return gameCanvas.getKeyListeners()[lastIndex];
	}
	
	@Test
	public void testAddKeyListener() {
		gameCanvas.addKeyListener(keyListener);
		assertSame(keyListener, getLatestKeyListenerAdded());
	}

	@Test
	public void testRemoveKeyListener() {
		int expected = gameCanvas.getKeyListeners().length;
		
		gameCanvas.addKeyListener(keyListener);		
		assertEquals(expected + 1, gameCanvas.getKeyListeners().length);
		
		gameCanvas.removeKeyListener(keyListener);
		assertEquals(expected, gameCanvas.getKeyListeners().length);
	}

}
