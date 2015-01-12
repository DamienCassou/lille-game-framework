package gameframework.gui;

import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class GameWindow {

	protected final Frame frame;
	protected GameCanvas gameCanvas;
	
	protected ArrayList<GameStatusBarElement> elementsStatusBar = new ArrayList<GameStatusBarElement>();
	
	
	public GameWindow(GameCanvas gameCanvas, GameConfiguration configuration,
			ArrayList<GameStatusBarElement> elementsStatusBar) {
		if (gameCanvas == null) {
			throw new IllegalArgumentException("gameCanvas is null");
		}
		
		this.elementsStatusBar.addAll(elementsStatusBar);
		this.frame = new Frame("Default Game");
		this.gameCanvas = gameCanvas;
		this.gameCanvas.setSize(//
				configuration.getSpriteSize() * configuration.getNbColumns(), //
				configuration.getSpriteSize() * configuration.getNbRows());
	}

	public void createGUI() {
		frame.dispose();
		frame.setMenuBar(new GameMenuBar().getComponent());
		gameCanvas.addTo(frame);
		
		GameStatusBar statusBar = new GameStatusBar();
		statusBar.addAllElement(this.elementsStatusBar);
		frame.add(statusBar.getContainer(), BorderLayout.NORTH);
		frame.pack();
		frame.setVisible(true);

		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}