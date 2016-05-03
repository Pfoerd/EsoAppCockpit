package de.fs.esoapp.cockpit.car.signals;

import de.fs.esoapp.cockpit.car.SignalBus;
import lejos.nxt.TouchSensor;

abstract class EventSensor<T> extends Thread {

	private final int beat;
	private final SignalBus bus;
	private TouchSensor touchSensor;
	private boolean touchState = false;

	public EventSensor(int samplingRate, TouchSensor touchSensor, SignalBus bus) {
		this.touchSensor = touchSensor;
		this.beat = 1000 / samplingRate;
		this.bus = bus;
	}

	private boolean run = true;

	public void close() {
		run = false;
	}

	public void run() {
		while (run) {
			if (touchSensor.isPressed() != touchState) {
				bus.send(new Signal<T>(constructSignalData(
						touchSensor.isPressed(), touchState)));
				touchState = !touchState;
			}

			try {
				Thread.sleep(beat);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract T constructSignalData(boolean pressed, boolean released);
}
