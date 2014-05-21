package compReference;

class Garray<T extends Number>{
	T[] ob;
	Garray(T[] ob){
		this.ob=ob;
	}
	
	double getAverage(){
		double sum=0;
		for(int i=0;i<ob.length;i++){
			sum+=ob[i].doubleValue();
		}
		return sum/ob.length;
	}
}
public class Stats {
	public static void main(String args[]){
		Integer[] intArray={1,3,5,7,9};
		Double[] doubleArray={1.1,3.3,5.5,7.7,9.9};
		Garray<Integer> intOb=new Garray<Integer>(intArray);
		Garray<Double> doubleOb=new Garray<Double>(doubleArray);
		System.out.println("int array: "+intOb.getAverage());
		System.out.println("double array: "+doubleOb.getAverage());
		
		
	}
}
