package gameframework.gui;

import gameframework.base.ObservableValue;

import java.awt.Container;
import java.awt.GridBagLayout;
import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class GameStatusBar implements Observer {

	protected Label lifeText, scoreText;
	protected Label lifeValue, scoreValue;

	protected final ObservableValue<Integer> score;
	protected final ObservableValue<Integer> life;

	public GameStatusBar(ObservableValue<Integer> score,
			ObservableValue<Integer> life) {
		this.score = score;
		this.life = life;
		score.addObserver(this);
		life.addObserver(this);
	}

	public Container getContainer() {
		JPanel c = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		c.setLayout(layout);
		lifeText = new Label("Lives:");
		scoreText = new Label("Score:");
		lifeValue = new Label();
		scoreValue = new Label();
		c.add(lifeText);
		c.add(lifeValue);
		c.add(scoreText);
		c.add(scoreValue);
		update();
		return c;
	}

	public void update() {
		lifeValue.setText(Integer.toString(life.getValue()));
		scoreValue.setText(Integer.toString(score.getValue()));
	}

	@Override
	public void update(Observable o, Object arg) {
		update();
	}

}
