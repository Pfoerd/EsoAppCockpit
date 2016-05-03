package de.fs.esoapp.cockpit.car.signals;

public class EngineStartData {

	private boolean pressed;

	public EngineStartData(boolean pressed) {
		this.setPressed(pressed);
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

}
