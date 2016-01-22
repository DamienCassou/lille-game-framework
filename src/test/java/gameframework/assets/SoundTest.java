package gameframework.assets;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.junit.Test;

public class SoundTest {

	@Test
	public void testSoundPlayback() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		Sound sound = new Sound("/PacmanSiren.wav");
		sound.play();
	}

}
