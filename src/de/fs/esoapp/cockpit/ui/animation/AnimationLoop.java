package de.fs.esoapp.cockpit.ui.animation;

import java.util.ArrayList;
import java.util.List;

public class AnimationLoop extends Thread {

	private List<Animated<?>> animatedObjects = new ArrayList<Animated<?>>();

	public void add(Animated<?> animated) {
		animatedObjects.add(animated);
	}

	public void remove(Animated<?> animated) {
		animatedObjects.remove(animated);
	}

	public void run() {
		while (true) {
			for (Animated<?> animated : animatedObjects) {
				animated.animate();
			}
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO
				e.printStackTrace();
			}
		}
	}
}
