package gameframework.base;

import java.awt.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class SpeedVectorDefaultImplTest {

	@Test
	public void nullVector() {
		SpeedVector nullVector = SpeedVectorDefaultImpl.createNullVector();
		assertEquals(0, nullVector.getSpeed());
		assertEquals(new Point(0, 0), nullVector.getDirection());
	}

}
