package dataStructureLinkList;

public class Link {
	int idata;
	double ddata;
	Link next;
	Link(int i,double d){
		idata=i;
		ddata=d;
	}
	void display(){
		System.out.println("{"+idata+","+ddata+"}");
	}
}
