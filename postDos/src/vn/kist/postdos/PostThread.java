/**
 * 
 */
package vn.kist.postdos;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author Kobe
 *
 */
public class PostThread{
	
	private String host;
	private int threadNum;
	private ArrayList<Thread> threadList;
	private PostConnect con;
	
	public PostThread(int threadNum, String host) {
		setThreadNum(threadNum);
		
		setHost(host);
		
		threadList = new ArrayList<Thread>();
		
		if (!threadList.isEmpty()) {
			threadList.clear();
		}
		
		threadList = new ArrayList<Thread>();
	}
	
	public void initThread() throws Exception {
		
		for (int count_1 = 0; count_1 < getThreadNum(); count_1++) {
			
			con = new PostConnect();
			con.setUrl(new URL(getHost()));
			con.createConnection();
			
			threadList.add(new Thread(con, String.valueOf(count_1)));
			PostGui.setConsoleLog("[+] Thread #" + count_1 + " created.\r\n");
		}
	}
	
	public void startThread() {
		for (int count_2 = 0; count_2 < getThreadNum(); count_2++) {
			threadList.get(count_2).start();
		}
	}

	/**
	 * @return the threadNum
	 */
	public int getThreadNum() {
		return threadNum;
	}

	/**
	 * @param threadNum the threadNum to set
	 */
	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host the host to set
	 */
	public void setHost(String host) {
		this.host = "http://" + host;
	}

	/**
	 * @return the con
	 */
	public PostConnect getCon() {
		return con;
	}

	/**
	 * @param con the con to set
	 */
	public void setCon(PostConnect con) {
		this.con = con;
	}

	public ArrayList<Thread> getThreadList() {
		return threadList;
	}
	
}
