package gameframework.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameDataTest {
	
	
	GameConfiguration aGameConfiguration;
	GameData aGameData;
	Game aGame;
	
	@Before
	public void init(){
		aGameConfiguration = new GameConfiguration();
		aGameData = new GameData(aGameConfiguration);
		aGame = new GameDefaultImpl(aGameData);
	}
	
	@Test
	public void decreaseLife(){
		int livesDeleted = 1 ;
		int livesExpected = aGameConfiguration.getDefaultNbLives() - livesDeleted;
		assertTrue(aGameData.getLife().getValue() == aGameConfiguration.getDefaultNbLives());
		aGameData.decreaseLife(livesDeleted);
		assertTrue(livesExpected == aGameData.getLife().getValue());
		assertTrue(aGameData.getLife().getValue() >= 0);
	}
	
	@Test
	public void increaseLife(){
		int livesAdded = 1 ;
		int livesExpected = aGameConfiguration.getDefaultNbLives() + livesAdded;
		assertTrue(aGameData.getLife().getValue() == aGameConfiguration.getDefaultNbLives());
		aGameData.increaseLife(livesAdded);
		assertTrue(livesExpected == aGameData.getLife().getValue());
	}

}
