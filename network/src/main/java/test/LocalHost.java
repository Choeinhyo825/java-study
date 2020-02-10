package test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class LocalHost {

	public static void main(String[] args) {

		try {
			InetAddress ia = InetAddress.getLocalHost();
			
			String hostname = ia.getHostName();
			String hostAddress = ia.getHostAddress();
			
			byte[] addresses = ia.getAddress();
			
			System.out.println(hostname);
			System.out.println(hostAddress);
			System.out.println(Arrays.toString(addresses));
			for(byte address : addresses) {
				System.out.println(address & 0x000000ff);
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
