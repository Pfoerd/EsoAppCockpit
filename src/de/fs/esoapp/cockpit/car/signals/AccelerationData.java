package de.fs.esoapp.cockpit.car.signals;

public class AccelerationData {

	private final int acceleration;

	public AccelerationData(int engineSpeed) {
		this.acceleration = engineSpeed;
	}

	public int getAcceleration() {
		return acceleration;
	}

}
