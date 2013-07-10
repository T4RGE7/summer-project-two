	/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Driver {

	public static void main(java.lang.String[] args) {
		

		String temp = new String("abcdefghijk");
		temp.moveCurrent(0);
		System.out.println(temp.getCurrent().getData());
	//	printAddresses(temp);
		temp.insert("Test", 0);
		System.out.println(print(temp));
//		System.out.println(print(temp.substring(1, 2)));
//		System.out.println(new String("").indexOf(new String(" ")));
		
		Number one = new Number(new String("20"));
		Number two = new Number(new String("-19"));
		Number three = one.subtract(two);
		System.out.println(print(three));
		
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
