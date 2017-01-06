package gameframework.base;

import java.util.Observable;

/**
 * Class that represent an observable value.
 * Observable values are ideal to "trigger events"
 * upon value changes.
 */
public class ObservableValue<T> extends Observable {

	/** The value itself. */
	private T value;

	/**
	 * Create a new observable value with an initial value.
	 * @param initial Initial value to use.
	 */
	public ObservableValue(T initial) {
		setValue(initial);
	}

	/**
	 * Set a new value for this observable value.
	 * This will call "setChanged()" and "notifyObservers()" methods.
	 * If the new value is identical to the actual one, nothing will
	 * happen.
	 * @param newValue The new value to set.
	 */
	public void setValue(T newValue) {
		if (value != newValue) {
			this.value = newValue;
			setChanged();
			notifyObservers();
		}
	}

	/**
	 * Returns the value of this observed value.
	 * @return The value of this observed value.
	 */
	public T getValue() {
		return value;
	}
}
