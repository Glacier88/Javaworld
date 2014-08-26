package dataStructureTree;

class Node{
	int idata;
	double ddata;
	Node leftChild;
	Node rightChild;
	Node(int idata,double ddata){
		this.idata=idata;
		this.ddata=ddata;
	}
	void displayNode(){
		System.out.println("idata: "+idata+";ddata: "+ddata);
	}
}

class Tree{
    Node root;
	Tree(){
		root=null;
	}
	//Find the node. It is pretty simple.
	Node findNode(int idata){
		Node current=root;
		while(current.idata!=idata){
			if(current.idata<idata)
				current=current.rightChild;
			else
				current=current.leftChild;
			if(current==null)
				return null;
		}
		return current;
	}
	void insertNode(int idata,double ddata){
		Node newNode=new Node(idata,ddata);
		if(root==null) root=newNode;
		else{
			Node current=root;//Start from the root
			Node parent;
			/*
			 * Keep two working nodes:Current and parent.
			 * In the tree building phase, a node will not insert
			 * into the middle of the tree.
			 */
			while(true){
				parent=current;
				if(newNode.idata<current.idata){
					current=current.leftChild;
					if(current==null){
						parent.leftChild=newNode;
						return;
					}
				}
				else{
					current=current.rightChild;
					if(current==null){
						parent.rightChild=newNode;
						return;
					}
				}	
			}
		}
	}
	//Traversing the tree: Pre-order, In-order, Post-order
	//This part is not important
	void traverseTree(String type){
		int flag=-1;
		if(type.equals("Pre-order")) flag=0;
		if(type.equals("In-order")) flag=1;
		if(type.equals("Post-order")) flag=2;
		switch(flag){
		//Pre-order traversing
		case 0:
			traversePreorder(root);
			break;
		//In-order traversing
		case 1:
			traverseInorder(root);
			break;
		//Post-order traversing
		case 2:
			traversePostorder(root);
			break;
		}
	}
	
	//In-order traversing 1,left sub-tree 2,root 3,right sub-tree
	void traverseInorder(Node treeNode){
		if(treeNode!=null){
			traverseInorder(treeNode.leftChild);
			treeNode.displayNode();
			traverseInorder(treeNode.rightChild);
		}
	}
	//Pre-order traversing root 1,root 2,left sub-tree 3,right sub-tree
	void traversePreorder(Node treeNode){
		if(treeNode!=null){
			treeNode.displayNode();
			traversePreorder(treeNode.leftChild);
			traversePreorder(treeNode.rightChild);
		}
	}
	//Post-order traversing 1, left subtree 2,right subtree 3,left subtree
	void traversePostorder(Node treeNode){
		if(treeNode!=null){
			traversePostorder(treeNode.leftChild);
			traversePostorder(treeNode.rightChild);
			treeNode.displayNode();
		}
	}
	/*
	 * Three scenarios for the node deletion in a binary search tree: 
	 * 1 The node is a leaf
	 * 2 The node has one child 
	 * 3 The node has two children
	 */
	void deleteNode(int idata){
		//Search the node first
		Node current=root;
		Node parent=null;
		boolean isLeftChild=true;
		while(current.idata!=idata){
			parent=current;
			if(idata<current.idata){
				current=current.leftChild;
			}
			else{
				current=current.rightChild;
				isLeftChild=false;
			}
			if(current==null) return;
		}
		//IF THE NODE IS A LEAF.
		if(current.leftChild==null&&current.rightChild==null){
			if (current==root) root=null;//Consider this special case
			else if (isLeftChild) parent.leftChild=null;
			else parent.rightChild=null;
		}
		/*
		 * IF THE NODE HAS ONE CHILD
		 * Four situations:
		 * 1 Current has one left child, and current is left child of parent
		 * 2 Current has one left child, and current is right child of parent
		 * 3 Current has one right child, and current is left child of parent
		 * 4 Current has one right child, and current is right child of parent
		 */
		else if((current.leftChild==null)^(current.rightChild==null)){
			//Current is the left child of parent
			if(current.rightChild==null){
				if(current==root) root=current.leftChild;
				else if(isLeftChild) parent.leftChild=current.leftChild;
				else parent.rightChild=current.leftChild;
			}
			//Current is the right child of parent
			else{
				if(current==root) root=current.rightChild;
				else if(isLeftChild) parent.leftChild=current.rightChild;
				else parent.rightChild=current.rightChild;
			}
		}	
		//IF THE DELETED NODE HAS TWO CHILDREN
		/*
		 * Two scenarios:
		 * The successor is the right child of deleted Node
		 * The successor is not the right child of delted Node, in which case,
		 * successor`s right children need to be relocated to successor`s parent
		 * This is done in the getSuccessor method. 
		 */
		else{
			Node successor=getSuccessor(current);
			if(current==root){
				root=successor;
			}
			else if(isLeftChild){
				parent.leftChild=successor;
			}
			else{
				parent.rightChild=successor;
			}
			//This reassign of child applies to both occasions. 
			successor.leftChild=current.leftChild;
		}
	}
	//Get successor: an auxiliary function used in delete Nodes which have two children
	Node getSuccessor(Node delNode){
		Node successorParent=delNode;
		Node current=delNode.rightChild;
		Node successor=delNode;
		while(current!=null){
			successorParent=successor;
			successor=current;
			current=current.leftChild;
		}
		//If successor is not right child of delete Node, make some connections. 
		//Relocate successor`s right child to the leftchild of successor`s parent
		if(successor!=delNode.rightChild){
			successorParent.leftChild=successor.rightChild;
			successor.rightChild=delNode.rightChild;
		}
		return successor;
	}
}
public class TreeApp {
	public static void main (String args[]){
	//System.out.println("hello");
	Tree smallTree=new Tree();
	
	//The order you insert node matters, because it will determine the tree structure.
	smallTree.insertNode(2,2.0);
	smallTree.insertNode(1,6.0);
	smallTree.insertNode(4,7.0);
	smallTree.insertNode(3, 8.8);
	smallTree.insertNode(6, 6.6);
	
	System.out.println("Tree traverse in order");
	smallTree.traverseTree("In-order");
	//smallTree.traverseInorder(smallTree.root);
	System.out.println("Tree traverse pre order");
	smallTree.traverseTree("Pre-order");
	System.out.println("Tree traverse post order");
	smallTree.traverseTree("Post-order");
	
	smallTree.deleteNode(2);
	System.out.println("Delete one Node.");
	smallTree.traverseTree("In-order");

	}
}
