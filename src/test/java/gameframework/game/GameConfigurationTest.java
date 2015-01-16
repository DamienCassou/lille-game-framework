package gameframework.game;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameConfigurationTest {

	GameConfiguration gameConfig ;
	
	@Test
	public void testGameConfigurationWithDefaultValue() {
		gameConfig = new GameConfiguration();
		
		//Check with the Default value from GameConfiguration
		assertEquals(31, gameConfig.nbRows);
		assertEquals(28, gameConfig.nbColumns);
		assertEquals(16, gameConfig.spriteSize);
		assertEquals(2, gameConfig.nbLives);
	}
	
	@Test
	public void testGameConfigurationWithValue() {
		int nbRows = 10;
		int nbColumns = 10;
		int spriteSize = 32;
		int nbLives = 50;
		gameConfig = new GameConfiguration(nbRows, nbColumns, spriteSize, nbLives);
		
		assertEquals(nbRows, gameConfig.nbRows);
		assertEquals(nbColumns, gameConfig.nbColumns);
		assertEquals(spriteSize, gameConfig.spriteSize);
		assertEquals(nbLives, gameConfig.nbLives);
	}
	
	@Test
	public void testGameConfigurationWithZero() {
		gameConfig = new GameConfiguration(0, 0, 0, 0);
		
		//Check with the Default value from GameConfiguration
		assertEquals(31, gameConfig.nbRows);
		assertEquals(28, gameConfig.nbColumns);
		assertEquals(16, gameConfig.spriteSize);
		assertEquals(2, gameConfig.nbLives);
	}

}
