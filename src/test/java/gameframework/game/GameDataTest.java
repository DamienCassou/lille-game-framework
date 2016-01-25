package gameframework.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameframework.base.ObservableValue;

public class GameDataTest {

	GameData gd;
	
	@Before
	public void init()	{
		// GameConfiguration is 100 test-covered, thus trusted
		gd = new GameData(new GameConfiguration());
	}
	
	@Test
	public void GameDataConstructorTest()	{
		assertNotNull(gd.getCanvas());
		
		// Score must be equals to 0 (default values)
		assertNotNull(gd.getScore());
		assertEquals(new ObservableValue<Integer>(0).getValue(), gd.getScore().getValue());
		
		// Life must be equals to 2 (default values)
		assertNotNull(gd.getLife());
		assertEquals(new ObservableValue<Integer>(2).getValue(), gd.getLife().getValue());
		
		// EndOfGame boolean should be false (default values)
		assertNotNull(gd.getEndOfGame());
		assertEquals(new ObservableValue<Boolean>(false).getValue(), gd.getEndOfGame().getValue());
		
		// And Levels map should be empty but not null
		assertNotNull(gd.getLevels());
		assertEquals(0, gd.getLevels().size());
		
		// Everything else is up to GameConfiguration
	}
	
	
	@Test
	public void increaseLifeTest()	{
		gd.increaseLife(25);
		assertEquals(new ObservableValue<Integer>(27).getValue(), gd.getLife().getValue());
		
		// This should not be possible but still testing
		gd.increaseLife(-25);
		assertEquals(new ObservableValue<Integer>(2).getValue(), gd.getLife().getValue());
	}
	
	@Test
	public void decreaseLifeTest()	{
		gd.decreaseLife(1);
		assertEquals(new ObservableValue<Integer>(1).getValue(), gd.getLife().getValue());
		
		gd.decreaseLife(3);
		assertEquals(new ObservableValue<Integer>(0).getValue(), gd.getLife().getValue());
	}
	
	@Test
	public void addLevelTest()	{
		gd.getLevels().add(new GameLevelDefaultImpl(gd) {
			
			@Override
			protected void init() {
				// TODO Auto-generated method stub
				
			}
		});
		
		assertEquals(1, gd.getLevels().size());
	}
}
