package de.fs.esoapp.cockpit.model;

public interface CarModelListener {

	public void onEngineSpeedChanged(double speed);

	public void onCarSpeedChanged(double kmh);

	public void onUpshift(int currentGear);

	public void onDownshift(int currentGear);

	public void onHifiVolumeChanged(int loudnessLevel);

}
