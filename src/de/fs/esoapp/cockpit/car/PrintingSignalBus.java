package de.fs.esoapp.cockpit.car;

import de.fs.esoapp.cockpit.car.signals.AccelerationData;
import de.fs.esoapp.cockpit.car.signals.EngineStartData;
import de.fs.esoapp.cockpit.car.signals.HifiVolumeData;
import de.fs.esoapp.cockpit.car.signals.Signal;

public class PrintingSignalBus implements SignalBus {

	@Override
	public void send(Signal<?> signal) {
		Object data = signal.getData();
		if (data instanceof AccelerationData) {
			AccelerationData accelerationData = (AccelerationData) data;
			System.out.println(Thread.currentThread().getName()
					+ " Acceleration kmh: " + accelerationData.getKmh());
		} else if (data instanceof HifiVolumeData) {
			HifiVolumeData hifiVolumeData = (HifiVolumeData) data;
			System.out.println(Thread.currentThread().getName()
					+ " Loudness Level: " + hifiVolumeData.getLoudnessLevel());
		} else if (data instanceof EngineStartData) {
			EngineStartData engineStartData = (EngineStartData) data;
			if (engineStartData.isPressed()) {
				System.out.println(Thread.currentThread().getName()
						+ " Engine Started! ");
			}
		}
	}
}
