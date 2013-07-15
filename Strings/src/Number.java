/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Number {
	private String number;
	
	/**
	 * Creates a new Number Object from a String
	 * @param number
	 */
	public Number(String number) {
		for(int i = 0; i < number.length(); i++) {
			if ((number.charAt(i) < 48 && number.charAt(i) > 57)) {
				if(number.charAt(i) != '-') {
					throw new IllegalArgumentException();
				}
			}
//			if (number.charAt(i) == '-' && number.charAt(i) <= 57 && number.charAt(i) >= 48) {
//				throw new IllegalArgumentException("Not a valid number");
//			}
		}
		this.number = number;
	}
	/**
	 * Adds a Number to this Number
	 * @param num2 the Number to be added
	 * @return the resultant Number
	 */
	public Number add(Number num2) {
		if(num2.getNumber().charAt(0) == '-') {
			if(this.number.charAt(0) == '-') {
				Number temp1 = new Number(this.number.substring(1));
				Number temp2 = new Number(num2.getNumber().substring(1));
				Number toReturn = temp1.add(temp2);
				toReturn.getNumber().insert(new String(new CharNode('-')), 0);
				return toReturn;
			}
			return this.subtract(num2);
		} else if (this.number.charAt(0) == '-') {
			return num2.subtract(this);
		}
		String result = new String(new CharNode('0'));
		int mult1 = 1, mult2 = 1, mult3 = 1;
		if (this.number.charAt(0) == '-') {
			mult1 = -1;
			this.number = this.number.substring(1);
		}
		
		for(int i = 0; i < this.number.length() || i < num2.getNumber().length(); i++) {
			result.insert(new String(new CharNode('0')), 0);
			String temp = new String(new CharNode(result.charAt(result.length()-(i + 1))));
			int one = 0, two = 0, three = 0;
			try{
				one = this.number.charAt(this.number.length() - (i + 1)) - 48;
				one *= mult1;
			} catch (IndexOutOfBoundsException e) {}
			try{
				two = num2.getNumber().charAt(num2.getNumber().length() - (i + 1)) - 48;
				two *= mult2;
			} catch (IndexOutOfBoundsException e) {}
			try{
				three = result.charAt(result.length() - (i + 1)) - 48;
			//	two *= mult3;
			} catch (IndexOutOfBoundsException e) {}
			result.set((char)(Math.abs(((one + two + three) % 10) + 48)), result.length() - (i + 1));
			result.set((char)(((one + two + three) / 10) + 48), result.length() - (i + 2));
		}
		result = (result.charAt(0) == '0' ? result.substring(1) : result);
		Number toReturn = new Number(result);
		return new Number(toReturn.trim());
	//	return new Number(result);
	}
	
//	public Number subtract(Number num2) {
//		
//		if(num2.getNumber().charAt(0) == '-') {
//			if(this.number.charAt(0) == '-') {
//				return this.add(num2);
//			}
//			return this.add(new Number(num2.getNumber().substring(1)));
//		} else if (this.number.charAt(0) == '-') {
//			return num2.subtract(this);
//		}
//		
//		String result = new String(new CharNode('0'));
//		int mult1 = 1, mult2 = 1, mult3 = 1;
//		
//		
//	//	num2 = new Number(num2.getNumber().substring(1));
//		for(int i = 0; i < this.number.length() || i < num2.getNumber().length(); i++) {
//			result.insert(new String(new CharNode('0')), 0);
//			String temp = new String(new CharNode(result.charAt(result.length()-(i + 1))));
//			int one = 0, two = 0, three = 0;
//			try{
//				one = this.number.charAt(this.number.length() - (i + 1)) - 48;
//				one *= mult1;
//			} catch (IndexOutOfBoundsException e) {}
//			try{
//				two = num2.getNumber().charAt(num2.getNumber().length() - (i + 1)) - 48;
//				two *= mult2;
//			} catch (IndexOutOfBoundsException e) {}
//			try{
//				three = result.charAt(result.length() - (i + 1)) - 48;
//			//	two *= mult3;
//			} catch (IndexOutOfBoundsException e) {}
//			if(one < two) {
//				inner:for (int j = i + 1; j < this.number.length(); j++) {
//					if((this.number.charAt(this.number.length() - (j + 1)) - 48) > 0) {
//						int temp1 = this.number.charAt(this.number.length() - (j + 1)) - 48;
//						this.number.set((char)(temp1 + 48 - 1), this.number.length() - (j + 1));
//						for(int k = j - 1; k >= i; k--) {
//							this.number.set('9', this.number.length() - (k + 1));
//						}
//						one += 10;
//						break inner;
//					}
//				}
//				
//			}
//			result.set((char)(Math.abs(((one - two - three) % 10) + 48)), result.length() - (i + 1));
//			result.set((char)(Math.abs(((one - two - three) / 10) + 48)), result.length() - (i + 2));
//		}
//		result = (result.charAt(0) == '0' ? result.substring(1) : result);
//		//System.out.println(result.charAt(0));
//		return new Number(result);
//	}
	/**
	 * Does actual subtraction
	 * @param num2 The Number to subtract
	 * @return the resultant Number
	 */
	public Number subtract(Number num2) {
		String storage = new String(this.number);
		String result = new String(new CharNode('\0'));
		for(int i = 0; i < this.number.length() || i < num2.getNumber().length(); i++) {
			int one = 0, two = 0;
			try{
				one = this.number.charAt(this.number.length() - (i + 1)) -48;
			} catch (IndexOutOfBoundsException e) {};
			try{
				two = num2.getNumber().charAt(num2.getNumber().length() - (i + 1)) -48;
			} catch (IndexOutOfBoundsException e) {};
			
			if(one < two) {
				inner:for(int j = i + 1; j < this.number.length(); j++) {
					int temp = -1;
					if((temp = this.number.charAt(this.number.length() - (j + 1)) - 48) > 0) {
//						char[] temp2 = this.number.toCharArray();
//						temp2[this.number.length() - (j + 1)] = (char) (temp + 48 - 1);
						this.number.set((char)(temp + 48 - 1), this.number.length() - (j + 1));
						
						for(int k = j - 1; k > i; k--) {
							//temp2[temp2.length - (k + 1)] = '9';
							int temp2 = this.number.length() - (k + 1);
							this.number.set('9', temp2);
						}
						
						//this.number = "";
						
//						for(int k = 0; k < temp2.length; k++) {
//							this.number += temp2[k];
//						}
						one += 10;
						break inner;
					}
				}
			}
			//result = (one - two) + result;
			result.insert(new String(new CharNode((char)(one - two + 48))), 0);
		}
		Number toReturn = new Number(result);
		this.number = storage;
		return new Number(toReturn.trim());
	}
	/**
	 * Recursivly adds to this number
	 * @param num2 the Number to be added
	 * @return The resultant number
	 */
	public Number addR(Number num2) {
		if(this.number.length() > num2.getNumber().length()) {
			while(this.number.length() > num2.getNumber().length()) {
				num2.getNumber().insert(new String(new CharNode('0')), 0);
			}
		} else if(this.number.length() < num2.getNumber().length()) {
			while(this.number.length() < num2.getNumber().length()) {
				this.number.insert(new String(new CharNode('0')), 0);
			}
		}
		Number toReturn = new Number(addHelp(this.number, num2.getNumber()));
		if(toReturn.getNumber().charAt(0) == '.') {
//			System.out.println("True");
//			new Out(System.out).println(toReturn.getNumber());
//			System.out.println("--");
			toReturn.getNumber().set('1', 0);
		}
		return new Number(toReturn.trim());
	}
	/**
	 * Helps add, the recursive call
	 * @param n1 first Number
	 * @param n2 second Number
	 * @return the result Number
	 */
	public String addHelp(String n1, String n2) {
		if(n1.length() == 0 && n2.length() == 0) {
			return new String(new CharNode('0'));
		}
		if(n1.length() == 1) {
			int one = n1.charAt(0) - 48;
			int two = n2.charAt(0) - 48;
			String toReturn = new String(new CharNode((char)((one + two)%10 + 48)));
			toReturn.insert(new String(new CharNode((char)((one + two)/10 + 48))), 0);
			return toReturn;
		}
//		Out o = new Out(System.out);
//		o.println(n1.substring(1, n1.length()));
//		o.println(n2.substring(1, n2.length()));
		
		
		
		int one = (n1.length() >= 1 ? n1.charAt(0) - 48 : 0);
		int two = (n2.length() >= 1 ? n2.charAt(0) - 48 : 0);
		String n3 = addHelp(n1.substring(1, n1.length()), n2.substring(1, n2.length()));
		//o.println(n1.substring(0, n1.length()));

		int three = (n3.charAt(0) == '.' ? 1 : n3.charAt(0) - 48);
		int result = one + two + three;
		n3.set((char)((result % 10) + 48), 0);
		CharNode toInsert = new CharNode((result/10 == 1 ? '.' : '0'));
		n3.insert(new String(toInsert), 0);
		return n3;
		
	}
	/**
	 * 
	 * Recursivly subtracts from this Number
	 * @param num2 the second Number
	 * @return the result as a Number
	 */
	public Number subtractR(Number num2) {
		if(this.number.length() > num2.getNumber().length()) {
			while(this.number.length() > num2.getNumber().length()) {
				num2.getNumber().insert(new String(new CharNode('0')), 0);
			}
		} else if(this.number.length() < num2.getNumber().length()) {
			while(this.number.length() < num2.getNumber().length()) {
				this.number.insert(new String(new CharNode('0')), 0);
			}
		}
		return new Number(subHelp(this.number, num2.getNumber()));
	}
	/**
	 * Helps subtract recursivly, the recursive call
	 * @param n1 the first Number
	 * @param n2 the second Number
	 * @return the result as a Number
	 */
	public String subHelp(String n1, String n2) {

		if(n1.length() == 0 && n2.length() == 0) {
			return new String(new CharNode('0'));
		}
		if(n1.length() == 1) {
			int one = n1.charAt(0) - 48;
			int two = n2.charAt(0) - 48;
			int three = 0;
			if(two > one) {
				one += 10;
				three = -1;
			}
			String toReturn = new String(new CharNode((char)((one - two)%10 + 48)));
			toReturn.insert(new String(new CharNode((three == -1 ? '-' : '0'))), 0);
			return toReturn;
		}

		int one = (n1.length() >= 1 ? n1.charAt(0) - 48 : 0);
		int two = (n2.length() >= 1 ? n2.charAt(0) - 48 : 0);
		int three = 0;

		String n3 = subHelp(n1.substring(1, n1.length()), n2.substring(1, n2.length()));
	
		if(n3.charAt(0) == '-') {
			if(one > 0) {
				one--;
				n3.set('0', 0);
			} else {
				one += 10;
			}
		}
		if(one < two) {
			one += 10;
			three = -1;
		}
		return null;
	}
//		three = (n3.length() >= 1 ? n3.charAt(0) - 48 : 0);
//		int result = one - two + three;
//		n3.set((char)((result % 10) + 48), 0);
//		CharNode toInsert = new CharNode((result/10 == 1 ? '.' : '0'));
//		n3.insert(new String(toInsert), 0);
//		return n3;
	
	
//	public String carry(String n1) {
//		n1.moveCurrent(n1.length() - 1);
//		int index = -1;
//		boolean found = false;
//		this.number.setCurrent(this.number.getHead());
//		for(int i = 0; i < this.number.length() && !found; i++) {
//			if(n1.getCurrent() == this.number.getCurrent()) {
//				found = true;
//				index = i;
//			} else {
//				this.number.setCurrent(this.number.getCurrent().getPointer());
//			}
//		}
//		String temp = n1.substring(0, index);
//		for(int i = temp.length() - 1; i >= 0; i--) {
//			if(temp.charAt(i) - 48 > 0) {
//				temp.set((char)(temp.charAt(i) - 1), i);
//				for(; i < temp.length() - 1; i++) {
//					temp.set('9', i);
//				}
//				break;
//			}
//		}
//		temp.insert(n1.substring(index, n1.length()));
//		return temp;
////		if(n1.length() == 0 || n1.length() == 1) {
////			new Out(System.err).println(false);
////			System.exit(0);
////		}
////		if(n1.charAt(n1.length() - 1) - 48 > 0) {
////			char temp = n1.charAt(n1.length() -1);
////			n1.set((char)(temp - 1), n1.charAt(n1.length() - 1));
////			return n1;
////		}
////		n1.set('9', n1.length() - 1);
////		return carry(n1.substring(0, n1.length() - 1));
//		
//	}
	
	/**
	 * Trims leading zeros
	 * @return a string with no leading zeros
	 */
	public String trim() {
		int i = 0;
		boolean test = true;
		for(int j = 0; j < this.number.length(); j++) {
			if(this.number.charAt(j) != '0' && this.number.charAt(j) != '\0') {
				test = false;
				break;
			}
		}
		
		if(test) {
			return new String(new CharNode('0'));
		}
		
		for(; i < this.number.length() - 1; i++) {
			if(this.number.charAt(i) != '0') {
				return this.number.substring(i);
			}
		}
		return this.number;
	}
	/**
	 * Returns the String contained by this Number
	 * @return this Number's String
	 */
	public String getNumber() {
		return number;
	}
	/**
	 * Sets the Number held by this String
	 * @param number The String to be set
	 */
	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
