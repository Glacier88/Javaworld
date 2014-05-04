import java.util.HashMap;
import java.util.ArrayList;

//HashMap
public class MapListString {
	public HashMap<Integer,Student> buildMap(Student[] students){
		HashMap<Integer,Student> studentMap=new HashMap<Integer,Student>();
		for(Student s:students){
			studentMap.put(s.getID(), s);
		}
		return studentMap;	
	}
}

class Student{
	int getID(){
		return 0;
	}	
	
	//ArrayList
	void Arraylist(String[] words,String[] sentences){
		ArrayList<String> merge=new ArrayList<String>();
		for(String w:words){
			merge.add(w);
		}
		for (String s:sentences){
			merge.add(s);
		}
	}
}

//Linked List
class Node{
	Node next=null;
	int data;
	Node(int d){
		data=d;
	}
	void addToTail(int d){
		Node end=new Node(d);
		Node n=this;
		while(n.next!=null){
			n=n.next;
		}
		n.next=end;
	}
	
	//Delete nodes given a value in Linked List
	Node deleteNode(Node head,int d){
		Node afterDelete=null;
		Node n=head;
		if(n.data==d){
			afterDelete=head.next;
		}
		while(n.next!=null){
			if(n.next.data==d){
				n.next=n.next.next;
				afterDelete=head;
			}
			n=n.next;
		}
		return afterDelete;
	}
	//2014.5.4 LOC=64
}

//Stack
class stack{
	Node top=null;
	Object pop(){
		Object item;
		if (top.next!=null){
			item=top.data;
			top=top.next;
		}
		else{
		item=null;
		}
		return item;
		
	}
}

//Queue
class Queue{
	Node first,back;
	void enqueue(int item){
		if(first==null){
			first=new Node(item);
			first=back;
		}
		else{
			back.next=new Node(item);
			back=back.next;
		}
	}
	Node dequeue(){
		Node dequeueNode;
		if(first!=null){
			dequeueNode=first;
			first=first.next;
		}
		else{
			dequeueNode=first;
		}
		return dequeueNode;
	}
	//GOOD good
}

