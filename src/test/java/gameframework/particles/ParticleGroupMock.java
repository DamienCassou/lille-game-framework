package gameframework.particles;

import java.awt.Graphics;

public class ParticleGroupMock extends ParticleGroup {

	@Override
	public void drawParticle(Particle particle, Graphics graphics) {
		// Draw should do nothing as it's not easily testable
	}

}
