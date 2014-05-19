package dataStructureLinkList;

class Link_s{
	int data;
	Link_s next;
	Link_s(int data){
		this.data=data;
	}
	
	void display(){
		System.out.println("{"+data+"}");
	}
}
class LinkList_s{
	Link_s first;
	
	void insertFirst(int data){
		Link_s link=new Link_s(data);
		link.next=first;
		first=link;
	}
	
	int deleteFirst(){
		int temp=first.data;
		first=first.next;
		return temp;
	}
	
	void displayLinkList(){
		Link_s current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
	}
	
	boolean isEmpty(){
		return (first==null);
	}
}

class LinkStack{
	LinkList_s linklist=new LinkList_s();
	
	void push(int data){
		linklist.insertFirst(data);
	}
	
	int pop(){
		return linklist.deleteFirst();
	}
	
	boolean isEmpty(){
		return(linklist.isEmpty());
	}
	
	void displayStack(){
		linklist.displayLinkList();
	}
}
public class LinkStackApp {
	public static void main(String args[]){
		LinkStack linkstack=new LinkStack();
		linkstack.push(1);
		linkstack.push(2);
		linkstack.push(3);
		linkstack.push(4);
		linkstack.push(5);
		linkstack.displayStack();
		System.out.println("pop stack");
		linkstack.pop();
		linkstack.displayStack();
	}
}
