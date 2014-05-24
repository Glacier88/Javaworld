package compReference;

import java.util.*;
import java.util.Map.Entry;

public class HashMapApp {
	public static void main(String args[]){
		HashMap<String,Double> hm=new HashMap<String,Double>();
		hm.put("Alan", 80.);
		hm.put("Jack",90.);
		hm.put("Yuebin", 100.);
		Set<Entry<String, Double>> set=hm.entrySet();
		for(Entry<String, Double> s:set){
			System.out.println(s.getKey()+":"+s.getValue());
		}
	}
}
