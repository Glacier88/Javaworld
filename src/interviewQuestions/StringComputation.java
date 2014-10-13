package interviewQuestions;

import java.util.Stack;

public class StringComputation {
	public static int computeString(String string){
		//Create two stacks to store values and operators
		Stack<Integer> valueStack=new Stack<Integer>();
		Stack<Character> operatorStack=new Stack<Character>();
		//Create a string of operators and set their precedence using hashtable
		String operators="+-*/";
		String timesDivid="*/";
		//Start to parse the string
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<string.length();i++){
			if(!operators.contains(Character.toString(string.charAt(i)))){
				sb.append(string.charAt(i));
			}
			else{
				String value=sb.toString();
				sb=new StringBuilder();
				valueStack.push(Integer.parseInt(value));
				if(operatorStack.isEmpty()){
					operatorStack.push(string.charAt(i));
				}
				else if(((timesDivid.contains(String.valueOf(string.charAt(i))))
						&&(!timesDivid.contains(String.valueOf(operatorStack.peek()))))){
					valueStack.push(performComputation(valueStack.pop(),
							Integer.valueOf(String.valueOf(string.charAt(i+1))),
							string.charAt(i)));
				}
				else{
					valueStack.push(performComputation(valueStack.pop(),
							valueStack.pop(),operatorStack.pop()));
					operatorStack.push(string.charAt(i));
				}
			}
		}
		
		return performComputation(valueStack.pop(),
				Integer.parseInt(sb.toString()),operatorStack.pop());
	}
	public static int performComputation(int a,int b,char operator){
		int result = 0;
		switch(operator){
			case '+': result=a+b;
				break;
			case '-': result=a-b;
				break;
			case '*': result=a*b;
				break;
			case '/': result=a/b;
				break;
		}
		return result;
	}
	public static void main(String args[]){
		String expression="12+3*6+3";
		System.out.println(computeString(expression));
	}
}
