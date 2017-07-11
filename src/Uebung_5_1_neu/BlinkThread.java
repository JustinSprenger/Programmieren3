package Uebung_5_1_neu;

public class BlinkThread extends Thread {
	private boolean g, r, y, ry;
	private volatile boolean stop = false;
	TrafficLight traffic;

	BlinkThread(TrafficLight a) {
		this.traffic = a;
	}

	@Override
	public void run() {
		while (stop == false) {

			synchronized (traffic) {
				if (traffic.getYellow().isVisible() == true) {
					synchronized (traffic.getYellow()) {
						traffic.setYellow(false);
					}
					synchronized (this) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} else {
					synchronized (traffic.getYellow()) {
						traffic.setYellow(true);
					}
					synchronized (this) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}
	public void pause() {
		this.stop = true;
	}
	public void consume() {
		this.stop = false;
	}
}
