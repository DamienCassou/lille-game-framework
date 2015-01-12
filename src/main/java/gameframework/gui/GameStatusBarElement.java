package gameframework.gui;

import gameframework.base.ObservableValue;

import java.awt.Label;

public class GameStatusBarElement {
	protected Label elementText, elementValue;
	protected final ObservableValue<Integer> element;
	
	/**
	 * Define the element and is printed text
	 * 
	 * @param elementText
	 * @param element
	 */
	public GameStatusBarElement(String elementText, ObservableValue<Integer> element){
		this.element = element;
		this.elementText = new Label(elementText);
		this.elementValue = new Label();
	}
	
	public Label getElementText() {
		return this.elementText;
	}
	
	public Label getElementValue() {
		return this.elementValue;
	}
	
	public ObservableValue<Integer> getElement() {
		return this.element;
	}
}