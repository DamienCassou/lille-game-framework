package gameframework.base;

import java.util.Observable;

public class ObservableValue<T> extends Observable {
	private T value;

	public ObservableValue(T initial) {
		setValue(initial);
	}

	public void setValue(T newValue) {
		if (value != newValue) {
			this.value = newValue;
			setChanged();
			notifyObservers();
		}
	}

	public T getValue() {
		return value;
	}
}
