package dataStructures;

class Queue{
	private int maxSize;
	private int[] array;
	private int qSize;
	private int front;
	private int rear;
	
	public Queue(int maxSize){
		this.maxSize=maxSize;
		array=new int[maxSize];
		front=0;
		rear=-1;
		qSize=0;
	}
	
	public void insert(int element){
		if(rear==maxSize-1){
			//The queue is full
			rear=-1;
		}
		qSize++;
		array[++rear]=element;
	}
	
	public int remove(){
		//The queue is full
		if(front==maxSize){
			front=0;
		}
		qSize--;
		return array[front++];
	}
	
	public int peekFront(){
		return array[front];
	}
	
	public boolean isEmpty(){
		return (qSize==0);
	}
	
	public boolean isFull(){
		return (qSize==maxSize);
	}
}
public class QueueApp {
	public static void main(String[] args){
		Queue queue=new Queue(10);
		queue.insert(5);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		
		System.out.println(queue.peekFront());
		for(int i=0;i<4;i++){
			System.out.println(queue.remove());
		}
	}
}
