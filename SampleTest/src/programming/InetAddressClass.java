package programming;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressClass {
	
	
	@SuppressWarnings("static-access")
	public static void main(String args[]) {
		try {
			InetAddress address = InetAddress.getByName("www.mediaagility.com");
			System.out.println("Host Name.."+address.getHostName());
			System.out.println("Host Address.."+address.getHostAddress());
			System.out.println("Host Local.."+address.getLocalHost());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
	}

}
