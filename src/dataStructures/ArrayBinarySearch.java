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
	
	public static String findTemplate(long[] array,long searchKey){
		int lowerBound=0;
		int upperBound=array.length-1;
		String status=new String();
		while(true){
			int mid=(lowerBound+upperBound)/2;
			if(array[mid]==searchKey){
				status="Found";
				break;
			}
			else if(lowerBound>upperBound){
				status="Not found";
				break;
			}
			else if(array[mid]>searchKey){
				upperBound-=1;
			}
			else{
				lowerBound+=1;
			}
		}
		return status;
	}
	
	public static void main(String args[]){
		long[] array={2,3,4,5,7,8,9,10,11,12,13,15};
		String status;
		String status2;
		status=find(array,888);
		status2=findTemplate(array,888);
		System.out.println(status);
		System.out.println(status2);
	}
}
