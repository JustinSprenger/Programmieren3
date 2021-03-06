package Uebung_5_1;

public class RedThread extends Thread {
	private boolean g, r, y, ry;
	Ampel traffic;

	RedThread(Ampel a) {
		this.traffic = a;
	}

	@Override
	public void run() {
		synchronized (traffic) {
			if (traffic.getRed().isVisible() == true) {

			} else {
				synchronized (traffic.getYellow()) {
					traffic.setYellow(true);
					System.out.println("set yellow");
				}
				synchronized (traffic.getGreen()) {
					traffic.setGreen(false);
				}
				synchronized (this) {
					try {
						wait(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				synchronized (traffic.getYellow()) {
					traffic.setYellow(false);
				}
				synchronized (traffic.getRed()) {
					traffic.setRed(true);
				}
			}
		}

	}
}
