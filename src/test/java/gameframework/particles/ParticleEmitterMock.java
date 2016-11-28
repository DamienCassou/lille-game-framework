package gameframework.particles;

public class ParticleEmitterMock extends ParticleEmitter {

	@Override
	protected ParticleGroup createParticleGroup() {
		return new ParticleGroupMock();
	}
	
}
