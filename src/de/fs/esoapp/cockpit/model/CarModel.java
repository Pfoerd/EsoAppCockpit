package de.fs.esoapp.cockpit.model;

import java.util.ArrayList;
import java.util.List;

import de.fs.esoapp.cockpit.car.SignalBus;
import de.fs.esoapp.cockpit.car.signals.AccelerationData;
import de.fs.esoapp.cockpit.car.signals.DownshiftButtonData;
import de.fs.esoapp.cockpit.car.signals.HifiVolumeData;
import de.fs.esoapp.cockpit.car.signals.Signal;
import de.fs.esoapp.cockpit.car.signals.UpshiftButtonData;

public class CarModel implements SignalBus {

	public List<CarModelListener> observers = new ArrayList<CarModelListener>();

	public void addCarModelListener(CarModelListener o) {
		observers.add(o);
	}

	public void removeCarModelListener(CarModelListener o) {
		observers.remove(o);
	}

	private GearShift gearShift;

	public CarModel() {
		gearShift = new GearShift(6, 200.0, 5000.0);
	}

	@Override
	public void send(Signal<?> signal) {
		Object data = signal.getData();
		if (data instanceof AccelerationData) {
			AccelerationData accelerationData = (AccelerationData) data;
			double acceleration = accelerationData.getAcceleration();
			double engineSpeed = gearShift.getEngineSpeed(acceleration);
			double kmh = gearShift.transmit(engineSpeed);

			// System.out.println("current acceleration: " + acceleration);
			// System.out.println("current engine speed: " + engineSpeed);
			// System.out.println("current kmh: " + kmh);

			observers.forEach(carModelListener -> carModelListener
					.onEngineSpeedChanged(engineSpeed));
			observers.forEach(carModelListener -> carModelListener
					.onCarSpeedChanged(kmh));

		} else if (data instanceof UpshiftButtonData) {
			UpshiftButtonData upshiftButtonData = (UpshiftButtonData) data;
			if (upshiftButtonData.isPressed()) {
				upshift();
			}
		} else if (data instanceof DownshiftButtonData) {
			DownshiftButtonData downshiftButtonData = (DownshiftButtonData) data;
			if (downshiftButtonData.isPressed()) {
				downshift();
			}
		} else if (data instanceof HifiVolumeData) {
			HifiVolumeData hifiVolumeData = (HifiVolumeData) data;
			observers.forEach(carModelListener -> carModelListener
					.onHifiVolumeChanged(hifiVolumeData.getVolume()));
		}
	}

	public void downshift() {
		int newGear = gearShift.downshift();
		observers.forEach(carModelListener -> carModelListener
				.onDownshift(newGear));
	}

	public void upshift() {
		int newGear = gearShift.upshift();
		observers.forEach(carModelListener -> carModelListener
				.onUpshift(newGear));
	}
}
