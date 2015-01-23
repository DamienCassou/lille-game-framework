package gameframework.game;

import gameframework.drawing.GameUniverseViewPort;

import java.util.Date;

/**
 * To be implemented with respect to a specific game. Expected to initialize the
 * universe and the gameBoard
 */
public abstract class GameLevelDefaultImpl extends Thread implements GameLevel {
	private static final int DEFAULT_MINIMUM_DELAY_BETWEEN_GAME_CYCLES = 100;
	protected final int minimumDelayBetweenCycles;
	protected GameUniverse universe;
	protected GameUniverseViewPort gameBoard;
	protected final GameData data;
	protected final int spriteSize;

	protected boolean stopGameLoop;

	protected abstract void init();

	public GameLevelDefaultImpl(GameData data) {
		this(data, DEFAULT_MINIMUM_DELAY_BETWEEN_GAME_CYCLES);
	}

	public GameLevelDefaultImpl(GameData data, int minimumDelayBetweenCycles) {
		this.data = data;
		this.spriteSize = data.getConfiguration().getSpriteSize();
		this.universe = data.getUniverse();
		this.minimumDelayBetweenCycles = minimumDelayBetweenCycles;
	}

	@Override
	public void start() {
		init();
		super.start();
		try {
			super.join();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void run() {
		stopGameLoop = false;
		// main game loop :
		long start;
		while (!stopGameLoop && !this.isInterrupted()) {
			start = new Date().getTime();
			gameBoard.paint();
			universe.allOneStepMoves();
			universe.processAllOverlaps();
			long sleepTime = minimumDelayBetweenCycles
					- (new Date().getTime() - start);
			if (sleepTime > 0) {
				try {
					Thread.sleep(sleepTime);
				} catch (InterruptedException e) {
					// that's ok, we just didn't managed to finish sleeping
				}
			}
		}
	}

	public void end() {
		stopGameLoop = true;
	}

	protected void overlap_handler() {
	}

}
