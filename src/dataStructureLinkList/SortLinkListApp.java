package dataStructureLinkList;

class LinkS{
	int data;
	LinkS next;
	LinkS(int data){
		this.data=data;
	}
	void display(){
		System.out.println("{"+data+"}");
	}
}

class SortLinkList{
	LinkS first;
	LinkS previous;
	LinkS current;
	//Mine is not right
	void insertElementME(int data){
		LinkS link=new LinkS(data);
		LinkS previous=null;
		LinkS current=first;
		
		while(previous!=null&&current.data<data){
			previous=current;
			current=current.next;
		}
		if(previous==null&&first==null)
			first=link;
		else if(previous==null&&first!=null&&first.data>data){
			previous=link;
			first=previous;
			previous.next=current;
		}
		else if(previous==null&&first!=null&&first.data<=data){
			previous=current;
			previous.next=link;
			current=link;
		}
		else{
			previous.next=link;
		    link.next=current;
		}
	}
	//Edge cases are actually always keeping somewhat consistency
	//THERE ARE NO THAT MANY EXCEPTIONS!
	void insertElement(int data){
		LinkS link=new LinkS(data);
	    current=first;
	    previous=null;
		
		while(current!=null&&current.data<data){
			previous=current;
			current=current.next;
		}
		if(previous==null)
			first=link;
		else
			previous.next=link;
		link.next=current;
	}
	int removeFirst(){
		int temp=first.data;
		first=first.next;
		return temp;
	}
	boolean isEmpty(){
		return(first==null);
	}
	
	void displayList(){
		LinkS current=first;
		while(current!=null){
			current.display();
			current=current.next;
		}
	}
}
public class SortLinkListApp {
	public static void main(String args[]){
		SortLinkList list=new SortLinkList();
		/*
		list.insertElement(2);
		list.insertElement(10);
		list.insertElement(5);
		list.insertElement(4);
		list.insertElement(3);
		*/
		list.insertElement(10);
		list.insertElement(2);
		list.displayList();
		System.out.println("Use SortLinkLIst to sort array");
		int array[]=new int[10];
		for(int i=0;i<10;i++){
			array[i]=(int)(java.lang.Math.random()*99);
		}
		System.out.println("Unsorted array");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		SortLinkList sortlist=new SortLinkList();
		for(int i=0;i<array.length;i++){
			sortlist.insertElement(array[i]);
		}
		System.out.println("Sorted List");
		while(!sortlist.isEmpty()){
			System.out.println(sortlist.removeFirst());
		}
	}
}
