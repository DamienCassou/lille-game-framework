package gameframework.motion.overlapping;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class OverlapTest {

	Overlappable overlappable1;
	Overlappable overlappable2; 
	Overlap overlap;

	@Before
	public void create(){
		 overlappable1 = new Overlappable1();
		 overlappable2 = new Overlappable1();
		 overlap = new Overlap(overlappable1, overlappable2);
	}
	
	@Test
	public void getOverlappable1Test() {
		assertSame(overlappable1, overlap.getOverlappable1());		
	}
	
	@Test
	public void getOverlappable2Test() {
		assertSame(overlappable2, overlap.getOverlappable2());		
	}
	
	@Test
	public void getOverlappablesTest(){
			Set<Overlappable> set = new HashSet<Overlappable>(Arrays.asList(overlappable1,
					overlappable2));
			assertEquals(set, overlap.getOverlappables());		
		}
}
