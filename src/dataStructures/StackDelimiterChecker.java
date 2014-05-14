package dataStructures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class DelimiterStack{
	private char[] arr;
	private int size;
	private int top;
	
	public DelimiterStack(int size){
		this.size=size;
		arr=new char[size];
		top=-1;
	}
	
	public void push(char in){
		arr[++top]=in;
	}
	
	public char pop(){
		return arr[top--];
	}
	
	public boolean isEmpty(){
		return(top==-1);
	}
	
	public boolean isFull(){
		return(top==size-1);
	}
}

class DelimiterChecker{
	private DelimiterStack stack;
	private String text;
	
	public DelimiterChecker(String text){
		this.text=text;
		stack=new DelimiterStack(text.length());
	}
	
	public void checkDelimiter(){
		char delimiter = 0;
		boolean flag=true;
		//Once the Flag is false, the error will be there
		//and the whole && judge later will be always false
		Boolean Flag=true;
		for(int i=0;i<text.length();i++){
			delimiter=text.charAt(i);
			switch(delimiter){
			case '{':
			case '[':
			case '(':
				stack.push(delimiter);
				//Once there is delimiters, 
				//there should be according delimiters
				flag=false;
				break;
			case '}':
			case ']':
			case ')':
				//Check if the stack is empty
				if(stack.isEmpty())
					Flag=false;
				//Check the matching of delimiters
				else{
					char delimiterx=stack.pop();
					if((delimiter==']'&&delimiterx!='[')||
						(delimiter=='}'&&delimiterx!='{')||
						(delimiter==')'&&delimiterx!='(')){
							Flag=false;
					}
					else
						//Delimiters do exist and 
						//delimiters are right, then return true.
						flag=true;
				}
				break;
			default:
				break;
			}
		}
		if(flag&&Flag){
			System.out.println("Right grammar!");
		}
		else{
			System.out.println("Error in delimiters!");
		}
	}	
}
public class StackDelimiterChecker {
	static String getString() throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		return br.readLine().toString();
	}
	
	public static void main(String[] args) throws IOException{
		System.out.println("Please input a string that your want to "+
				"check the usage of delimiters:");
		String text=getString();
		DelimiterChecker checker=new DelimiterChecker(text);
		checker.checkDelimiter();
	}
}
