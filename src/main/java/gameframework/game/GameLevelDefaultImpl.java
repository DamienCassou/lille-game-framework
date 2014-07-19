package gameframework.game;

import java.util.Date;

/**
 * To be implemented with respect to a specific game. Expected to initialize the
 * universe and the gameBoard
 */
public abstract class GameLevelDefaultImpl extends Thread implements GameLevel {
	private static final int MINIMUM_DELAY_BETWEEN_GAME_CYCLES = 100;
	protected GameUniverse universe;
	protected GameUniverseViewPort gameBoard;
	protected final GameData data;
	protected final int spriteSize;

	boolean stopGameLoop;

	protected abstract void init();

	public GameLevelDefaultImpl(GameData data) {
		this.data = data;
		this.spriteSize = data.getConfiguration().getSpriteSize();
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
			long sleepTime = MINIMUM_DELAY_BETWEEN_GAME_CYCLES
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
