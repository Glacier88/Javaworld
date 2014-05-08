package threadPractice;

class newThread implements Runnable{
    Thread t;
	private String threadName;
	
	newThread(String s){
		t=new Thread(this,"Child thread");
		t.setName(s);
		threadName=s;
		System.out.println("child thread"+t);
		t.start();
	}
	public void run(){
		for(int i=1;i<6;i++){
			String temp=Integer.toString(i);
			String temp2=temp+temp;
			System.out.println(threadName+":"+temp2);
			try{
			Thread.sleep(500);
			}catch(InterruptedException e){
				System.out.println("Child thread interrupted");
			}
		}
	}
}

class ExtendNewThread extends Thread{
	private String threadName;
	Thread t;
	
	ExtendNewThread(String s){
		//super(s);
		t=new Thread(s);
		threadName=s;
		System.out.println("This thread"+this);
		start();
	}
	
	public void Runnable(){
		for(int i=115;i<121;i++){
			System.out.println(threadName+":"+i);
			try{
				Thread.sleep(500);
			}catch(InterruptedException e){
				System.out.println("Thread Interrupted");
			}
		}
	}
}

public class createNewThread{
	public static void main(String args[]) throws InterruptedException{
		newThread Athread=new newThread("one");
		ExtendNewThread extendThread=new ExtendNewThread("two");
		extendThread.Runnable();
		Athread.t.join();
		extendThread.t.join();
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


