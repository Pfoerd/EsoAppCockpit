package de.fs.esoapp.cockpit.car.signals;

public final class Signal<T> {
	private final T data;

	public Signal(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}
}
