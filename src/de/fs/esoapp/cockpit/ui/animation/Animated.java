package de.fs.esoapp.cockpit.ui.animation;

import javax.swing.JPanel;

public abstract class Animated<T> extends JPanel {

	private static final long serialVersionUID = 1L;

	private final T animation;

	public Animated(T animation) {
		super(null);
		this.animation = animation;
	}

	public void animate() {
		animate(animation);
		this.repaint();
	}

	protected abstract void animate(T anmation);
}
