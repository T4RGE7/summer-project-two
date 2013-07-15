import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.regex.Pattern;

/**
* 
* @author James Roberts jpr242
*
*/

public class In {
	
	private InputStream iS;
	private Readable source;
	
	private In(Readable source, Pattern whiteSpace) {
		//S
	}

	public In(File fileName) {
//		try {
//			
//			FileChannel temp = new FileInputStream(fileName).getChannel();
//			temp.read(dst);
//	
//		} catch (Exception e) {
//			
//		}
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
	
//	private Readable makeReadable(ReadableByteChannel channel) {
//		channel.
//	}
}
