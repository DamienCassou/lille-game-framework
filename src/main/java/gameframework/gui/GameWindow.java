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
	
	public void hideStatusBar() {
		setStatusBarVisibility(false);
	}
	
	public void showStatusBar() {
		setStatusBarVisibility(true);
	}
	
	/**
	 * Shows or hide the status bar depending of the value of parameter showStatusBar.
	 * @param showStatusBar if true - shows the status bar; otherwise, hides the status bar.
	 */
	protected void setStatusBarVisibility(boolean showStatusBar) {
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
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		setStatusBarVisibility(showStatusBar);
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}

	/**
	 * @param comp component to add
	 * @param layout the layout in which you want to add the component
	 */
	public void add(Component comp, String layout) {
		this.frame.add(comp, layout);
		this.frame.pack();
	}

}
