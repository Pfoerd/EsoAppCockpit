package de.fs.esoapp.cockpit.ui;

public class UiStarter {

	public static void main(String[] args) {
		CarModel model = new CarModel();
		VirtualCockpitController controller = new VirtualCockpitController(
				model);
		VirtualCockpitView view = new VirtualCockpitView(controller, model);
		model.addCarModelListener(view);
	}

}
