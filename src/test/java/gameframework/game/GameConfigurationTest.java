package gameframework.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameConfigurationTest {

	GameConfiguration gameConfigurationDefaultValue;
	GameConfiguration gameConfigurationWithValue;
	GameConfiguration gameConfigurationWith0;

	
	@Before
	public void create(){
		int nbRows = 10;
		int nbColumns = 10;
		int spriteSize = 32;
		int nbLives = 50;
		gameConfigurationWithValue = new GameConfiguration(nbRows, nbColumns, spriteSize, nbLives);
		gameConfigurationDefaultValue = new GameConfiguration();
		gameConfigurationWith0 = new GameConfiguration(0, 0, 0, 0);	
	}
	
	@Test
	public void testGameConfigurationWithDefaultValue() {		
		//Check with the Default value from GameConfiguration
		assertEquals(31, gameConfigurationDefaultValue.getNbRows());
		assertEquals(28, gameConfigurationDefaultValue.getNbColumns());
		assertEquals(16, gameConfigurationDefaultValue.getSpriteSize());
		assertEquals(2, gameConfigurationDefaultValue.getDefaultNbLives());
	}
	
	@Test
	public void testGameConfigurationWithValue() {
		//Check with value from GameConfiguration
		assertEquals(10, gameConfigurationWithValue.getNbRows());
		assertEquals(10, gameConfigurationWithValue.getNbColumns());
		assertEquals(32, gameConfigurationWithValue.getSpriteSize());
		assertEquals(50, gameConfigurationWithValue.getDefaultNbLives());
	}
	
	@Test
	public void testGameConfigurationWithZero() {		
		//Check with 0 in value from GameConfiguration
		assertEquals(31, gameConfigurationWith0.getNbRows());
		assertEquals(28, gameConfigurationWith0.getNbColumns());
		assertEquals(16, gameConfigurationWith0.getSpriteSize());
		assertEquals(2, gameConfigurationWith0.getDefaultNbLives());
	}
	
	@Test
	public void testCreateCanvas() {
		assertNotNull(gameConfigurationDefaultValue.createCanvas());
	}

	@Test
	public void testCreateMoveBlockerRulesApplier() {
		assertNotNull(gameConfigurationDefaultValue.createMoveBlockerRulesApplier());
	}

	@Test
	public void testCreateMoveBlockerChecker() {
		assertNotNull(gameConfigurationDefaultValue.createMoveBlockerChecker());
	}

	@Test
	public void testcreateOverlapRulesApplier() {
		assertNotNull(gameConfigurationDefaultValue.createOverlapRulesApplier());
	}

	@Test
	public void testcreateOverlapProcessor() {
		assertNotNull(gameConfigurationDefaultValue.createOverlapProcessor());
	}

	@Test
	public void testcreateUniverse() {
		assertNotNull(gameConfigurationDefaultValue.createUniverse());
	}
}
