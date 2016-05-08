package de.fs.esoapp.cockpit;

import de.fs.esoapp.cockpit.car.signals.Accelerator;
import de.fs.esoapp.cockpit.car.signals.DownshiftButton;
import de.fs.esoapp.cockpit.car.signals.HifiVolume;
import de.fs.esoapp.cockpit.car.signals.UpshiftButton;
import de.fs.esoapp.cockpit.logging.LoggingView;
import de.fs.esoapp.cockpit.model.CarModel;
import de.fs.esoapp.cockpit.ui.VirtualCockpitController;
import de.fs.esoapp.cockpit.ui.VirtualCockpitView;

public class Starter {

	public static void main(String[] args) {
		CarModel model = new CarModel();
		VirtualCockpitController controller = new VirtualCockpitController(
				model);
		VirtualCockpitView view = new VirtualCockpitView(controller, model);
		model.addCarModelListener(view);
		model.addCarModelListener(new LoggingView());

		Accelerator accelerator = new Accelerator(model);
		HifiVolume hifiVolume = new HifiVolume(model);
		DownshiftButton downshiftButton = new DownshiftButton(model);
		UpshiftButton upshiftButton = new UpshiftButton(model);

		hifiVolume.start();
		accelerator.start();
		upshiftButton.start();
		downshiftButton.start();

		// wir legen schonmal nen Gang ein :)
		model.upshift();
	}
}
