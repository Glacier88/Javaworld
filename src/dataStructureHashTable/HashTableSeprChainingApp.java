package dataStructureHashTable;

//Basic structure of linked list
class Link{
	private int data;
	public Link next;
	public Link(int data){
		this.data=data;
	}
	public int getKey(){
		return data;
	}
	void displayLink(){
		System.out.println(data);
	}
}
//Implement each linked list for each element of hashArray
class sortedList{
    Link first;
	public sortedList(){
		first=null;
	}
	void insert(Link link){
		int key=link.getKey();
		Link current=first;
		Link previous=null;
		while(current!=null&&key>current.getKey()){
			previous=current;
			current=current.next;
		}
		if(first==null){
			first=link;
			link.next=null;
		}
		else{
			previous.next=link;
			link.next=current;
		}
	}
	void delete(Link link){
		int key=link.getKey();
		Link current=first;
		Link previous=null;
		if(first.getKey()==link.getKey()){
			first=null;
		}
		else{
			while(current.getKey()!=key){
				previous=current;
				current=current.next;
			}
			previous.next=current.next;
		}
	}
	Link find(int key){
		Link current=first;
		while(current.getKey()!=key&&current.next!=null){
			current=current.next;
		}
		if(current.getKey()!=key) 
			return null;
		else
			return current;
	}
	void displayList(){
		Link link=first;
		do{
			link.displayLink();
			link=link.next;
		}while(link!=null);
	}
}
class HashChainTable{
	int size;
	sortedList[] hashArray;
	HashChainTable(int size){
		this.size=size;
		hashArray=new sortedList[size];
		for(int i=0;i<size;i++){
			//You create objects here.
			hashArray[i]=new sortedList();
		}
	}
	int hashFunc(int value){
		return value%size;
	}
	Link find(int key){
		int hashVal=hashFunc(key);
		return hashArray[hashVal].find(key);
	}
	void insert(int key){
		int hashVal=hashFunc(key);
		Link link=new Link(key);
		hashArray[hashVal].insert(link);
	}
	void delete(int key){
		int hashVal=hashFunc(key);
		Link link=new Link(key);
		hashArray[hashVal].delete(link);
	}
	void displayHashTable(){
		for(int i=0;i<size;i++){
			//When you create the object, it is no longer NULL.
			if(hashArray[i].first==null) 
				System.out.println("**");
			else
				hashArray[i].displayList();
			System.out.println("--------");
		}
	}
}

public class HashTableSeprChainingApp {
	public static void main(String args[]){
		HashChainTable hashTable=new HashChainTable(20);
		hashTable.insert(5);
		hashTable.insert(25);
		//hashTable.delete(25);
		hashTable.insert(15);
		hashTable.insert(50);
		hashTable.displayHashTable();
	}
}
