import java.io.IOException;
import java.io.OutputStream;

/**
* 
* @author James Roberts jpr242
*
*/
public class Out {

	private OutputStream oS;
	
	public Out() {
		
	}
	
	public Out(OutputStream oS) {
		this.oS = oS;
	}
	
	public void println(String data) {
		this.print(data);
		System.out.print('\n');
	}
	
	public void print(String data) {
		try {
			for(int i = 0; i < data.length(); i++) {
				oS.write(data.charAt(i));
			}
		} catch (IOException e) {
			
		}
	}
	
	public void print(char c) {
		try {
			oS.write(c);
		} catch (IOException e) {
			
		}
	}
	
	public void print(byte b) {
		try {
			oS.write(b);
		} catch (IOException e) {
			
		}
	}
	
	public void print(int i) {
		try {
			
			while(i > 0) {
				oS.write((char) i % 10);
				i /= 10;
			}
		} catch (IOException e) {
			
		}
	}
	
}
