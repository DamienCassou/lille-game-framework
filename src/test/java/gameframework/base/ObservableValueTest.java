package gameframework.base;

import java.util.Observable;
import java.util.Observer;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ObservableValueTest implements Observer {

	ObservableValue<Boolean> value;
	int updateCount = 0;
	boolean initial = true;

	@Before
	public void createValue() {
		value = new ObservableValue<Boolean>(initial);
		value.addObserver(this);
	}

	@Test
	public void updateWhenChanged() throws Exception {
		assertEquals(0, updateCount);
		value.setValue(!initial);
		assertEquals(1, updateCount);
		assertEquals(!initial, value.getValue());
	}

	@Test
	public void noUpdateWhenNotChanged() throws Exception {
		assertEquals(0, updateCount);
		value.setValue(initial);
		assertEquals(0, updateCount);
		assertEquals(initial, value.getValue());
	}

	@Override
	public void update(Observable o, Object arg) {
		assertSame(value, o);
		updateCount++;
	}

}
