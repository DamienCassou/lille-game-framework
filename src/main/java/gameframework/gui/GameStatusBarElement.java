package gameframework.gui;

import gameframework.base.ObservableValue;

import java.awt.Label;

/**
 * This class enable to create new elements which will be printed on the Game
 * status bar, like : "life: low", where "life:" is the elementText an "low" the
 * element String
 * 
 * @author Mickael Alvarez
 * 
 */
public class GameStatusBarElement {
	protected Label elementText, elementValue;
	protected final ObservableValue<?> element;

	/**
	 * Define the element and is printed text
	 * 
	 * @param elementText
	 * @param observableValue
	 */
	public GameStatusBarElement(String elementText,
			ObservableValue<?> observableValue) {
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

	public ObservableValue<?> getElement() {
		return this.element;
	}

}