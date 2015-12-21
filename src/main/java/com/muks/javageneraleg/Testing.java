package general;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class Testing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		getIp();
//		String a = getClientIP();
//		System.out.println("+++++++++" + a);
		
		String in = "4.2.3.4";
		splitString(in);
	}

	
	public static void splitString (String str) {
		System.out.println("+++ String: " + str);
		String[] sArray = str.split("\\.");
		
		for (String s : sArray) {
			System.out.println("+++ Split " + s);
		}
	}

	public static void getIp() {
		Enumeration en = null;
		try {
			en = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(en.hasMoreElements()){
			NetworkInterface ni=(NetworkInterface) en.nextElement();
			Enumeration ee = ni.getInetAddresses();

			while(ee.hasMoreElements()) {
				InetAddress current_addr = (InetAddress) ee.nextElement();
		        if (current_addr.isLoopbackAddress() || (current_addr instanceof Inet6Address) ) {
		        	continue;
		        } else if (current_addr instanceof Inet4Address) {
		        	  System.out.println("Obtained Ip: " + current_addr.getHostAddress());
		        } 
		        
			}
		}
	}
	
	
	public static String getClientIP() {
		String hostIp = null;
		try {
			InetAddress thisIp =
					InetAddress.getLocalHost();
			hostIp = thisIp.getHostAddress();
			System.out.println("IP:"+thisIp.getHostAddress());
			System.out.println("++++++++ " + Inet4Address.getLocalHost().getHostAddress());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return hostIp;
		
	}




}


