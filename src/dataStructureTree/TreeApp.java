package dataStructureTree;

class Node{
	int iData;
	double dData;
	Node leftchild;
	Node rightchild;
	void displayNode(){
		System.out.print("{");
		System.out.print(iData);
		System.out.print(", ");
		System.out.println(dData);
		System.out.println("}");
	}
}
class tree{
	Node root;
	public tree(){
		root=null;
	}
	public Node find(int key){
		Node current=root;
		while(current.iData!=key){
			if (key<current.iData)
				current=current.leftchild;
			else
				current=current.rightchild;
		}
		return current;

	}
	public void insert(int id,double dd){
		Node newNode=new Node();
		newNode.iData=id;
		newNode.dData=dd;
		if(root==null)
			root=newNode;
		else{
			Node current=root;
			Node parent;
			while(true)
			{
				parent=current;
				if(id<current.iData)
				{
					current=current.leftchild;
					if(current==null)
					{
					parent.leftchild=newNode;
					return;
					}
				}
				else
				{
					current=current.rightchild;
					if (current==null)
					{
						parent.rightchild=newNode;
						return;
					}
				}
			}
		}	
	}
}
public class TreeApp {
	
}
