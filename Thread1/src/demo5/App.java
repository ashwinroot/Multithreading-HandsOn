package demo5;

public class App {

	/*
	 * Shows how to create thread by extending Thread class
	 * */
	
	
	private int count = 0;
	public static void main(String[] args) {
		App app = new App();
		app.doWork();
	}
	
	protected synchronized void increment() {
		count++;
	}
	
	public void doWork(){
		Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i = 0; i<10000;i++){
					increment();
				}
				
			}
			
		});
		Thread t2 = new Thread(new Runnable(){

			@Override
			public void run() {
				for(int i = 0; i<10000;i++){
					increment();
				}
				
			}
			
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count Value : " + count);
	}

}
