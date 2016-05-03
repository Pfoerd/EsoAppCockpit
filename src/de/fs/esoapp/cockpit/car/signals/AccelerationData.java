package de.fs.esoapp.cockpit.car.signals;

public class AccelerationData {

	private final int kmh;

	public AccelerationData(int kmh) {
		this.kmh = kmh;
	}

	public int getKmh() {
		return kmh;
	}

}
