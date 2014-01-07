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
	
	/**
	 * Create threads and connect.
	 * 
	 * @throws Exception
	 */
	public void initThread() throws Exception {
		
		for (int count_1 = 0; count_1 < getThreadNum(); count_1++) {
			
			con = new PostConnect();
			con.setUrl(new URL(getHost()));
			con.createConnection();
			
			threadList.add(new Thread(con, String.valueOf(count_1)));
			PostGui.setConsoleLog("[+] Thread #" + count_1 + " created.\r\n");
		}
	}
	
	/**
	 * Start the threads.
	 */
	public void startThread() {
		for (int count_2 = 0; count_2 < getThreadNum(); count_2++) {
			threadList.get(count_2).start();
		}
	}

	/**
	 * Get the number of threads.
	 * 
	 * @return the number of threads.
	 */
	public int getThreadNum() {
		return threadNum;
	}

	/**
	 * Set the number of threads.
	 * 
	 * @param threadNum the number of threads to set.
	 */
	public void setThreadNum(int threadNum) {
		this.threadNum = threadNum;
	}

	/**
	 * Get the hostname.
	 * 
	 * @return the hostname.
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Set the hostname.
	 * 
	 * @param host the hostname to set.
	 */
	public void setHost(String host) {
		this.host = "http://" + host;
	}

	/**
	 * Get the PostConnect object.
	 * 
	 * @return the PostConnect object.
	 */
	public PostConnect getCon() {
		return con;
	}

	/**
	 * Get the list containing the threads.
	 * 
	 * @return the list that contains the threads.
	 */
	public ArrayList<Thread> getThreadList() {
		return threadList;
	}
	
}
