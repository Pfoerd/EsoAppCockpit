package de.fs.esoapp.cockpit;

import de.fs.esoapp.cockpit.car.signals.Accelerator;
import de.fs.esoapp.cockpit.car.signals.EngineStarter;
import de.fs.esoapp.cockpit.car.signals.HifiVolume;
import de.fs.esoapp.cockpit.ui.CarModel;
import de.fs.esoapp.cockpit.ui.VirtualCockpitController;
import de.fs.esoapp.cockpit.ui.VirtualCockpitView;

public class Starter {

	public static void main(String[] args) {
		CarModel model = new CarModel();
		VirtualCockpitController controller = new VirtualCockpitController(
				model);
		VirtualCockpitView view = new VirtualCockpitView(controller, model);
		model.addCarModelListener(view);

		Accelerator accelerator = new Accelerator(model);
		HifiVolume hifiVolume = new HifiVolume(model);
		EngineStarter engineStarter = new EngineStarter(model);

		hifiVolume.start();
		accelerator.start();
		engineStarter.start();

	}
}
