package de.fs.esoapp.cockpit.model;

public class GearShift {

	private double maxGears;
	private double currentGear;
	private double maxKmh;
	private double maxEngineSpeed;

	public GearShift(int maxGears, double maxKmh, double maxEngineSpeed) {
		this.maxGears = maxGears;
		this.maxKmh = maxKmh;
		this.maxEngineSpeed = maxEngineSpeed;
		this.currentGear = 0;
	}

	public int upshift() {
		if (getCurrentGear() < maxGears)
			currentGear = currentGear + 1;
		return (int) getCurrentGear();
	}

	public int downshift() {
		if (getCurrentGear() > 1)
			currentGear = currentGear - 1;
		return (int) getCurrentGear();
	}

	public double getMaxEngineSpeed() {
		return maxEngineSpeed;
	}

	public double getEngineSpeed(double acceleration) {
		double exact = acceleration * maxGears / getCurrentGear();
		return exact - getCurrentGear() * exact * 0.05;
	}

	public double transmit(double engineSpeed) {
		double slope = (maxKmh * (getCurrentGear() / maxGears))
				/ maxEngineSpeed;
		return slope * engineSpeed;
	}

	public int getCurrentGear() {
		return (int) currentGear;
	}
}
