package gameframework.motion.overlapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Overlap {

	Overlappable overlappable1, overlappable2;

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

	public Set<Overlappable> getOverlappables() {
		return new HashSet<Overlappable>(Arrays.asList(overlappable1,
				overlappable2));
	}

}
