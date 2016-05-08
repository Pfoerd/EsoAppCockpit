package de.fs.esoapp.cockpit;

import de.fs.esoapp.cockpit.model.CarModelListener;

public class LoggingView implements CarModelListener {

	private double kmh;
	private int volume;

	@Override
	public void onEngineSpeedChanged(double speed) {
		// don't log this signal
	}

	@Override
	public void onCarSpeedChanged(double kmh) {
		if (kmh != this.kmh) {
			System.out.println(String.format("new car speed: %.2f units", kmh));
			this.kmh = kmh;
		}
	}

	@Override
	public void onUpshift(int currentGear) {
		System.out.println(String.format("upshift, current gear: %s",
				currentGear));
	}

	@Override
	public void onDownshift(int currentGear) {
		System.out.println(String.format("downshift, current gear: %s",
				currentGear));
	}

	@Override
	public void onHifiVolumeChanged(int volume) {
		if (volume != this.volume) {
			System.out.println(String.format("new volume: %s", volume));
			this.volume = volume;
		}
	}

}
