package gameframework.base;

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

}
