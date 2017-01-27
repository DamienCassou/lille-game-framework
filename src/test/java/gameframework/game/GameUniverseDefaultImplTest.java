package gameframework.game;

public class GameUniverseDefaultImplTest extends GameUniverseTest {

	@Override
	public GameUniverse createGameUniverse() {
		return new GameUniverseDefaultImpl(new GameData(new GameConfiguration()));
	}

}
