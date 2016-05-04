package de.fs.esoapp.cockpit.car.signals;

import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;
import de.fs.esoapp.cockpit.car.SignalBus;

public class UpshiftButton extends EventSensor<UpshiftButtonData> {

	public UpshiftButton(SignalBus bus) {
		super(10, new TouchSensor(SensorPort.S1), bus);
	}

	@Override
	protected UpshiftButtonData constructSignalData(boolean pressed,
			boolean released) {
		return new UpshiftButtonData(pressed);
	}

}
