package compReference;

interface MinMax<T extends Comparable<T>>{
	T min();
	T max();
}
class GenInterface<T extends Comparable<T>> implements MinMax<T>{
	T[] Array;
	GenInterface(T[] Array){
		this.Array=Array;
	}
	public T min(){
		T min=Array[0];
		for(int i=1;i<Array.length;i++){
			if(Array[i].compareTo(min)<0)
				min=Array[i];
		}
		return min;
	}
	public T max(){
		T max=Array[0];
		for(int i=1;i<Array.length;i++){
			if(Array[i].compareTo(max)>0)
				max=Array[i];
		}
		return max;
	}
}

public class GenInterfaceApp{
	public static void main(String args[]){
		Integer[] intArray={1,2,3,4,5,6,7};
		GenInterface<Integer> intOb=new GenInterface<Integer>(intArray);
		System.out.println("Min: "+intOb.min());
		System.out.println("Max: "+intOb.max());
		
		Double[] doubleArray={1.0,2.0,4.5,6.7,9.0};
		GenInterface<Double> doubleOb=new GenInterface<Double>(doubleArray);
		System.out.println("Min: "+doubleOb.min());
		System.out.println("Max: "+doubleOb.max());
		
		Character[] charArray={'a','t','w','p','z'};
		GenInterface<Character> charOb=new GenInterface<Character>(charArray);
		System.out.println("Min: "+charOb.min());
		System.out.println("Max: "+charOb.max());
	}
}
