package dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class arrayObject{
	private int arrSize;
	private int[] array;
	private int nElem=0;
	
	public arrayObject(int size){
		this.arrSize=size;
		this.array=new int[arrSize];
	}
	public void insert(int element){
		array[nElem]=element;
		nElem++;
	}
	
	public int[] getArray(){
		return array;
	}
	
	public int getSize(){
		return nElem;
	}
	
	public void display(){
		for(int i=0;i<nElem;i++){
			System.out.println(array[i]);
		}
	}
}

class sortAlg{
	private arrayObject ob;
	private int[] array;
	
	public sortAlg(arrayObject ob){
		this.ob=ob;
		this.array=this.ob.getArray();
	}
	
	public int[] getSortedArray(){
		return array;
	}
	
	public void swap(int a,int b){
		int temp =array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	//Bubble Sort
	public void bubbleSort(){
		for(int i=ob.getSize();i>1;i--){
			for(int j=0;j<i-1;j++){
				if(array[j]>array[j+1]){
					swap(j,j+1);
				}
			}
		}
	}
	
	//Selection Sort
	public void selectSort(){
		for(int i=0;i<ob.getSize()-1;i++){
			int min=array[i];
			int minIndex=i;
			for(int j=i+1;j<ob.getSize();j++){
				if(array[j]<min){
					min=array[j];
					minIndex=j;
				}
			}
			swap(i,minIndex);
		}
	}
	
	//Insertion Sort
	public void insertSort(){
		for(int i=0;i<ob.getSize()-1;i++){
			int mark=array[i+1];
			int markIndex=i+1;
			boolean flag=true;
			for(int j=i;j>=0;j--){
				if(array[j]>=mark){
					array[j+1]=array[j];
				}
				else{
					markIndex=j+1;
					flag=false;
					break;
				}
			}
			//Dealing with the case that no insertion happens
			if (flag){
				array[0]=mark;
			}
			else{
				array[markIndex]=mark;
			}
		}
	}
	
	//A Tidy Insertion Sort
		public void insertSort2(){
			int j;
			for(int i=0;i<ob.getSize()-1;i++){
				int mark=array[i+1];
				int markIndex;
				for(j=i;j>=0;j--){
					if(array[j]>=mark){
						array[j+1]=array[j];
					}
					else
						break;
				}
			    markIndex=j+1;
			    array[markIndex]=mark;
			}
		}
}




public class SimpleSort {
	public static void main(String args[]){
		arrayObject arr=new arrayObject(50);
		arr.insert(50);
		arr.insert(25);
		arr.insert(2);
		arr.insert(6);
		arr.insert(5);
		arr.insert(45);
		arr.insert(20);
		arr.insert(18);
		arr.insert(9);
		arr.insert(8);
		arr.insert(40);
		arr.insert(38);
		arr.insert(33);
		
		System.out.println("Welcome to sorting algorithms:");
		System.out.println("Bubble sort: press 1; Selection sort press 2; "
				+"Insertion sort: press 3");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String Key=null;
		try {
			Key = br.readLine().toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int key=Integer.parseInt(Key);
		sortAlg sort=new sortAlg(arr);
		switch(key){
			case 1:
				sort.bubbleSort();
			case 2:
				sort.selectSort();
			case 3:
				sort.insertSort2();
		}
		arr.display();
	}
}
