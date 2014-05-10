package threadPractice;

class Callme{
	    /*synchronized*/ void call(String msg){ //synchronization must be in the same instance
		System.out.print("["+msg);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("Interrutpted");
		}
		System.out.println("]");
	}
}

class caller implements Runnable{
	Thread t;
	String message;
	Callme target;
	caller(String message,Callme target){
		this.message=message;
		this.target=target;
		t=new Thread(this);
		t.start();
	}
	public void run(){
		synchronized(target){
			target.call(message);
		}
	}
}
public class Synchronization {
	public static void main(String args[]){
		Callme target=new Callme();
		caller ob1=new caller("one",target);
		caller ob2=new caller("two",target);
		caller ob3=new caller("three",target);
	
		try{
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		}catch(InterruptedException e){
			System.out.println("Interrupted");
		}
	}
	
}
