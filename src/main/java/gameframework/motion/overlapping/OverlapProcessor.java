package gameframework.motion.overlapping;

/**
 * 
 * This interface is used to process OverlapRules on Overlappables
 *
 */
public interface OverlapProcessor {
	/**
	 * Add a new Overlappable to the OverlapProcessor
	 * @param p is the new Overlappable
	 */
	public void addOverlappable(Overlappable p);
	
	/**
	 * Remove an Overlappable from the OverlapProcessor. The method does not fail if the Overlappable has been removed already
	 * @param p is the Overlappable to remove
	 */
	public void removeOverlappable(Overlappable p);

	/**
	 * Define the OverlapRulesApplier, who will apply the rules defined in
	 * @see OverlapRulesApplier
	 * @param overlapRules is the OverlapRulesApplier you want to apply
	 */
	public void setOverlapRules(OverlapRulesApplier overlapRules);
	
	/**
	 * Apply the rules defined by the OverlapRulesApplier on every Overlaps
	 */
	public void processOverlapsAll();
}
