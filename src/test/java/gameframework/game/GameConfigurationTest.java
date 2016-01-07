package gameframework.game;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import gameframework.drawing.GameCanvas;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerRulesApplier;
import gameframework.motion.overlapping.OverlapProcessor;
import gameframework.motion.overlapping.OverlapRulesApplier;

public class GameConfigurationTest {

	GameConfiguration gameConfig;
	GameConfiguration myGameConfigurationDefaultValue;
	GameConfiguration myGameConfigurationWithValue;
	GameConfiguration myGameConfigurationWith0;
	GameConfiguration myGameConfiguration;

	
	@Before
	public void create(){
		int nbRows = 10;
		int nbColumns = 10;
		int spriteSize = 32;
		int nbLives = 50;
		myGameConfigurationWithValue = new GameConfiguration(nbRows, nbColumns, spriteSize, nbLives);
		myGameConfigurationDefaultValue = new GameConfiguration();
		myGameConfigurationWith0 = new GameConfiguration(0, 0, 0, 0);	
		myGameConfiguration = new GameConfiguration(0, 0, 0, 0);	
	}
	
	@Test
	public void testGameConfigurationWithDefaultValue() {		
		//Check with the Default value from GameConfiguration
		assertEquals(31, myGameConfigurationDefaultValue.getNbRows());
		assertEquals(28, myGameConfigurationDefaultValue.getNbColumns());
		assertEquals(16, myGameConfigurationDefaultValue.getSpriteSize());
		assertEquals(2, myGameConfigurationDefaultValue.getDefaultNbLives());
	}
	
	@Test
	public void testGameConfigurationWithValue() {
		//Check with value from GameConfiguration
		assertEquals(10, myGameConfigurationWithValue.getNbRows());
		assertEquals(10, myGameConfigurationWithValue.getNbColumns());
		assertEquals(32, myGameConfigurationWithValue.getSpriteSize());
		assertEquals(50, myGameConfigurationWithValue.getDefaultNbLives());
	}
	
	@Test
	public void testGameConfigurationWithZero() {		
		//Check with 0 in value from GameConfiguration
		assertEquals(31, myGameConfigurationWith0.getNbRows());
		assertEquals(28, myGameConfigurationWith0.getNbColumns());
		assertEquals(16, myGameConfigurationWith0.getSpriteSize());
		assertEquals(2, myGameConfigurationWith0.getDefaultNbLives());
	}
	
	@Test 
	public void testCreateCanvas(){
		GameCanvas myGameCanvas = myGameConfiguration.createCanvas();
		assertNotNull(myGameCanvas);
	}

	@Test 
	public void testCreateMoveBlockerRulesApplier(){
		MoveBlockerRulesApplier myMoveBlockerRulesApplier = myGameConfiguration.createMoveBlockerRulesApplier();
		assertNotNull(myMoveBlockerRulesApplier);
	}
	
	@Test 
	public void testCreateMoveBlockerChecker(){
		MoveBlockerChecker myMoveBlockerChecker = myGameConfiguration.createMoveBlockerChecker();
		assertNotNull(myMoveBlockerChecker);
	}
	
	@Test 
	public void testcreateOverlapRulesApplier(){
		OverlapRulesApplier myOverlapRulesApplier = myGameConfiguration.createOverlapRulesApplier();
		assertNotNull(myOverlapRulesApplier);
	}
	
	@Test 
	public void testcreateOverlapProcessor(){
		OverlapProcessor myOverlapProcessor = myGameConfiguration.createOverlapProcessor();
		assertNotNull(myOverlapProcessor);
	}
	
	@Test 
	public void testcreateUniverse(){
		GameUniverse myGameUniverse = myGameConfiguration.createUniverse();
		assertNotNull(myGameUniverse);
	}	
}
