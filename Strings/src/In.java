import java.io.IOException;
import java.io.InputStream;

/**
* 
* @author James Roberts jpr242
*
*/

public class In {
	
	private InputStream iS;

	public In() {
		
	}
	
	public In(InputStream iS) {
		this.iS = iS;
	}
	
	public String nextLine() {
		boolean notEnter = true, first = true;
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
	
	public char nextChar() {
		try {
			return (char) System.in.read();
		} catch (IOException e) {
			System.err.println(e.getMessage());
			return '\0';
		}
	}
	
	
}
