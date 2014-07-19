package gameframework.gui;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenuBar {

	public MenuBar getComponent() {
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("file");
		MenuItem quit = new MenuItem("quit");
		menuBar.add(file);

		quit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		file.add(quit);

		return menuBar;
	}

}
