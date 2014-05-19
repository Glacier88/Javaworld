package dataStructuresArrayStackQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class wordStack{
	private int size;
	private char[] arr;
	private int top;
	
	public wordStack(int size){
		this.size=size;
		arr=new char[this.size];
		top=-1;
	}
	
	public void push(char c){
		arr[++top]=c;
	}
	
	public char pop(){
		return arr[top--];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	
	public boolean isFull(){
		return (top==size-1);
	}
}

class ReverseWord{
	private String in;
	private String out="";
	private wordStack stack;
	
	public ReverseWord(String in){
		this.in=in;
		stack=new wordStack(in.length());
		putWord();
	}
	
	public void putWord(){
		for(int i=0;i<in.length();i++){
			stack.push(in.charAt(i));
		}
	}
	
	public String getRevWord(){
		while(!stack.isEmpty()){
			out+=stack.pop();
		}
		return out;
	}
}
public class StackWordReverse {
	static String getString(){
		String in=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			in= br.readLine().toString();
		}catch(IOException e){
			e.printStackTrace();
		}
		return in;
	}
	public static void main(String[] args){
		System.out.println("Please input a word that you want to reverse!");
		String word=getString();
		ReverseWord revword=new ReverseWord(word);
		System.out.println(revword.getRevWord());
	}
}
