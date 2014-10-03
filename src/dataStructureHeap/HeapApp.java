package dataStructureHeap;

class Node{
	private int data;
	Node(int data){
		this.data=data;
	}
	void setKey(int data){
		this.data=data;
	}
	int getKey(){
		return data;
	}		
}
class Heap{
	private int maxSize;
	private int currentSize;
	Node[] HeapArray;
	Heap(int size){
		this.maxSize=size;
		currentSize=0;
		HeapArray=new Node[maxSize];
	}
	void insert(int key){
		Node newNode=new Node(key);
		currentSize++;
		HeapArray[currentSize-1]=newNode;
		trickleUp(currentSize-1);
	}
	void delete(){
		Node top=HeapArray[0];
		currentSize--;
		HeapArray[0]=HeapArray[currentSize-1];
		trickleDown(0);
	}
	void changeKey(int index,int newKey){
		int oldKey=HeapArray[index].getKey();
		HeapArray[index].setKey(newKey);
		if(oldKey>newKey)
			trickleDown(index);
		else
			trickleUp(index);
	}
	void trickleUp(int index){
		int parent=(index-1)/2;
		Node bottom=HeapArray[index];
		//Consider the edge case that the inserted 
		//node trickled up to the root
		while(HeapArray[parent].getKey()<bottom.getKey()
				&&index>0){
			HeapArray[index]=HeapArray[parent];
			index=parent;
			parent=(index-1)/2;
		}
		HeapArray[index]=bottom;
	}
	//Not finished
	void trickleDown(int index){
		Node top=HeapArray[index];
		int largerChild;
		while(index<currentSize/2){
			int leftChild=2*index+1;
			int rightChild=leftChild+1;
			if(rightChild<currentSize&&
					HeapArray[rightChild].getKey()
					<HeapArray[leftChild].getKey())
				largerChild=leftChild;
			else
				largerChild=rightChild;
			if(top.getKey()>HeapArray[largerChild].getKey())
				break;
			HeapArray[index]=HeapArray[largerChild];
			index=largerChild;
		}
		HeapArray[index]=top;
	}	
}
public class HeapApp {
	public static void main(String args[]){
		
	}
}
