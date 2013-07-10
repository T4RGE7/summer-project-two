/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Driver {

	public static void main(java.lang.String[] args) {
		
		In stdi = new In();
		Out stdo = new Out();
		
		String temp = stdi.nextLine();
		
		stdo.println(temp);
		

		
		
	}
	
	public static java.lang.String print(Number n) {
		return print(n.getNumber());
	}
	
	public static java.lang.String print(String n) {
		java.lang.String toPrint = "";
		
		for(int i = 0; i < n.length(); i++) {
			toPrint += n.charAt(i);
		}
		return toPrint;
	}
	
	public static java.lang.String print(CharNode n) {
		java.lang.String toPrint = n.getData() + "";
		return toPrint;
	}
	
	public static void printAddresses(String s) {
		s.moveCurrent(0);
		for(; s.getCurrent() != null; System.out.println(s.getCurrent().getData() + " : " + s.getCurrent()), s.setCurrent(s.getCurrent().getPointer()));
	}
}
