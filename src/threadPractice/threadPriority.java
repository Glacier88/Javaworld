package threadPractice;

class priorityThread implements Runnable{
	Thread t;
	private int priority;
	private volatile boolean running=true;
	private long click=0;
	
	priorityThread(int priority){
		this.priority=priority;
		t=new Thread(this);
		t.setPriority(this.priority);
	}
	public void run(){
		while(running){
			click++;
		}
	}
	public void start(){
		t.start();
	}
	public void stop(){
		running=false;
	}
	public long getClick(){
		return click;
	}
}
public class threadPriority {
	public static void main(String args[]){
		priorityThread loThread=new priorityThread(2);
		priorityThread hiThread=new priorityThread(4);
		loThread.start();
		hiThread.start();
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			System.out.println("The thread is interrupted");
		}
		loThread.stop();
		hiThread.stop();
		
		try{
			loThread.t.join();
			hiThread.t.join();
		}catch(InterruptedException e){
			System.out.println("The thread is interrupted");
		}
		System.out.println("High thread:"+hiThread.getClick());
		System.out.println("Low thread:"+loThread.getClick());
	}
}
