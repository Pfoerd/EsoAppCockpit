package de.fs.esoapp.cockpit.model;

public class GearShift {

	private int maxGears;
	private int currentGear;
	private double maxKmh;
	private double maxEngineSpeed;
	private double maxAcceleration;

	public GearShift(int maxGears, double maxKmh, double maxEngineSpeed,
			double maxAcceleration) {
		this.maxGears = maxGears;
		this.maxKmh = maxKmh;
		this.maxAcceleration = maxAcceleration;
		this.setMaxEngineSpeed(maxEngineSpeed);
		this.currentGear = 1;
	}

	public int upshift() {
		if (currentGear < maxGears)
			currentGear++;
		System.out.println("upshift, current gear: " + currentGear);
		return currentGear;
	}

	public int downshift() {
		if (currentGear > 1)
			currentGear--;
		System.out.println("downshift, current gear: " + currentGear);
		return currentGear;
	}

	public double getMaxEngineSpeed() {
		return maxEngineSpeed;
	}

	public void setMaxEngineSpeed(double maxEngineSpeed) {
		this.maxEngineSpeed = maxEngineSpeed;
	}

	public double getEngineSpeed(double acceleration) {
		return (getMaxEngineSpeed() / maxGears / maxAcceleration) / currentGear
				* acceleration * 10;
	}

	public double transmit(double engineSpeed) {
		return maxKmh / maxGears / maxGears * currentGear * currentGear
				* engineSpeed / getMaxEngineSpeed() * 2;
	}
}
