package gameframework.gui;

import static org.junit.Assert.assertEquals;
import gameframework.base.ObservableValue;

import org.junit.Before;
import org.junit.Test;

public class GameStatusBarElementTest {
	String elementText;
	ObservableValue<Integer> integerValue;
	ObservableValue<Double> doubleValue;
	ObservableValue<String> stringValue;
	ObservableValue<Character> charValue;
	ObservableValue<Float> floatValue;

	@Before
	public void createGameStatusBarElement() {
		this.elementText = new String("text");
		this.integerValue = new ObservableValue<Integer>(2);
		this.doubleValue = new ObservableValue<Double>(0.4);
		this.stringValue = new ObservableValue<String>("test");
		this.charValue = new ObservableValue<Character>('a');
		this.floatValue = new ObservableValue<Float>((float) 1.3);
	}

	@Test
	public void getStringFromInteger() {
		MockGameStatusBarElement element = new MockGameStatusBarElement(
				null, this.integerValue);
		assertEquals("2", element.getString());
	}

	@Test
	public void getStringFromDouble() {
		GameStatusBarElement element = new GameStatusBarElement(
				this.elementText, this.doubleValue);
		assertEquals("0.4", element.getString());
	}

	@Test
	public void getStringFromString() {
		GameStatusBarElement element = new GameStatusBarElement(
				this.elementText, this.stringValue);
		assertEquals("test", element.getString());
	}

	@Test
	public void getStringFromCharacter() {
		GameStatusBarElement element = new GameStatusBarElement(
				this.elementText, this.charValue);
		assertEquals("a", element.getString());
	}

	@Test
	public void getStringFromFloat() {
		GameStatusBarElement element = new GameStatusBarElement(
				this.elementText, this.floatValue);
		assertEquals("1.3", element.getString());
	}
}
