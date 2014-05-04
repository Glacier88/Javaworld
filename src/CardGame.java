import java.io.*;

public class CardGame {
	public static void main(String args[]) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Please input a string:");

		
		do{
		str=br.readLine();
		String str2=new String(str.replaceAll("K", ""));
		
		System.out.println(str2);
		}while(!str.equals("q"));
	}

}
