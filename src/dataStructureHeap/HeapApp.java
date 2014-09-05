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
	private int size;
	private int currentSize;
	Node[] HeapArray;
	Heap(int size){
		this.size=size;
		HeapArray=new Node[size];
	}
	void insert(int key){
		Node newNode=new Node(key);
		size++;
		HeapArray[size-1]=newNode;
		trickleUp(size-1);
	}
	void delete(){
		Node top=HeapArray[0];
		currentSize--;
		HeapArray[0]=HeapArray[currentSize-1];
		trickleDown(0);
		
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
		Node leftChild=HeapArray[2*index+1];
		Node rightChild=HeapArray[2*index+2];
		
	}
	void changeKey(int oldKey,int newKey){
		
	}
}
public class HeapApp {
	public static void main(String args[]){
		
	}
}
