package dataStructures;


public class ArrayBinarySearch {
	public static String find(long[] array,long searchKey){
		int lowerBound=0;
		int upperBound=array.length-1;
		String status=new String();
		while(true){
			status="Not found";
				while(lowerBound<=upperBound){
					int mid=(lowerBound+upperBound)/2;
					if (searchKey==array[mid]){
						status="Found";
						break;
					}
					else if(searchKey>array[mid]){
						lowerBound+=1;
					}
					else if(searchKey<array[mid]){
						upperBound-=1;
					}
				}
			return status;
		}
	}
	
	public static void main(String args[]){
		long[] array={2,3,4,5,7,8,9,10,11,12,13,15};
		String status;
		status=find(array,888);
		System.out.println(status);
	}
}
