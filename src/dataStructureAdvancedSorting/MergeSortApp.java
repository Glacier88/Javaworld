package dataStructureAdvancedSorting;
class MergeSort{
	
	/*
	 * This does not quite work because
	 * In the recursion, it sometimes return array sometimes integer
	 * which I cannot solve. It also violates the policy of merge sort.
	 */
	/*
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
		//Treat this as special case
		if(lower==higher-1){
			int[] result=new int[2];
			if(array[lower]<array[higher]){
				result[0]=array[lower];
				result[1]=array[higher];
			}
			else{
				result[0]=array[higher];
				result[1]=array[lower];
			}
			return result;
		}
		else{
			int mid=(lower+higher)/2;
			//int[] temp1=recurssionMerge(array,lower,mid);
			//int[] temp2=recurssionMerge(array,mid+1,higher);
			return merge(recurssionMerge(array,lower,mid),
					recurssionMerge(array,mid+1,higher));
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
	private  int[] array=null;
	MergeSort(int[] array){
		this.array=array;
	}
	//Closed intercal helps solve many tricky problems!
    void merge(int[] workspace,int lowPtr,int highPtr,int upperBound){
		int i=0;
		int mid=highPtr-1;
		int lowerBound=lowPtr;
		while(lowPtr<=mid&&highPtr<=upperBound){
			if(array[lowPtr]<array[highPtr]){
				workspace[i]=array[lowPtr];
				lowPtr++;
			}
			else{
				workspace[i]=array[highPtr];
				highPtr++;
			}
			i++;
		}
		while(lowPtr<=mid){
			workspace[i++]=array[lowPtr++];
		}
		while(highPtr<=upperBound){
			workspace[i++]=array[highPtr++];
		}
		for(int j=0;j<upperBound-lowerBound+1;j++){
			array[lowerBound+j]=workspace[j];
		}
	}
    void mergeSort(int[] workspace,int lowerBound,int upperBound){
    	if(lowerBound==upperBound)
    		return;
    	else{
    		int mid=(lowerBound+upperBound)/2;
    		mergeSort(workspace,lowerBound,mid);
    		mergeSort(workspace,mid+1,upperBound);
    		merge(workspace,lowerBound,mid+1,upperBound);
    		
    	}
    }
}

public class MergeSortApp {
	public static void main(String args[]){
		// Test Merge Function
		int array[]={2,4,6,8,1,3,5,7,9,11,12};
		MergeSort sort=new MergeSort(array);
		int[] workspace=new int[array.length];
		sort.merge(workspace, 0, 4, array.length-1);
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
		System.out.println("Test merge sort function");
		//Test merge sort function
		int[] arraySort={2,6,4,5,8,1,3};
		int[] workSpace=new int[arraySort.length];
		MergeSort sortArray=new MergeSort(arraySort);
		sortArray.mergeSort(workSpace, 0, arraySort.length-1);
		for(int i=0;i<workSpace.length;i++){
			System.out.println(workSpace[i]);
		}
		System.out.println("");
		for(int i=0;i<arraySort.length;i++){
			System.out.println(arraySort[i]);
		}
	}
}
