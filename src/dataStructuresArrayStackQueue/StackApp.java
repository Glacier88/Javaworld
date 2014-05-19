package dataStructuresArrayStackQueue;

class stack{
	
	private int size;
	private int[] array;
	private int top;
	
	public stack(int size){
		this.size=size;
		array=new int[size];
		top=-1;
	}
	
	public void push(int element){
		array[++top]=element;
	}
	
	public int pop(){
		return array[top--];
	}
	
	public int peek(){
		return array[top];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return (top==size-1);
	}
}
public class StackApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack s=new stack(10);
		s.push(1);
		s.push(3);
		s.push(5);
		s.push(9);
		
		while(!s.isEmpty()){
			System.out.println(s.pop());
		}

	}

}
