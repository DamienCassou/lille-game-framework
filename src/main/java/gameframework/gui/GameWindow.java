package gameframework.gui;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameConfiguration;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow {

	protected final Frame frame;
	protected GameCanvas gameCanvas;

	protected final ObservableValue<Integer> score;
	protected final ObservableValue<Integer> life;

	public GameWindow(GameCanvas gameCanvas, GameConfiguration configuration,
			ObservableValue<Integer> score, ObservableValue<Integer> life) {
		this("Default Game", gameCanvas, configuration, score, life);
	}

	public GameWindow(String gameName, GameCanvas gameCanvas,
			GameConfiguration configuration, ObservableValue<Integer> score,
			ObservableValue<Integer> life) {
		if (gameCanvas == null) {
			throw new IllegalArgumentException("gameCanvas is null");
		}
		this.score = score;
		this.life = life;
		this.frame = new Frame(gameName);
		this.gameCanvas = gameCanvas;
		this.gameCanvas.setSize(//
				configuration.getSpriteSize() * configuration.getNbColumns(), //
				configuration.getSpriteSize() * configuration.getNbRows());
	}

	public void createGUI() {
		frame.dispose();
		frame.setMenuBar(new GameMenuBar().getComponent());
		gameCanvas.addTo(frame);
		frame.add(new GameStatusBar(score, life).getContainer(),
				BorderLayout.NORTH);
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
