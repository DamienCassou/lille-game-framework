package gameframework.game;

import java.awt.Graphics;

public interface GameEntity {
	public void draw(Graphics g);
	public boolean isMovable();
}
