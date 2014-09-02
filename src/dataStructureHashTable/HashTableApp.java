package dataStructureHashTable;

class DataItem{
	private int data;
	
	DataItem(int data){
		this.data=data;
	}
	int getKey(){
		return data;
	}
}

class hashtable{
	private DataItem[] hashArray;
	DataItem nonItem;
	private int arraySize;
	hashtable(int arraySize){
		this.arraySize=arraySize;
		hashArray=new DataItem[arraySize];
		nonItem=new DataItem(-1);
	}
	int hashFunction(int key){
		int hashValue=key%arraySize;
		return hashValue;
	}
	DataItem find(int key){
		int hashValue=hashFunction(key);
		while(hashArray[hashValue].getKey()!=key){
			if (hashArray[hashValue]!=null){
				hashValue++;
				//Wrap around when necessary
				if(hashValue==arraySize) hashValue%=arraySize;	
			}
			else 
				return null;	
		}
		return hashArray[hashValue];
	}
	//The insertion seems to be weired
	// Data items may not be able to be clustered to the same block of hashArray.
	void insert(DataItem data){
		int hashVal=hashFunction(data.getKey());
		while(hashArray[hashVal]!=null){
			++hashVal;
		}
		hashArray[hashVal]=data;	
	}
	//This does not work because Java is pass by value
	/*
	DataItem delete(int key){
		DataItem data=find(key);
		if(data!=null){
			DataItem temp=data;
			data=nonItem;
			return temp;
		}
		else 
			return null;
	}
	*/
	DataItem delete(int key){
		int hashValue=hashFunction(key);
		while(hashArray[hashValue].getKey()!=key){
			if (hashArray[hashValue]!=null){
				hashValue++;
				//Wrap around when necessary
				if(hashValue==arraySize) hashValue%=arraySize;	
			}
			else 
				return null;	
		}
		DataItem temp=hashArray[hashValue];
		hashArray[hashValue]=nonItem;
		return temp;
	}
	void displayTable(){
		for(int i=0;i<arraySize;i++){
			if(hashArray[i]!=null)
				System.out.println(hashArray[i].getKey()+" ");
			else
				System.out.println("** ");
		}
		System.out.println();
	}
}
public class HashTableApp {
	public static void main(String args[]){
		hashtable table=new hashtable(20);
		table.insert(new DataItem(2));
		table.insert(new DataItem(5));
		table.insert(new DataItem(8));
		table.insert(new DataItem(28));
		table.insert(new DataItem(48));
		table.insert(new DataItem(15));
		table.delete(15);
		table.displayTable();
		System.out.println("Test find function");
		System.out.println(table.find(5).getKey());	
	}
}
