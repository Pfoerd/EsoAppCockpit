package de.fs.esoapp.cockpit.ui;

import de.fs.esoapp.cockpit.model.CarModel;

public class UiStarter {

	public static void main(String[] args) {
		CarModel model = new CarModel();
		VirtualCockpitController controller = new VirtualCockpitController(
				model);
		VirtualCockpitView view = new VirtualCockpitView(controller, model);
		model.addCarModelListener(view);

		new Thread(new Runnable() {
			double rotation = 2;

			// double rotation = 0;

			@Override
			public void run() {
				while (true) {
					rotation = 1.5 * rotation;
					// rotation = rotation + 10;
					System.out.println(rotation);
					view.onEngineSpeedChanged(rotation);
					try {
						Thread.sleep(400);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
}
