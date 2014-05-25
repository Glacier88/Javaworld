package compReference;

import java.util.*;

class MyComp implements Comparator<String>{
	@Override
	public int compare(String a,String b) {
		// TODO Auto-generated method stub
		return b.compareTo(b);
	}
}

public class ComparatorApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String,Double> tm=new TreeMap<String,Double>(new MyComp());
		tm.put("Alan",80.);
		tm.put("Zil",90.);
		tm.put("Leo", 100.);
		tm.put("Yuebin",105.);
		Set<Map.Entry<String, Double>> set=tm.entrySet();
		for(Map.Entry<String,Double> s:set){
			System.out.println("Name: "+s.getKey()+" Grade: "+s.getValue());
		}
	}

}
