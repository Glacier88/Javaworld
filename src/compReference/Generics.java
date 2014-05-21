package compReference;

class gen<T>{
	T ob;
	gen(T ob){
		this.ob=ob;
	}
	T getOb(){
		return ob;
	}
	void showType(){
		System.out.println("The type of object is"+
	    ob.getClass().getName());
	}
}
public class Generics {
	public static void main(String args[]){
		gen<Integer> i=new gen<Integer>(10);
		i.showType();
		System.out.println(i.getOb());
		
		gen<String> s=new gen<String>("Hello, generic");
		s.showType();
		System.out.println(s.getOb());
	}
}
