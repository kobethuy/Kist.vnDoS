/**
 * 
 */
package vn.kist.postdos;

import java.net.InetAddress;

import com.savarese.rocksaw.net.RawSocket;

/**
 * @author kobethuy
 *
 */
public class PostMain {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		RawSocket sock = new RawSocket();
		
		sock.bind(InetAddress.getByName("localhost"));
		
		sock.open(RawSocket.PF_INET, RawSocket.getProtocolByName("TCP"));

	}

}
