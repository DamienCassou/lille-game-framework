package gameframework.motion;

import java.awt.Point;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SpeedVectorTest {

	@Test
	public void nullVector() {
		SpeedVector nullVector = SpeedVector.createNullVector();
		assertEquals(0, nullVector.getSpeed());
		assertEquals(new Point(0, 0), nullVector.getDirection());
	}

}
