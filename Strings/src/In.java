import java.io.IOException;
import java.io.InputStream;

/**
* 
* @author James Roberts jpr242
*
*/

public class In {
	
	private InputStream iS;
//	private Readable source;
	
//	private In(Readable source, Pattern whiteSpace) {
//		//S
//	}
	/**
	 * Creates a null Input Stream
	 */
	public In() {
		iS = null;
	}
	/**
	 * Creates a new In object with the given InputStream
	 * @param iS the InputStream to be used
	 */
	public In(InputStream iS) {
		this.iS = iS;
	}
	/**
	 * Reads until the return character
	 * @return A String object representing the input
	 */
	public String nextLine() {
		boolean first = true;
		CharNode head = new CharNode(), current = new CharNode();
		while(true){
			try{
				char in = (char)iS.read();
				
				if(in == '\n') {
					break;
				}
				
				if (first) {
					first = false;
					head = new CharNode(in);
					current = head;
				} else {
					CharNode temp = new CharNode(in);
					current.setPointer(temp);
					current = temp;
				}
				
			} catch (IOException e) {
				System.err.println(e.getMessage());
			}
		}
		String str = new String(head);
		return str;
	}
	/**
	 * Returns the first character typed
	 * @return the first character typed
	 */
	public char nextChar() {
		try {
			return (char) System.in.read();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return '\0';
		}
	}
	
//	private Readable makeReadable(ReadableByteChannel channel) {
//		channel.
//	}
}
