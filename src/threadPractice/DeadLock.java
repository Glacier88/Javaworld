package threadPractice;
class A{
	synchronized void foo(B b){
		String name=Thread.currentThread().getName();
		System.out.println("Entered "+name);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("A interrupted");
		}
		b.last();
	}
	
	synchronized void last(){
		System.out.println("This is the last of A");
	}
}
class B{
	synchronized void bar(A a){
		String name=Thread.currentThread().getName();
		System.out.println("Entered "+name);
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			System.out.println("B interrupted");
		}
		a.last();
	}
	
	synchronized void last(){
		System.out.println("This is the last of B");
	}
}
public class DeadLock implements Runnable{
	A a=new A();
	B b=new B();
	
	DeadLock(){		
		Thread.currentThread().setName("Main thread");
		//'this' is very important when creating new thread!
		Thread t=new Thread(this,"Competing thread");
		t.start();	
		a.foo(b);
	}
	
	public void run(){
		b.bar(a);
	}
	
	public static void main(String args[]){
		new DeadLock();
	}
}
