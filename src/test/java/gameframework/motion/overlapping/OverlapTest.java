package gameframework.motion.overlapping;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class OverlapTest {

	@Test
	public void getOverlappable1Test() {
		Overlappable overlappable1 =  new Overlappable1();
		Overlappable overlappable2 =  new Overlappable1();
		Overlap overlap = new Overlap(overlappable1, overlappable2);
		assertSame(overlappable1, overlap.getOverlappable1());		
	}
	
	@Test
	public void getOverlappable2Test() {
		Overlappable overlappable1 =  new Overlappable1();
		Overlappable overlappable2 =  new Overlappable1();
		Overlap overlap = new Overlap(overlappable1, overlappable2);
		assertSame(overlappable2, overlap.getOverlappable2());		
	}
	
	@Test
	public void getOverlappablesTest(){
			Overlappable overlappable1 =  new Overlappable1();
			Overlappable overlappable2 =  new Overlappable1();
			Overlap overlap = new Overlap(overlappable1, overlappable2);
			Set<Overlappable> set = new HashSet<Overlappable>(Arrays.asList(overlappable1,
					overlappable2));
			assertEquals(set, overlap.getOverlappables());		
		}
}
