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
		this.currentGear = 1;
	}

	public int upshift() {
		if (currentGear < maxGears)
			currentGear++;
		System.out.println("upshift, current gear: " + currentGear);
		return (int) currentGear;
	}

	public int downshift() {
		if (currentGear > 1)
			currentGear--;
		System.out.println("downshift, current gear: " + currentGear);
		return (int) currentGear;
	}

	public double getMaxEngineSpeed() {
		return maxEngineSpeed;
	}

	public double getEngineSpeed(double acceleration) {
		double exact = acceleration * maxGears / currentGear;
		return exact - currentGear * exact * 0.05;
	}

	public double transmit(double engineSpeed) {
		double slope = (maxKmh * (currentGear / maxGears)) / maxEngineSpeed;
		return slope * engineSpeed;
	}
}
