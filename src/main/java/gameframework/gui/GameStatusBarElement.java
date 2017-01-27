package gameframework.gui;

import gameframework.base.ObservableValue;

import java.awt.Label;
import java.util.Observer;

/**
 * This class enable to create new elements which will be printed on the Game
 * status bar, like : "life: low", where "life:" is the elementText an "low" the
 * element String
 * 
 * @author Mickael Alvarez
 * 
 */
public class GameStatusBarElement<T> {
	protected Label elementText, elementValue;
	protected final ObservableValue<T> element;

	/**
	 * Define the element and is printed text
	 * 
	 * @param elementText
	 * @param observableValue
	 */
	public GameStatusBarElement(String elementText,
			ObservableValue<T> observableValue) {
		this.element = observableValue;
		this.elementText = new Label(elementText);
		this.elementValue = new Label();
	}

	public Label getElementText() {
		return this.elementText;
	}

	public Label getElementValue() {
		return this.elementValue;
	}

	public String getString() {
		return this.element.getValue().toString();
	}

	public ObservableValue<T> getElement() {
		return this.element;
	}

	public void addObserver(Observer observer) {
		this.element.addObserver(observer);
	}

	public void update() {
		this.elementValue.setText(this.getString());
	}
}
