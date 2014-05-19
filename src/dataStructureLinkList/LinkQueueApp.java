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
			last=link;
		link.next=first;
	}
	
	int deleteFirst(){
		int temp=first.data;
		first=first.next;
		return temp;
	}
}

public class LinkQueueApp {

}
