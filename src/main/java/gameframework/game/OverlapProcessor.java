package gameframework.game;

import gameframework.base.Overlappable;

public interface OverlapProcessor {
	public void addOverlappable(Overlappable p);

	public void removeOverlappable(Overlappable p);

	public void setOverlapRules(OverlapRulesApplier overlapRules);

	public void processOverlapsAll();
}
