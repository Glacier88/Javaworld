package dataStructureRecurrsion;

public class Merge {
	public static void main(String args[]){
		int[] array1={1,3,5,7,9};
		int[] array2={2,4,6,8,10};
		int[] array=new int[(array1.length+array2.length)];
		merge(array1,array2,array);
		display(array);
	}
	
	public static void merge(int[] a,int[] b,int[] c){
		int aDex=0,bDex=0,cDex=0;
		while(aDex<a.length&&bDex<b.length){
			if (a[aDex]>b[bDex])
				c[cDex++]=b[bDex++];
			else
				c[cDex++]=a[aDex++];
		}
		while(aDex<a.length)
			c[cDex++]=a[aDex++];
		while(bDex<b.length)
			c[cDex++]=b[bDex++];
	}
	
	public static void display(int[] array){
		System.out.println("The array is:");
		for(int i=0;i<array.length;i++){
			System.out.println(array[i]);
		}
	}
}
