import java.io.PrintStream;

/**
* 
* @author James Roberts jpr242
*
*/
public class Out {

	private PrintStream pS;
	
	public Out() {
		
	}
	
	public Out(PrintStream pS) {
		this.pS = pS;
	}
	
	public void println(String data) {
		this.print(data);
		this.pS.print('\n');
	}
	
	public void print(String data) {
		for(int i = 0; i < data.length(); i++) {
			this.pS.print(data.charAt(i));
		}
	}
	
	public void print(char c) {
		this.pS.print(c);
	}
	
	public void print(byte b) {
		this.pS.print(b);
	}
	
	public void print(int i) {
		this.pS.print(i);
	}
	
}
