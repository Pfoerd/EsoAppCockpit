package de.fs.esoapp.cockpit.car.signals;

public class HifiVolumeData {

	private final int loudnessLevel;

	public HifiVolumeData(int loudnessLevel) {
		int i = loudnessLevel / 45;
		this.loudnessLevel = i < 0 ? 0 : (i > 4 ? 4 : i);
	}

	public int getLoudnessLevel() {
		return loudnessLevel;
	}

}
