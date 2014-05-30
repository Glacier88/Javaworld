package netPractice;

import java.net.*;

public class InetAddressApp {
	public static void main(String args[]) throws UnknownHostException{
		InetAddress Address=InetAddress.getLocalHost() 	;
		System.out.println(Address);
		InetAddress Addresses[]=InetAddress.getAllByName("www.sohu.com");
		for(int i=0;i<Addresses.length;i++){
			System.out.println(Addresses[i]);
		}
	}
}
