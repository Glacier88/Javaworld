package threadPractice;
class Q{
	private int n;
	boolean status=true;
	synchronized void put(int n){
		while(status){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("put interrupted");
			}
		}
		status=true;
		this.n=n;
		System.out.println("put:"+n);
		notify();
	}
	synchronized void get(){
		while(!status){
			try{
				wait();
			}catch(InterruptedException e){
				System.out.println("get interrputed");
			}
		}
		status=false;
		System.out.println("get:"+n);
		notify();
	}
}
class Producer implements Runnable{
	Q q;
	Thread t;
	int i=0;
	Producer(Q q){
		this.q=q;
		t=new Thread(this);
		t.start();
	}
	public void run(){
		while(true){
			q.put(i++);
		}
	}
	
}
class Consumer implements Runnable{
	Q q;
	Thread t;
	Consumer(Q q){
		this.q=q;
		t=new Thread(this);
		t.start();
	}
	public void run(){
		while(true){
			q.get();
		}
	}

}
public class threadCommunication {
	public static void main(String args[]){
		Q q=new Q();
		new Producer(q);
		new Consumer(q);
	}
}
