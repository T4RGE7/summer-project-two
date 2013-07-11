/**
 * 
 * @author James Roberts jpr242
 *
 */
public class Number {
	private String number;
	
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
	
	public Number add(Number num2) {
		if(num2.getNumber().charAt(0) == '-') {
			if(this.number.charAt(0) == '-') {
				Number temp1 = new Number(this.number.substring(1));
				Number temp2 = new Number(num2.getNumber().substring(1));
				Number toReturn = temp1.add(temp2);
				toReturn.getNumber().insert(new String("-"), 0);
				return toReturn;
			}
			return this.subtract(num2);
		} else if (this.number.charAt(0) == '-') {
			return num2.subtract(this);
		}
		String result = new String("0");
		int mult1 = 1, mult2 = 1, mult3 = 1;
		if (this.number.charAt(0) == '-') {
			mult1 = -1;
			this.number = this.number.substring(1);
		}
		
		for(int i = 0; i < this.number.length() || i < num2.getNumber().length(); i++) {
			result.insert("0", 0);
			String temp = new String(result.charAt(result.length()-(i + 1)) + "");
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
		return new Number(result);
	}
	
	public Number subtract(Number num2) {
		
		if(num2.getNumber().charAt(0) == '-') {
			if(this.number.charAt(0) == '-') {
				return this.add(num2);
			}
			return this.add(new Number(num2.getNumber().substring(1)));
		} else if (this.number.charAt(0) == '-') {
			return num2.subtract(this);
		}
		
		String result = new String("0");
		int mult1 = 1, mult2 = 1, mult3 = 1;
		
		
	//	num2 = new Number(num2.getNumber().substring(1));
		for(int i = 0; i < this.number.length() || i < num2.getNumber().length(); i++) {
			result.insert("0", 0);
			String temp = new String(result.charAt(result.length()-(i + 1)) + "");
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
			if(one < two) {
				inner:for (int j = i + 1; j < this.number.length(); j++) {
					if((this.number.charAt(this.number.length() - (j + 1)) - 48) > 0) {
						int temp1 = this.number.charAt(this.number.length() - (j + 1)) - 48;
						this.number.set((char)(temp1 + 48 - 1), this.number.length() - (j + 1));
						for(int k = j - 1; k >= i; k--) {
							this.number.set('9', this.number.length() - (k + 1));
						}
						one += 10;
						break inner;
					}
				}
				
			}
			result.set((char)(Math.abs(((one - two - three) % 10) + 48)), result.length() - (i + 1));
			result.set((char)(Math.abs(((one - two - three) / 10) + 48)), result.length() - (i + 2));
		}
		result = (result.charAt(0) == '0' ? result.substring(1) : result);
		//System.out.println(result.charAt(0));
		return new Number(result);
	}
	
	public Number subtract2(Number num2) {
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
		return new Number(result);
	}

	
	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	
}
