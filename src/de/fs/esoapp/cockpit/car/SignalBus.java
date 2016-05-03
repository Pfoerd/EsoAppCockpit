package de.fs.esoapp.cockpit.car;

import de.fs.esoapp.cockpit.car.signals.Signal;

public interface SignalBus {
	public void send(Signal<?> signal);
}
