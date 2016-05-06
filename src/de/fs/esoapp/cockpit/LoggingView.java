package de.fs.esoapp.cockpit;

import de.fs.esoapp.cockpit.model.CarModelListener;

public class LoggingView implements CarModelListener {

	private double kmh;
	private int volume;

	@Override
	public void onEngineSpeedChanged(double speed) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onCarSpeedChanged(double kmh) {
		if (kmh != this.kmh) {
			System.out.println("new car speed: " + kmh);
			this.kmh = kmh;
		}
	}

	@Override
	public void onUpshift(int currentGear) {
		System.out.println("upshift, current gear: " + currentGear);
	}

	@Override
	public void onDownshift(int currentGear) {
		System.out.println("downshift, current gear: " + currentGear);
	}

	@Override
	public void onHifiVolumeChanged(int volume) {
		if (volume != this.volume) {
			System.out.println("new volume: " + volume);
			this.volume = volume;
		}
	}

}
