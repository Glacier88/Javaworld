package threadPractice;

class newThread implements Runnable{
	private Thread t;
	newThread(){
		t=new Thread(this,"Child thread");
		System.out.println("child thread"+t);
		t.start();
	}
	public void run(){
		for(int i=1;i<6;i++){
			String temp=Integer.toString(i);
			String temp2=temp+temp;
			System.out.println(temp2);
			try{
			Thread.sleep(500);
			}catch(InterruptedException e){
				System.out.println("Child thread interrupted");
			}
		}
	}
}
public class createNewThread {
	public static void main(String args[]){
		new newThread();
		System.out.println(Thread.currentThread());
		
		for(int i=1;i<6;i++){
			System.out.println(i);
			try{
			Thread.sleep(1000);
			}catch(InterruptedException e){
				System.out.println("main thread interrupted");
			}
		}
	}
		
}


