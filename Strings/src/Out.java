
public class Out {

	public Out() {
		
	}
	
	public void println(String data) {
		for(int i = 0; i < data.length(); i++) {
			System.out.print(data.charAt(i));
		}
		System.out.print('\n');
	}
	
}
