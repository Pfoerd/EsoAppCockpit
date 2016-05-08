package de.fs.esoapp.cockpit.model;

/*
 * Thread-safe!
 */
public class GearShift {

	private final double maxGears;
	private final double maxKmh;
	private final double maxEngineSpeed;
	private volatile double currentGear;

	public GearShift(int maxGears, double maxKmh, double maxEngineSpeed) {
		this.maxGears = maxGears;
		this.maxKmh = maxKmh;
		this.maxEngineSpeed = maxEngineSpeed;
		this.currentGear = 0;
	}

	public int upshift() {
		// just one upshift/downshift action at the same time
		synchronized (this) {
			if (currentGear < maxGears)
				currentGear = currentGear + 1;
		}
		return (int) currentGear;
	}

	public int downshift() {
		// just one upshift/downshift action at the same time
		synchronized (this) {
			if (currentGear > 1)
				currentGear = currentGear - 1;
		}
		return (int) currentGear;
	}

	public double getEngineSpeed(double acceleration) {
		// Thread-safe because currentGear is volatile
		double exact = acceleration * maxGears / currentGear;
		return exact - currentGear * exact * 0.05;
	}

	public double transmit(double engineSpeed) {
		// Thread-safe because currentGear is volatile
		double slope = (maxKmh * (currentGear / maxGears)) / maxEngineSpeed;
		return slope * engineSpeed;
	}
}
