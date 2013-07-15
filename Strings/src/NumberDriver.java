/**
 * 
 * @author James Roberts jpr242
 *
 */
public class NumberDriver {

	public static void main(java.lang.String[] args) {
		Out stdo = new Out(System.out);
		
		Number num999 = new Number(new String("999"));
		Number num1 = new Number(new String("1"));
		Number num1000 = new Number(new String("1000"));
		Number num1234 = new Number(new String("1234"));
		Number num6 = new Number(new String("6"));
		Number num100 = new Number(new String("100"));
		Number num11 = new Number(new String("11"));
		Number num111 = new Number(new String("111"));
		
		stdo.println(num999.add(num1).getNumber());
		stdo.println(num1000.subtract(num1).getNumber());
		stdo.println(num1234.add(num6).getNumber());
		stdo.println(num1234.subtract(num6).getNumber());
		stdo.println(num100.add(num11).getNumber());
		stdo.println(num111.subtract(num111).getNumber());
		stdo.println(num6.subtract(num1).getNumber());
		stdo.println(' ');
		stdo.println(num999.addR(num1).getNumber());
		stdo.println(num1234.addR(num6).getNumber());
		stdo.println(num100.addR(num11).getNumber());
		//stdo.println(num1234.getNumber());
	}
	
}
