package de.fs.esoapp.cockpit.ui;

import java.util.ArrayList;
import java.util.List;

import de.fs.esoapp.cockpit.car.SignalBus;
import de.fs.esoapp.cockpit.car.signals.AccelerationData;
import de.fs.esoapp.cockpit.car.signals.EngineStartData;
import de.fs.esoapp.cockpit.car.signals.HifiVolumeData;
import de.fs.esoapp.cockpit.car.signals.Signal;

public class CarModel implements SignalBus {

	/**
	 * All Observers are stored in a list. Note that the Observer-interface is
	 * used here so that the observable object does not need to know the
	 * observers intimately.
	 */
	public List<CarModelListener> observers = new ArrayList<CarModelListener>();

	public void addCarModelListener(CarModelListener o) {
		observers.add(o);
	}

	public void removeCarModelListener(CarModelListener o) {
		observers.remove(o);
	}

	@Override
	public void send(Signal<?> signal) {
		Object data = signal.getData();
		if (data instanceof AccelerationData) {
			AccelerationData accelerationData = (AccelerationData) data;
			double kmh = accelerationData.getKmh();
			observers.forEach(carModelListener -> carModelListener
					.onSpeedChanged(kmh));
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
