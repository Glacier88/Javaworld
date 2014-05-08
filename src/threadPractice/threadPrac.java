package threadPractice;

public class threadPrac extends Thread{
	public static void main(String args[]){
		Thread t=new Thread();
		t=Thread.currentThread();
		System.out.println("current Thread"+t);
		t.setName("mainThread");
		System.out.println("Thread after changed"+t);
		
		for (int i=2;i<10;i++){
			try{
			System.out.println(i);
			Thread.sleep(1000);
			}catch (InterruptedException e){
				System.out.println("The thread is interruppted");
			}
		}	
	}
}
