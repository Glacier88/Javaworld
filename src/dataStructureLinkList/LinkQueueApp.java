package dataStructureLinkList;

class LinkQ{
	int data;
	LinkQ next;
	
	LinkQ(int data){
		this.data=data;
	}
	
	void display(){
		System.out.println("{"+data+"}");
	}
}

class LinkListQ{
	LinkQ first;
	LinkQ last;
	
	void insertLast(int data){
		LinkQ link=new LinkQ(data);
		if(first==null)
			first=link;
		else 
			last.next=link;
		last=link;
	}
	
	int deleteFirst(){
		int temp=first.data;
		first=first.next;
		return temp;
	}
	
	void displayList(){
		LinkQ current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
	}
}

class Queue{
	LinkListQ list=new LinkListQ();
	
	void insert(int data){
		list.insertLast(data);
	}
	
	void remove(){
		list.deleteFirst();
	}
	
	void displayQueue(){
		list.displayList();
	}
}

public class LinkQueueApp {
	public static void main(String args[]){
		Queue queue=new Queue();
		queue.insert(2);
		queue.insert(5);
		queue.insert(7);
		queue.insert(9);
		queue.insert(10);
		System.out.println("Queue:from front to rear");
		queue.displayQueue();
		queue.remove();
		System.out.println("After a remove");
		queue.displayQueue();
		queue.insert(888);
		System.out.println("After an insertion");
		queue.displayQueue();
		
	}
}
