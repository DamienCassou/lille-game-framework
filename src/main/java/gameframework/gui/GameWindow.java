package gameframework.gui;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.Component;

public class GameWindow {

	protected Frame frame;
	protected GameCanvas gameCanvas;
	protected final GameStatusBar statusBar = new GameStatusBar();


	@Deprecated
	public GameWindow(GameCanvas gameCanvas, GameConfiguration configuration,
			final ObservableValue<Integer> score,
			final ObservableValue<Integer> life) {
		this("Default Game", gameCanvas, configuration,
				new GameStatusBarElement<>("Score:", score),
				new GameStatusBarElement<>("Life:", life));
	}
	
	/**
	 * @param gameName the name of the window
	 * @param gameCanvas the canvas (View in MVC design pattern)
	 * @param data the game data (Model in MVC design pattern)
	 */
	public GameWindow(String gameName, GameCanvas gameCanvas, GameData data) {
		this(gameName, gameCanvas, data.getConfiguration(),
				new GameStatusBarElement<>("Score:", data.getScore()),
				new GameStatusBarElement<>("Life:", data.getLife()));
	}
	
	/**
	 * @param gameName the name of the window
	 * @param gameCanvas the canvas (View in MVC design pattern)
	 * @param data the game data (Model in MVC design pattern)
	 * @param enableStatusBar true or false to enable or disable Game Status Bar
	 */
	public GameWindow(String gameName, GameCanvas gameCanvas, GameData data, boolean enableStatusBar) {
		if (enableStatusBar) {
			init(gameName, gameCanvas, data.getConfiguration(),
					new GameStatusBarElement<>("Score:", data.getScore()),
					new GameStatusBarElement<>("Life:", data.getLife()));
		} else {
			init(gameName, gameCanvas, data.getConfiguration());
		}
	}

	/**
	 * @param gameName the name of the window
	 * @param gameCanvas the canvas (View in MVC design pattern)
	 * @param configuration the game configuration
	 * @param elementsStatusBar list of element(s) for the status bar
	 */
	public GameWindow(String gameName, GameCanvas gameCanvas,
			GameConfiguration configuration,
			GameStatusBarElement<?>... elementsStatusBar) {
		init(gameName, gameCanvas, configuration, elementsStatusBar);
	}
	
	/**
	 * Initialize the game window
	 * @param gameName the name of the window
	 * @param gameCanvas the canvas (View in MVC design pattern)
	 * @param configuration the game configuration
	 * @param elementsStatusBar list of element(s) for the status bar
	 */
	private void init(String gameName, GameCanvas gameCanvas,
			GameConfiguration configuration,
			GameStatusBarElement<?>... elementsStatusBar) {
		if (gameCanvas == null) {
			throw new IllegalArgumentException("gameCanvas is null");
		}
		this.statusBar.addAll(elementsStatusBar);
		this.frame = new Frame(gameName);
		this.gameCanvas = gameCanvas;
		this.gameCanvas.setSize(
				configuration.getSpriteSize() * configuration.getNbColumns(), 
				configuration.getSpriteSize() * configuration.getNbRows());
	}

	/**
	 * Create the main frame of the game.
	 */
	public void createGUI() {
		frame.dispose();
		frame.setMenuBar(new GameMenuBar().getComponent());
		gameCanvas.addTo(frame);
		frame.add(this.statusBar.getContainer(), BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * @param comp
	 * @param layout
	 */
	public void add(Component comp, String layout) {
		this.frame.add(comp, layout);
		this.frame.pack();
	}

}