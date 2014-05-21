package dataStructureRecurrsion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {
 static int triangle(int n){
	 if(n==1)
		 return 1;
	 else
		 return triangle(n-1)+n;
 }
 static String getString() {
	 String read=null;
	 BufferedReader br=new BufferedReader(
			 new InputStreamReader(System.in));
	 try{
		 read=br.readLine().toString();
	 }catch(IOException e){
		 System.out.println("IO problems");
	 }
	 return read;
 }
 
 static int getInteger(String s){
	 return Integer.parseInt(s);
 }
 
 public static void main(String args[]){
	 System.out.println("Please input a number");
	 int number=getInteger(getString());
	 int result=triangle(number);
	 System.out.println(result);
}
}
