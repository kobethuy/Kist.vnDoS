/**
 * 
 */
package vn.kist.postdos;

/**
 * @author Kobe
 *
 */
public class PostOpt {
	
	private int threads;
	private PostThread th;
	

	private String host;
	
	public PostOpt() {
		
	}
	
	public void handler(String host, boolean isSimple, boolean isRandom) throws Exception{
		
		if (host.length() < 7 && host.length() > 0) {
			PostGui.setConsoleLog("[-] Invalid hostname!\r\n");
			return;
		}
		if (host.isEmpty()) {
			PostGui.setConsoleLog("[-] Please enter a hostname!\r\n");
			return;
		}
		
		if (host.contains("http://")){
			PostGui.setConsoleLog("[-] You don't need to put \"http://\" in\r\n[-] Exitting...\r\n");
			return;
		}
		
		this.host = host;

		if (isSimple) {
			setThreads(PostGui.getSimpleSlider().getValue() * 100);
		} else {
			setThreads((Integer)PostGui.getAdvSpin().getValue());
		}

		if (isRandom) {
			PostGui.setRanParam(true);
		} else {
			PostGui.setRanParam(false);
		}

		start();
		
	}
	
	public void start() throws Exception{
		th = new PostThread(getThreads(),this.host);
		th.initThread();
		th.startThread();
	}
	
	public int getThreads() {
		return this.threads;
	}

	public void setThreads(int threads) {
		this.threads = threads;
	}
	
	public PostThread getTh() {
		return th;
	}
	
	

}
