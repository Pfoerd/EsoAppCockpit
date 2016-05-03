package de.fs.esoapp.cockpit.car.signals;

import de.fs.esoapp.cockpit.car.SignalBus;
import lejos.nxt.Motor;

public class HifiVolume extends DiscreteSensor<HifiVolumeData> {

	public HifiVolume(SignalBus signalBus) {
		super(1, Motor.B, signalBus);
	}

	@Override
	protected HifiVolumeData constructSignalData(int tachoCount) {
		return new HifiVolumeData(tachoCount < 0 ? 0 : tachoCount / 10);
	}

}
