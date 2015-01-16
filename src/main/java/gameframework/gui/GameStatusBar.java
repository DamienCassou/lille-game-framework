package gameframework.gui;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GameStatusBar implements Observer {

	protected final ArrayList<GameStatusBarElement> elements = new ArrayList<GameStatusBarElement>();

	public Container getContainer() {
		JPanel container = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		container.setLayout(layout);

		for (GameStatusBarElement element : elements) {
			container.add(element.getElementText());
			container.add(element.getElementValue());
		}

		update();
		return container;
	}

	public void add(GameStatusBarElement newElement) {
		this.elements.add(newElement);
	}

	public void addAll(List<GameStatusBarElement> newElements) {
		this.elements.addAll(newElements);
	}

	public void update() {
		for (GameStatusBarElement element : elements) {
			element.getElementValue().setText(element.getString());
		}
	}

	@Override
	public void update(Observable o, Object arg) {
		update();
	}

}
