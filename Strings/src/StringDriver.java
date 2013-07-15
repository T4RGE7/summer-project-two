/**
 * 
 * @author James Roberts jpr242
 *
 */
public class StringDriver {

	public static void main(java.lang.String[] args) {
		In stdi = new In(System.in);
		Out stdo = new Out(System.out);
		
		//enter a line
		String str = stdi.nextLine();
		stdo.println(str);
		
		str = new String();
		stdo.println(str);
		
		String str1 = new String("Hello");
		String str2 = new String(" world");
		
		stdo.println(str1.indexOf(new String("bye")));
		stdo.println(str1.indexOf(new String("ello")));
		
		stdo.println(str1.indexOf(new String("el"), 2));
		stdo.println(str1.indexOf(new String("el"), 1));
		
		stdo.println(str1.search(new String("bye")));
		stdo.println(str1.search(new String("ello")));
		
		stdo.println(str1.search(new String("el"), 2));
		stdo.println(str1.search(new String("el"), 1));

		String str3 = new String("Hello");
		str3.insert(str2);
		
		stdo.println(str3);
		
		str3.insert(str2, str3.length());
		stdo.println(str3);
		
		stdo.println(str3.substring(6));
		stdo.println(str3.substring(6, 11));
		
		stdo.println(str1.charAt(1));
		
		System.out.println(str1.toString());
		stdo.println(str1.ToString());
		
		
	}
}
