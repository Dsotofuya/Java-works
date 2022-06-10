package models;

public abstract class Task implements Runnable{

	private Thread thread;
	private boolean stop;
	private boolean pause;
	protected abstract void executeTask();
		
	public Task() {
		thread = new Thread(this);
		thread.start();
	}
		
	@Override
	public void run() {
		while (!stop) {
			executeTask();
			synchronized (this){
				while (pause) {
					System.out.println("-----Pause-----");
					if (stop) {
						break;
					}
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void stop() {
		stop = true;
		notify();
	}
	
	public void pause() {
		pause = true;
	}
	
	public synchronized void resume() {
		pause = false;
		notify();
	}
}