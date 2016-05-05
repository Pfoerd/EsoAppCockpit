package de.fs.esoapp.cockpit.car.signals;

import lejos.nxt.Motor;
import de.fs.esoapp.cockpit.car.SignalBus;

public class Accelerator extends DiscreteSensor<AccelerationData> {

	private int offset = 0;

	public Accelerator(SignalBus signalBus) {
		super(4, Motor.A, signalBus);
	}

	@Override
	protected AccelerationData constructSignalData(int newTachoCount) {
		int tachoCount = newTachoCount - offset;
		if (tachoCount < 0) {
			offset = newTachoCount;
		}

		tachoCount = newTachoCount - offset;
		return new AccelerationData(tachoCount * 20);
	}

}
