package gameframework.drawing;

import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

/**
 * Manager that handles all the inputs which must have an effect on a given canvas.
 */
public class InputManager {
	
	/**
	 * The canvas whose inputs are managed by this manager
	 */
	protected final Canvas canvas;

	/**
	 * Constructor
	 * @param canvas the canvas whose inputs will be managed
	 */
	public InputManager(Canvas canvas) {
		this.canvas = canvas;
	}
	
	public void addKeyListener(KeyListener keyStr) {
		canvas.addKeyListener(keyStr);
	}
	public void removeKeyListener(KeyListener keyStr) {
		canvas.removeKeyListener(keyStr);
	}
	public KeyListener[] getKeyListeners() {
		return canvas.getKeyListeners();
	}
	
	public void addMouseListener(MouseListener listener) {
		canvas.addMouseListener(listener);
	}
	public void removeMouseListener(MouseListener listener) {
		canvas.removeMouseListener(listener);
	}
	public MouseListener[] getMouseListeners() {
		return canvas.getMouseListeners();
	}
}
