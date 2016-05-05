package de.fs.esoapp.cockpit.car.signals;

import lejos.nxt.Motor;
import de.fs.esoapp.cockpit.car.SignalBus;

public class Accelerator extends DiscreteSensor<AccelerationData> {

	public Accelerator(SignalBus signalBus) {
		super(4, Motor.A, signalBus);
	}

	@Override
	protected AccelerationData constructSignalData(int tachoCount) {
		return new AccelerationData(tachoCount < 0 ? 0 : tachoCount * 20);
	}

}
