package compReference;

enum Apple{
	Jonathan(2),Hartfield(3),Atlanta(4),Gatech(6);
	private int price;
	Apple(int price){
		this.price=price;
	}
	int getPrice(){
		return price;
	}
}
public class EnumerationPractice {
	public static void main(String args[]){
		for(Apple a:Apple.values()){
			System.out.println(a);
			System.out.println(a.getPrice());
		}
	}
}
