package gameframework.drawing;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DrawableComposite implements Drawable {
	protected List<Drawable> drawables = new ArrayList<>();

	public void add(Drawable e) {
		drawables.add(e);
	}

	public void remove(Drawable e) {
		drawables.remove(e);
	}

	@Override
	public void draw(Graphics g) {
		for (Drawable elem : drawables) {
			elem.draw(g);
		}
	}
}
