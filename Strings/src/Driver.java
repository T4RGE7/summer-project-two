/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Driver {

	public static void main(java.lang.String[] args) {
		
		In stdi = new In();
		Out stdo = new Out();
		
		
		String str1 = new String("hello");
		String str2 = new String(" world");
		str1.insert(str2);
		str2.set('1', 0);
		
		stdo.println(str1);
		stdo.println(str2);
		
		Number one = new Number(new String("10101"));
		Number two = new Number(new String("202"));
		
		stdo.println(one.subtract2(two).getNumber());
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
