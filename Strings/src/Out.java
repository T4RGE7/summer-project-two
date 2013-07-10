/**
* 
* @author James Roberts jpr242
*
*/
public class Out {

	public Out() {
		
	}
	
	public void println(String data) {
		this.print(data);
		System.out.print('\n');
	}
	
	public void print(String data) {
		for(int i = 0; i < data.length(); i++) {
			System.out.print(data.charAt(i));
		}
	}
	
}
