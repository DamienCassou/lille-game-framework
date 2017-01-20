package gameframework.base;

import java.util.Observable;

/**
 * Class whose role is quite similar to a variable except that
 * it can be observed to use callbacks.
 *
 * Example: suppose you have a method called "OnPlayerDeath",
 * you can use this class to see if a player's life reaches 0
 * and tell that the observers to call that method.
 *
 * For more information, search the "Observer" design pattern
 * on the Internet.
 *
 * @see java.util.Observable
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
	 * Returns the value itself.
	 * @return The value.
	 */
	public T getValue() {
		return value;
	}
}
