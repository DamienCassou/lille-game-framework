package gameframework.motion.overlapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Overlap is used when two entities are on the same position
 *
 */
public class Overlap {

	Overlappable overlappable1, overlappable2;
	
	/**
	 * Create an Overlap between the given parameters
	 * @param overlappable1 is the first Overlappable
	 * @param overlappable2 is the second Overlappable
	 */
	public Overlap(Overlappable overlappable1, Overlappable overlappable2) {
		super();
		this.overlappable1 = overlappable1;
		this.overlappable2 = overlappable2;
	}

	public Overlappable getOverlappable1() {
		return overlappable1;
	}

	public Overlappable getOverlappable2() {
		return overlappable2;
	}
	
	/**
	 * 
	 * @return a Set<> containing the two Overlappables
	 */
	public Set<Overlappable> getOverlappables() {
		return new HashSet<Overlappable>(Arrays.asList(overlappable1,
				overlappable2));
	}

}
