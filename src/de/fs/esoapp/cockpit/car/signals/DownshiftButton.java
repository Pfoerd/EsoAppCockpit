package de.fs.esoapp.cockpit.car.signals;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import de.fs.esoapp.cockpit.car.SignalBus;

public class DownshiftButton extends EventSensor<DownshiftButtonData> {

	public DownshiftButton(SignalBus bus) {
		super(10, new TouchSensor(SensorPort.S2), bus);
	}

	@Override
	protected DownshiftButtonData constructSignalData(boolean pressed,
			boolean released) {
		return new DownshiftButtonData(pressed);
	}

}
