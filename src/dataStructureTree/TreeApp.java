package dataStructureTree;

class Node{
	int idata;
	double ddata;
	Node leftChild;
	Node RightChild;
	
	void displayNode(){
		System.out.println("idata: "+idata+";ddata: "+ddata);
	}
}

class Tree{
	private Node root;
	Tree(){
		root=null;
	}
	Node findNode(int idata){
		
		return null;
	}
	void insertNode(int idata,double ddata){
		
	}
	void delteNode(int idata){
		
	}
}
public class TreeApp {
	Tree smallTree=new Tree();
	smallTree.insertNode(1,2.0);
	
}
