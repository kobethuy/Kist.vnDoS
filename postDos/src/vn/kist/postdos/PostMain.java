/**
 * 
 */
package vn.kist.postdos;

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
		
		PostThread th = new PostThread(149, "localhost/xampp/welcome.php");
		th.initThread();
		th.startThread();
	}

}
