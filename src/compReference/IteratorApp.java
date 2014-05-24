package compReference;

import java.util.*;
public class IteratorApp {
	public static void main(String args[]){
		ArrayList<String> al=new ArrayList<String>();
		al.add("a");
		al.add("b");
		al.add("c");
		al.add("e");
		al.add("f");
		
		Iterator<String> itr=al.iterator();
		while(itr.hasNext()){
			String element=itr.next();
			System.out.println(element);
		}
		
		System.out.println("Original list");
		ListIterator<String> iter=al.listIterator();
		while(iter.hasNext()){
			String element=iter.next();
			iter.set(element+"+");
		}
		System.out.println("Modified list");
		itr=al.iterator();
		while(itr.hasNext()){
			String element=itr.next();
			System.out.println(element);
		}
		System.out.println("Inverse ordered list");
		while(iter.hasPrevious()){
			String element=iter.previous();
			System.out.println(element);
		}
	}
}
