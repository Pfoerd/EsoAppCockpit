package de.fs.esoapp.cockpit.car.signals;

import lejos.nxt.Motor;
import de.fs.esoapp.cockpit.car.SignalBus;

public class HifiVolume extends DiscreteSensor<HifiVolumeData> {

	public HifiVolume(SignalBus signalBus) {
		super(4, Motor.B, signalBus);
	}

	@Override
	protected HifiVolumeData constructSignalData(int tachoCount) {
		return new HifiVolumeData(tachoCount < 0 ? 0 : tachoCount);
	}

}
