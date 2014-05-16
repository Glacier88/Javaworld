package dataStructures;

//This is quite different from the structure of a normal queue
class PriorityQueue{
	private int maxSize;
	private int[] array;
	private int nElements=0;
	
	public PriorityQueue(int size){
		this.maxSize=size;
		array=new int[maxSize];
		
	}
	
	public void insert(int element){
		
		int i;
		if(nElements==0){
			array[nElements++]=element;
		}
		else{
			for(i=nElements-1;i>=0;i--){
				if(array[i]<element){
					array[i+1]=array[i];
				}
				else{
					break;
				}
			}
			//if i=0 in the last step, it will be -1 in this step
			array[i+1]=element;
			nElements++;
		}

	}
	
	public int remove(){
		return array[--nElements];
	}
	
	public boolean isEmpty(){
		return (nElements==0);
	}
	
	public boolean isFull(){
		return (nElements==maxSize);
	}
}
public class PriorityQueueApp { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue Pqueue=new PriorityQueue(10);
		Pqueue.insert(50);
		Pqueue.insert(10);
		Pqueue.insert(20);
		Pqueue.insert(15);
		Pqueue.insert(35);
		Pqueue.insert(30);
		while(!Pqueue.isEmpty()){
			System.out.println(Pqueue.remove());
		}
	}
}
