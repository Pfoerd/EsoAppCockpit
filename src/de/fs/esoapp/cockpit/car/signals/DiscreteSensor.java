package de.fs.esoapp.cockpit.car.signals;

import de.fs.esoapp.cockpit.car.SignalBus;
import lejos.nxt.remote.RemoteMotor;

abstract class DiscreteSensor<T> extends Thread {

	private final int zeroTachoCount;
	private final RemoteMotor source;
	private final int beat;
	private final SignalBus bus;

	public DiscreteSensor(int samplingRate, RemoteMotor source, SignalBus bus) {
		this.beat = 1000 / samplingRate;
		this.source = source;
		this.bus = bus;
		zeroTachoCount = source.getTachoCount();
	}

	private boolean run = true;

	public void close() {
		run = false;
	}

	public void run() {
		while (run) {
			int tachoCount = normalizeTachoCount(source.getTachoCount());

			bus.send(new Signal<T>(constructSignalData(tachoCount)));

			try {
				Thread.sleep(beat);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract T constructSignalData(int tachoCount);

	private int normalizeTachoCount(int tachoCount) {
		return tachoCount - zeroTachoCount;
	}
}
