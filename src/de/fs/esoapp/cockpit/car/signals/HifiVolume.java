package de.fs.esoapp.cockpit.car.signals;

import lejos.nxt.Motor;
import de.fs.esoapp.cockpit.car.SignalBus;

public class HifiVolume extends DiscreteSensor<HifiVolumeData> {

	private int offset = 0;

	public HifiVolume(SignalBus signalBus) {
		super(4, Motor.B, signalBus);
	}

	@Override
	protected HifiVolumeData constructSignalData(int newVolume) {
		int volume = newVolume - offset;
		if (volume < 0) {
			offset = newVolume;
		} else if (volume > 180) {
			offset = newVolume - 180;
		}

		volume = newVolume - offset;

		return new HifiVolumeData(volume / 45);
	}

}
