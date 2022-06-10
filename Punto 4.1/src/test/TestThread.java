package test;

public class TestThread {
	
	public static void main(String[] args) {
		
		Thread thread1 = new Thread();
		Thread thread2 = new Thread();
		Thread thread3 = new Thread();
		
		
		thread1.start();
		//thread2.start();
		try {
			synchronized (thread1) {
				thread1.wait(3000);
				System.out.println("espere 3000");
			}
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
