package dataStructureLinkList;

class LinkList {
	protected Link first;
	
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
	
	boolean isEmpty(){
		return (first==null);
	}
}

class firstLastLinkList extends LinkList{
	private Link last;
	
	void insertFirst(int i,double d){
		Link newLink=new Link(i,d);
		if(isEmpty())
			last=newLink;
		newLink.next=first;
		first=newLink;
	}
	
	void insertLast(int i,double d){
		Link link=new Link(i,d);
		if(isEmpty())
			first=link;
		else
			last.next=link;
		last=last.next;
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
		linklist.find(10).display();
		
		System.out.println("First last linklist");
		//First Last Linklist
		firstLastLinkList flist=new firstLastLinkList();
		flist.insertFirst(2, 3);
		flist.insertLast(6, 9);
		flist.insertLast(8, 8);
		flist.displayList();
		flist.deleteLink(6);
		System.out.println("first last linklist after deletion");
		flist.displayList();
	}
}
