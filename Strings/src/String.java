/**
 * 
 * @author James Roberts jpr242
 *
 */
import java.util.Scanner;



public class String {
	
	private CharNode head, previous, current;
	
	public String() {
		
		System.out.print("Enter your string");
		java.lang.String temp = new Scanner(System.in).nextLine();
		new String(temp);
		
	}
	
	public String(String data) {
		this.head = data.getHead();
		this.current = data.getCurrent();
		this.previous = data.getPrevious();
	}
	
	public String(java.lang.String newString) {
		try {
			CharNode newNode = new CharNode(newString.charAt(0));
			this.head = newNode;
			this.current = head;
			for(int i = 1; i < newString.length(); i++) {			
				newNode = new CharNode(newString.charAt(i));
				this.current.setPointer(newNode);
				//newNode = new CharNode(newString.charAt(i));
				this.current = newNode;
			}
		} catch (IndexOutOfBoundsException e) {
			
		}
	}
	
	public String(CharNode n) {
		this.head = new CharNode(n.getData());
		this.current = head;
		CharNode temp;
		while(n.getPointer() != null) {
			temp = new CharNode(n.getPointer().getData());
			this.current.setPointer(temp);
			this.current = temp;
			n = n.getPointer();
		}
		
	}
	
	public char charAt(int index) throws IndexOutOfBoundsException, NullPointerException {
		
		if(index < 0 || index > this.length() - 1) {
			throw new IndexOutOfBoundsException();
		}
		
		if(this.head == null) {
			throw new NullPointerException();
		}
		
		this.current = this.head;
		
		for(int i = 1; i <= index; i++) {
			if(this.current == null) {
				throw new NullPointerException();
			}
			if (this.current.getPointer() == null) {
				return current.getData();
			}
			this.current = this.current.getPointer();
		}
		
		return this.current.getData();
		
	}
	
	public void insert(String data) {
		
		CharNode newNode = data.getHead();
		
		CharNode lastNode;
		
		if(newNode.getPointer() != null) {
			lastNode = newNode.getPointer();
			for(;lastNode.getPointer() != null; lastNode = lastNode.getPointer());
		}
		
		if(head == null) {
			this.head = newNode;
		} else {
			for(; this.current.getPointer() != null; this.current = this.current.getPointer());
			this.current.setPointer(newNode);
		//	this.current = newNode;
		}
		
	}
	
	public void insert(String data, int index) {
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			data.moveCurrent(data.length() - 1);
			data.getCurrent().setPointer(this.head);
			this.head = data.getHead();
			return;
		}
		this.moveCurrent(index);
		if(current.getPointer() == null) {
			this.insert(data);
		} else {
			CharNode tempStart = this.current;
			CharNode tempEnd = tempStart.getPointer();
//			String1 temp = new String1(data);
			tempStart.setPointer(data.getHead());
			data.moveCurrent(data.length());
			data.getCurrent().setPointer(tempEnd);
		}
	}
	
	public int indexOf(String string) {
		//boolean toReturn = true;
	//this.current = this.head;
		//string.moveCurrent(0);
		outer:for(int i = 0; i < this.length(); i++) {
	//		System.out.println(this.charAt(i) + " : " + string.charAt(0));
			if(this.charAt(i) == string.charAt(0)) {
				for(int j = 0; j < string.length(); j++) {
					if(string.charAt(j) != this.charAt(i + j)) {
						continue outer;
					}
				}
				return i;
			}
		}
		return -1;
	}
	
	public int indexOf(String string, int start) {
		outer:for(int i = start; i < this.length(); i++) {
//			System.out.println(this.charAt(i) + " : " + string.charAt(i));
			if(this.charAt(i) == string.charAt(0)) {
				for(int j = 0; j < string.length(); j++) {
					if(string.charAt(j) != this.charAt(i + j)) {
						continue outer;
					}
				}
				return i;
			}
		}
		return -1;
	}

	public String substring(int start) {
		this.moveCurrent(start);
		return new String(this.current);
	}
	
	public String substring(int start, int end) {
		this.moveCurrent(start);
		String toReturn = new String(this.current);
		toReturn.moveCurrent(end - start - 1);
		toReturn.getCurrent().setPointer(null);
		return toReturn;
	}
	
	public void moveCurrent(int i) throws NullPointerException {
		this.current = this.head;
		try {
			this.charAt(i);
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		
		for(int j = 1; j < i && current.getPointer() != null; j++, this.current = this.current.getPointer());
	}
	
	public int length() {
		int toReturn = 0;
		
		if(this.head == null) {
			return -1;
		}
		this.current = head;
		for(; this.current != null; toReturn++, this.current = this.current.getPointer());
		
		return toReturn;
	}
	
	public CharNode toString1() {
		return head;
		/*String toReturn = "";
		CharNode temp = this.head;
		for(;temp.getPointer() != null; toReturn += temp.getData() + "", temp = temp.getPointer());
		return toReturn;*/
	}
	
	public void set(char toSet, int index) {
		this.moveCurrent(index);
		this.current.setData(toSet);
	}
	
	public void insert(java.lang.String data) {
		this.insert(new String(data));
	}
	
	public void insert(java.lang.String data, int index) {
		this.insert(new String(data), index);
	}

	public CharNode getHead() {
		return head;
	}

	public void setHead(CharNode head) {
		this.head = head;
	}

	public CharNode getPrevious() {
		return previous;
	}

	public void setPrevious(CharNode previous) {
		this.previous = previous;
	}

	public CharNode getCurrent() {
		return current;
	}

	public void setCurrent(CharNode current) {
		this.current = current;
	}
	
	
}
