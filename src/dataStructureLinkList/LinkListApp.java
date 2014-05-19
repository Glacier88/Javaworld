package dataStructureLinkList;

class LinkList {
	private Link first;
	
	void insertFirst(int i,double d){
		Link link=new Link(i,d);
		link.next=first;
		first=link;
	}
	
	Link deleteFirst(){
		Link temp;
		temp=first;
		first=first.next;
		return temp;
	}
	
	void displayList(){
		Link current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
	}
	
	Link find(int key){
		Link current=first;
		while(current.idata!=key){
			if(current.next==null){
				System.out.println("No such element");
				return null;
			}
			else{
				current=current.next;
			}
		}
		return current;
	}
	
	Link deleteLink(int key){
		Link current=first;
		Link previous=first;
		while(current.idata!=key){
			if(current.next==null){
				return null;
			}
			else{
				previous=current;
				current=current.next;
			}			
		}
		if(current==first){
			current=current.next;
		}
		else{
			previous.next=current.next;
		}
		return current;
	}
}

public class LinkListApp{
	public static void main(String args[]){
		LinkList linklist=new LinkList();
		linklist.insertFirst(1,2);
		linklist.insertFirst(10,20);
		linklist.insertFirst(15,25);
		linklist.insertFirst(12,2.2);
		linklist.insertFirst(1,8.88888);
		linklist.displayList();
		linklist.deleteFirst();
		System.out.println("After a deletion.");
		linklist.displayList();
		linklist.deleteLink(18);
		System.out.println("After a set deletion");
		linklist.displayList();
		System.out.println("After a find() function");
		linklist.find(102).display();
	}
}
