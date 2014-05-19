package dataStructuresArrayStackQueue;

class Person{
	private String name;
	private int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	String getName(){
		return name;
	}
	int getAge(){
		return age;
	}
	void displayPersion(){
		System.out.print(name+":");
		System.out.println(age);
	}
}

class personArray{
	Person[] array;
	int arraySize=0;
	public static final int maxSize=100;	
	personArray(){
		array=new Person[maxSize];
	}
	void insert(Person person){
		array[arraySize]=person;
		arraySize++;
	}
	Person find(String searchName){
		Person target=null;
		for(int i=0;i<arraySize;i++){
			if (array[i].getName()==searchName)
				target=array[i];
				return target;
		}
		return target;
	}
	void delete(String deleteName){
		Person target=find(deleteName);
		if(target==null){
			System.out.println("Error");
		}
		else{
			for(int i=0;i<arraySize;i++){
				if(array[i].getName()==deleteName){
					array[i]=array[i+1];
					arraySize--;
				}
			}
		}
		
	}

}
public class ObjectArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		personArray array=new personArray();
		Person person1=new Person("tom",25);
		Person person2=new Person("jack",28);
		Person person3=new Person("marry",19);
		array.insert(person1);
		array.insert(person2);
		array.insert(person3);
		if(array.find("tom")==null){
			System.out.println("No such person");
		}
		else{
			System.out.println("Person found");
		}
		array.delete("tom");
		if(array.find("tom")==null){
			System.out.println("No such person");
		}
		else{
			System.out.println("Person found");
		}
	}

}
