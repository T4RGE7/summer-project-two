import java.io.PrintStream;

/**
* 
* @author James Roberts jpr242
*
*/
public class Out {

	private PrintStream pS;
	/**
	 * Creates a new text output with the console as the print stream
	 */
	public Out() {
		this.pS = System.out;
	}
	/**
	 * Creates a new text output
	 * @param pS the PrintStream to be used
	 */
	public Out(PrintStream pS) {
		this.pS = pS;
	}
	/**
	 * Prints the String with a new line
	 * @param data String to be printed
	 */
	public void println(String data) {
		this.print(data);
		this.pS.print('\n');
	}
	/**
	 * Prints the String with no new line
	 * @param data String to be printed
	 */
	public void print(String data) {
		for(int i = 0; i < data.length(); i++) {
			this.pS.print(data.charAt(i));
		}
	}
	
//	public void print(char c) {
//		this.pS.print(c);
//	}
//	
//	public void print(byte b) {
//		this.pS.print(b);
//	}
//	
//	public void print(int i) {
//		this.pS.print(i);
//	}
//	
//	public void print(boolean b) {
//		this.pS.print(b);
//	}
//	
	/**
	 * Prints the Objects toString with a new line
	 * @param o The Object to be printed
	 */
	public void println(Object o) {
		this.pS.print(o);
		this.pS.print('\n');
	}
	/**
	 * Prints the Objects toString
	 * @param o The Object to be printed
	 */
	public void print(Object o) {
		this.pS.print(o);
	}
	
}
