package gameframework.drawing.mocks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerMock implements KeyListener {

	protected boolean isPressed  = false;
	protected boolean isReleased = false;
	protected boolean isTyped 	 = false;
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		isPressed = true;
	}
	
	public boolean isPressed() {
		return isPressed;
	}

	public void setPressed(boolean isPressed) {
		this.isPressed = isPressed;
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		isReleased = true;
	}
	
	public boolean isReleased() {
		return isReleased;
	}

	public void setReleased(boolean isReleased) {
		this.isReleased = isReleased;
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		isTyped = true;
	}

	public boolean isTyped() {
		return isTyped;
	}

	public void setTyped(boolean isTyped) {
		this.isTyped = isTyped;
	}
}
