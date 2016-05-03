package de.fs.esoapp.cockpit.car;

import de.fs.esoapp.cockpit.car.signals.Accelerator;
import de.fs.esoapp.cockpit.car.signals.EngineStarter;
import de.fs.esoapp.cockpit.car.signals.HifiVolume;

public class CarStarter {

	public static void main(String[] args) throws InterruptedException {
		SignalBus bus = new PrintingSignalBus();

		Accelerator accelerator = new Accelerator(bus);
		HifiVolume hifiVolume = new HifiVolume(bus);
		EngineStarter engineStarter = new EngineStarter(bus);

		hifiVolume.start();
		accelerator.start();
		engineStarter.start();

		Thread.sleep(10000);

		hifiVolume.close();
		accelerator.close();
		engineStarter.close();
	}

}
