package gameframework.gui;

import gameframework.base.ObservableValue;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.Component;

public class GameWindow {

	protected final Frame frame;
	protected GameCanvas gameCanvas;

	protected final ObservableValue<Integer> score;
	protected final ObservableValue<Integer> life;

	public GameWindow(GameCanvas gameCanvas, GameData data) {
		this("Default Game", gameCanvas, data);
	}

	public GameWindow(String gameName, GameCanvas gameCanvas,
			GameData data) {
		if (gameCanvas == null) {
			throw new IllegalArgumentException("gameCanvas is null");
		}
		this.score = data.getScore();
		this.life = data.getLife();
		this.frame = new Frame(gameName);
		this.gameCanvas = gameCanvas;
		this.gameCanvas.setSize(//
				data.getConfiguration().getSpriteSize() * data.getConfiguration().getNbColumns(), //
				data.getConfiguration().getSpriteSize() * data.getConfiguration().getNbRows());
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
	
	public void add(Component comp, String layout){
		this.frame.add(comp, layout);
	}
	
}
