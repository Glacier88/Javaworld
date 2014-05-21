package compReference;

public class GenMethDemo {
	static <T,V extends T> boolean inArray(T ob, V[] array){
		boolean result=false;
		for(int i=0;i<array.length;i++){
			if(ob==array[i]){
				result=true;
				break;
			}
		}
		return result;
	}
	public static void main(String args[]){
		Integer[] intArray={1,2,3,4,5};
		if(inArray(2,intArray)){
			System.out.println("It is in the int array");
		}
		Double[] doubleArray={1.0,2.0,3.0,4.0,5.0};
		if(inArray(3.0,doubleArray))
			System.out.println("It is in the double array");
	}
}
