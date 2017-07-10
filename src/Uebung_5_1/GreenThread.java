package Uebung_5_1;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class GreenThread extends Thread {
	private boolean g, r, y, ry;
	Ampel traffic;

	GreenThread(Ampel a) {
		this.traffic = a;
	}

	@Override
	public void run() {
		synchronized (traffic) {
			if (traffic.getGreen().isVisible()) {

			} else {
				synchronized (traffic.getYellow()) {
					traffic.setYellow(true);
					System.out.println("set yellow");
				}
				synchronized (this) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				synchronized (traffic.getRed()) {
					traffic.setRed(false);
				}
				synchronized (traffic.getYellow()) {
					traffic.setYellow(false);
				}
				synchronized (traffic.getGreen()) {
					traffic.setGreen(true);
				}
			}
		}
	}

	public void waitof() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
