package gameframework.game;

import gameframework.base.ObservableValue;

import java.awt.Canvas;

public interface Game {
	public void createGUI();

	public Canvas getCanvas();

	public void start();

	public void restore();

	public void save();

	public void pause();

	public void resume();

	public ObservableValue<Integer>[] score();

	public ObservableValue<Integer>[] life();

	public ObservableValue<Boolean> endOfGame();
}
