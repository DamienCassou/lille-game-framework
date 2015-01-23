package gameframework.drawing;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.event.KeyListener;

public interface GameCanvas {

	Image createBuffer();

	MediaTracker createMediaTracker();

	void drawImage(Graphics graphics, Image image, int x, int y);

	void drawFullSizeImage(Graphics graphics, Image image);

	void drawFullSizeImage(Image buffer);

	void setBounds(int x, int y, int width, int height);

	int getWidth();

	int getHeight();

	void setSize(int width, int height);

	void addTo(Frame frame);

	void addKeyListener(KeyListener keyStr);

	void removeKeyListener(KeyListener keyStr);

	KeyListener[] getKeyListeners();

}
