package compReference;

import java.util.*;

public class CollectionAlg {
	public static void main(String args[]){
		LinkedList<Integer> ll=new LinkedList<Integer>();
		ll.add(-8);
		ll.add(5);
		ll.add(2);
		ll.add(3);
		ll.add(-2);
		
		Comparator<Integer> comp=Collections.reverseOrder();
		Collections.sort(ll,comp);
		System.out.println("Array in reversed order");
		for(int i:ll){
			System.out.println(i);
		}
	}
}
