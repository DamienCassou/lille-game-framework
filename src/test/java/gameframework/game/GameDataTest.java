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
		int deletedLives = 1 ;
		int expectedLives = aGameConfiguration.getDefaultNbLives() - deletedLives;
		assertEquals((int)aGameData.getLife().getValue(), aGameConfiguration.getDefaultNbLives());
		aGameData.decreaseLife(deletedLives);
		assertEquals(expectedLives, (int)aGameData.getLife().getValue());
		assertTrue(aGameData.getLife().getValue() >= 0);
	}
	
	@Test
	public void increaseLife(){
		int addedLives = 1;
		int expectedLives = aGameConfiguration.getDefaultNbLives() + addedLives;
		assertEquals((int)aGameData.getLife().getValue(), aGameConfiguration.getDefaultNbLives());
		aGameData.increaseLife(addedLives);
		assertEquals(expectedLives, (int)aGameData.getLife().getValue());
	}
	
}