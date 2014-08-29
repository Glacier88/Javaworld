package dataStructureAdvancedSorting;
class MergeSort{
	static int[] merge(int[] arrayA,int[] arrayB){
		int sizeOfA=arrayA.length;
		int sizeOfB=arrayB.length;
		int[] sortedArray=new int[sizeOfA+sizeOfB];
		int i=0;//Create the enumerator of the sorted Array
		int j=0;//Create the enumerator of array A
		int k=0;//Create the enumerator of array B
		while(i<sortedArray.length&&j<sizeOfA&&k<sizeOfB){
			if(arrayA[j]<arrayB[k]){
				sortedArray[i]=arrayA[j];
				j++;
			}
			else{
				sortedArray[i]=arrayB[k];
				k++;
			}
			i++;
		}
		//If one array has all been merged before 
		//the mergeArray is merged.
		if(i!=sortedArray.length){
			//arrayA has been merged
			if(j==sizeOfA){
				while(i<sortedArray.length&&k<sizeOfB){
					sortedArray[i]=arrayB[k];
					i++;
					k++;
				}
			}
			//arrayB has been merged
			else{
				while(i<sortedArray.length&&j<sizeOfA){
					sortedArray[i]=arrayA[j];
					i++;
					j++;
				}
			}
		}
		return sortedArray;	
	}
	static int[] recurssionMerge(int[] array,int lower,int higher){
		int[] result=null;
		if(lower==higher){
			return  result;
		}
		/*
		int[] arrayF=new int[mid];
		for(int i=0;i<mid;i++){
			arrayF[i]=array[i];
		}
		int[] arrayR=new int[array.length-mid];
		for(int i=0;i<array.length-mid;i++){
			arrayR[i]=array[mid+i];
		}
		int[] array1=recurssionMerge(arrayF);
		int[] array2=recurssionMerge(arrayR);
		return merge(array1,array2);
		*/
	}
}

public class MergeSortApp {
	public static void main(String args[]){
		// Test Merge Function
		int[] arrayA={1,3,5,7};
		int arrayB[]={2,4,6,8,10,12,14};
		int[] sortedArray=MergeSort.merge(arrayA,arrayB);
		for(int i=0;i<sortedArray.length;i++){
			System.out.println(sortedArray[i]);
		}
		
		// Test MergeSort
		int[] arrayC={4,8,2,7,1,6};
		int[] sorted=MergeSort.recurssionMerge(arrayC);
		for(int i=0;i<sorted.length;i++){
			System.out.println(sorted[i]);
		
		}
		
	}
}
