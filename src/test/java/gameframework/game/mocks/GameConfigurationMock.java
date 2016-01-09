package gameframework.game.mocks;

import gameframework.game.GameConfiguration;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.mocks.OverlapProcessorDefaultImplMock;

public class GameConfigurationMock extends GameConfiguration {
	
	public static final int TEST_NBROWS = 31;
	public static final int TEST_NBCOL = 28;
	public static final int TEST_SPRITESIZE = 16;
	public static final int TEST_NBLIVES = 2;
	
	public GameConfigurationMock() {
		super(TEST_NBROWS, TEST_NBCOL, TEST_SPRITESIZE, TEST_NBLIVES);
	}

	@Override
	public OverlapProcessor createOverlapProcessor() {
		return new OverlapProcessorDefaultImplMock();
	}
}
