package de.fs.esoapp.cockpit.car.signals;

import de.fs.esoapp.cockpit.car.SignalBus;
import lejos.nxt.SensorPort;
import lejos.nxt.TouchSensor;

public class EngineStarter extends EventSensor<EngineStartData> {

	public EngineStarter(SignalBus bus) {
		super(10, new TouchSensor(SensorPort.S1), bus);
	}

	@Override
	protected EngineStartData constructSignalData(boolean pressed,
			boolean released) {
		return new EngineStartData(pressed);
	}

}
