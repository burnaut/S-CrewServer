/**
 * 
 */
package screwserver;

/**
 * @author Sebastian
 *
 */
public class MainActivity {
	
	/**
	 * 
	 */
	public MainActivity() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Serverpart serveranfrage=new Serverpart();
		serveranfrage.neuerserversocket(5544);//portforwardingsm��ig mal schauen... :)
//		serveranfrage.bildereinspeichern();
	}

}
