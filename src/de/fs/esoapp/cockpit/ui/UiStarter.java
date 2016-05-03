package de.fs.esoapp.cockpit.ui;

public class UiStarter {

	public static void main(String[] args) {
		CarModel model = new CarModel();
		VirtualCockpitController controller = new VirtualCockpitController(
				model);
		VirtualCockpitView view = new VirtualCockpitView(controller, model);
		model.addCarModelListener(view);

		new Thread(new Runnable() {
			int rotation = 2;

			@Override
			public void run() {
				while (true) {
					rotation = 2 * rotation;
					System.out.println(rotation);
					view.setRotation(rotation);
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
