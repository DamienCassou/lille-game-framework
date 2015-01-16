package gameframework.gui;

import gameframework.base.ObservableValue;

public class MockGameStatusBarElement extends GameStatusBarElement{

	public MockGameStatusBarElement(String elementText,
			ObservableValue<?> observableValue) {
		super(elementText, observableValue);
		this.elementText = null;
		this.elementValue = null;
	}

}
