package de.fs.esoapp.cockpit.car.signals;

public class HifiVolumeData {

	private final int loudnessLevel;

	public HifiVolumeData(int loudnessLevel) {
		this.loudnessLevel = loudnessLevel;
	}

	public int getLoudnessLevel() {
		return loudnessLevel;
	}

}
