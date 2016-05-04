package de.fs.esoapp.cockpit.car.signals;

public class UpshiftButtonData {

	private boolean pressed;

	public UpshiftButtonData(boolean pressed) {
		this.setPressed(pressed);
	}

	public boolean isPressed() {
		return pressed;
	}

	public void setPressed(boolean pressed) {
		this.pressed = pressed;
	}

}
