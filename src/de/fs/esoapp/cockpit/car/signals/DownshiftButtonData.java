package de.fs.esoapp.cockpit.car.signals;

public class DownshiftButtonData {

	private boolean pressed;

	public DownshiftButtonData(boolean pressed) {
		this.setPressed(pressed);
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

}
