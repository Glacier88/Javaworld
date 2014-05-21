package dataStructures;

class LinkD{
	int data;
	LinkD next;
	LinkD previous;
	
	LinkD(int data){
		this.data=data;
	}
	void display(){
		System.out.println("{"+data+"}");
	}
}
class LinkListD{
	LinkD first;
	LinkD last;
	
	void insertFirst(int data){
		LinkD newlink=new LinkD(data);
		if(first==null)
			last=newlink;
		else
			first.previous=newlink;
		newlink.next=first;
		first=newlink;
	}
	void insertLast(int data){
		LinkD newlink=new LinkD(data);
		if(isEmpty())
			first=newlink;
		else
			last.next=newlink;
		newlink.previous=last;
		last=newlink;
	}
	
	int removeFirst(){
		int temp=first.data;
		if(first.next==null)
			last=null;
		else
			first.next.previous=null;	
		first=first.next;
		return temp;
	}
	
	int removeLast(){
		int temp=last.data;
		if(last.previous==null)
			first=null;
		else
			last.previous.next=null;
		last=last.previous;
		return temp;
	}
	
	boolean isEmpty(){
		return(first==null);
	}
	void insertForKey(int key){
		
	}
	void deleteForKey(int key){
		
	}
	
	void display(){
		LinkD current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
	}
}
public class DoublyLinkListApp {
	public static void main(String args[]){
		LinkListD linklist=new LinkListD();
		linklist.insertFirst(1);
		linklist.insertFirst(2);
		linklist.insertLast(3);
		linklist.display();
	}
}
