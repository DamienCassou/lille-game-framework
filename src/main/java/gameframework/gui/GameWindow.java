package gameframework.gui;

import gameframework.base.ObservableValue;
import gameframework.game.GameConfiguration;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GameWindow {

	protected final Frame frame;
	protected Canvas gameCanvas;

	protected final ObservableValue<Integer> score;
	protected final ObservableValue<Integer> life;

	public GameWindow(Canvas gameCanvas, GameConfiguration configuration,
			ObservableValue<Integer> score, ObservableValue<Integer> life) {
		if (gameCanvas == null) {
			throw new IllegalArgumentException("gameCanvas is null");
		}
		this.score = score;
		this.life = life;
		this.frame = new Frame("Default Game");
		this.gameCanvas = gameCanvas;
		this.gameCanvas.setSize(//
				configuration.getSpriteSize() * configuration.getNbColumns(), //
				configuration.getSpriteSize() * configuration.getNbRows());
	}

	public void createGUI() {
		frame.dispose();
		frame.setMenuBar(new GameMenuBar().getComponent());

		frame.add(gameCanvas);
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
