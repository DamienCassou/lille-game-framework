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

	protected final Frame frame;
	protected final GameCanvas gameCanvas;
	protected final GameStatusBar statusBar = new GameStatusBar();
	protected boolean showStatusBar = true;

	@Deprecated
	public GameWindow(GameCanvas gameCanvas, GameConfiguration configuration,
			final ObservableValue<Integer> score,
			final ObservableValue<Integer> life) {
		this("Default Game", gameCanvas, configuration,
				new GameStatusBarElement<>("Score:", score),
				new GameStatusBarElement<>("Life:", life));
	}
	
	/**
	 * add a new status bar element to the status bar
	 * @param elementName the name of the element
	 * @param observableValue the observable value of the element
	 */
	public void addStatusBarElement(String elementName, ObservableValue<?> observableValue) {
		addStatusBarElement(new GameStatusBarElement<>(elementName, observableValue));
	}
	
	/**
	 * add the status bar element to the game status bar.
	 * @param gameStatusBarElement the statusBarElement to add.
	 */
	public void addStatusBarElement(GameStatusBarElement<?> gameStatusBarElement) {
		statusBar.add(gameStatusBarElement);
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
	 * @param configuration the game configuration
	 * @param elementsStatusBar list of element(s) for the status bar
	 */
	public GameWindow(String gameName, GameCanvas gameCanvas,
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
	 * hide the status bar
	 */
	public void hideStatusBar() {
		showStatusBar(false);
	}
	
	/**
	 * show the status bar
	 */
	public void showStatusBar() {
		showStatusBar(true);
	}
	
	/**
	 * Shows or hide the status bar depending of the value of parameter showStatusBar.
	 * @param showStatusBar if true - shows the status bar; otherwise, hides the status bar.
	 */
	private void showStatusBar(boolean showStatusBar) {
		// "showStatusBar" attribute must be set in case of this function is called before "createGUI".
		// Otherwise, it doesn't hide the status bar correctly.
		this.showStatusBar = showStatusBar;
		statusBar.getContainer().setVisible(showStatusBar);
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
		showStatusBar(showStatusBar);
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