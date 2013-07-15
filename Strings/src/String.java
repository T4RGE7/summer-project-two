/**
 * 
 * @author James Roberts jpr242
 *
 */



public class String implements LLStringInterface{
	
	private CharNode head, current;
	
	
	/**
	 * Null constructor, requires keyboard input with return key to end
	 */
	public String() {
		this.head = new In(System.in).nextLine().getHead();
		this.current = this.head;
		
	}
	
	/**
	 * Constructor creates new String with different pointers from given String
	 * @param data String who's data is to be replicated
	 */
	public String(String data) {
		/*data.setCurrent(data.getHead());
		this.head = new String(data.getCurrent()).getHead();
		this.current = this.head;*/
		this(data.getHead());
	}
	
	/**
	 * Constructor for java.lang.String
	 * @param newString the java.lang.String to be converted into a Linked String
	 */
	public String(java.lang.String newString) throws IndexOutOfBoundsException{
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
	
	/**
	 * Constructor for nodes, creates a new String object with different pointers starting from the given node
	 * @param n Starting CharNode
	 */
	public String(CharNode n) {
		this.head = new CharNode(n.getData());
		this.current = this.head;
		CharNode temp;
		while(n.getPointer() != null) {
			n = n.getPointer();
			temp = new CharNode(n.getData());
			this.current.setPointer(temp);
			this.current = temp;
		}
		
	}
	
	/**
	 * Returns the character at a given index
	 * @throws IndexOutOfBoundsException for an invalid index
	 * @throws NullPointerException for an empty string
	 * @param index The index who's character is to be returned
	 * @return the character at this index
	 */
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
	/**
	 * Inserts the given String at the end of the this String
	 * @param toInsert The String to insert
	 */
	public void insert(String toInsert) {
		
		String data = new String(toInsert);
		
		CharNode newNode = data.getHead();
		
		CharNode lastNode;
		
		if(newNode.getPointer() != null) {
			lastNode = newNode.getPointer();
			for(;lastNode.getPointer() != null; lastNode = lastNode.getPointer());
		}
		
		if(this.head == null) {
			this.head = newNode;
		} else {
			for(; this.current.getPointer() != null; this.current = this.current.getPointer());
			this.current.setPointer(newNode);
		//	this.current = newNode;
		}
		
	}
	/**
	 * Inserts the given String at the index in this String
	 * @param toInsert The String to insert
	 * @param index The location to insert (0 at beginning)
	 */
	public void insert(String toInsert, int index) throws NullPointerException, IndexOutOfBoundsException{
		
		String data = new String(toInsert);
		
		if(index < 0) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			data.moveCurrent(data.length() - 1);
			data.getCurrent().setPointer(this.head);
			this.head = data.getHead();
			return;
		}
		this.moveCurrent(index - 1);
		if(current.getPointer() == null) {
			this.insert(data);
		} else {
			CharNode tempStart = this.current;
			CharNode tempEnd = tempStart.getPointer();
//			String1 temp = new String1(data);
			tempStart.setPointer(data.getHead());
			data.moveCurrent(data.length() - 1);
			data.getCurrent().setPointer(tempEnd);
		}
	}
	
	/**
	 * Searches for the given String from the beginning of this String
	 * @param string The String to search for
	 * @return -1 if not present, otherwise the location
	 */
	public int indexOf(String string) throws NullPointerException, IndexOutOfBoundsException{
		//boolean toReturn = true;
	//this.current = this.head;
		//string.moveCurrent(0);
		outer:for(int i = 0; i < this.length(); i++) {
	//		System.out.println(this.charAt(i) + " : " + string.charAt(0));
			if(this.charAt(i) == string.charAt(0)) {
				for(int j = 0; j < string.length(); j++) {
					if(i + j >= this.length()) {
						return -1;
					}
					if(string.charAt(j) != this.charAt(i + j)) {
						continue outer;
					}
				}
				return i;
			}
		}
		return -1;
	}
	/**
	 * Searches for the given String from the starting index in this String
	 * @param string The String to search for
	 * @param start The index to start searching on
	 * @return -1 if not present, otherwise the location
	 */
	public int indexOf(String string, int start) throws IndexOutOfBoundsException{
		outer:for(int i = start; i < this.length(); i++) {
//			System.out.println(this.charAt(i) + " : " + string.charAt(i));
			if(this.charAt(i) == string.charAt(0)) {
				for(int j = 0; j < string.length(); j++) {
					if(i + j >= this.length()) {
						return -1;
					}
					if(string.charAt(j) != this.charAt(i + j)) {
						continue outer;
					}
				}
				return i;
			}
		}
		return -1;
	}
	/**
	 * Searches for the given String
	 * @param string The String to search for
	 * @return true if present, false if not
	 */
	public boolean search(String element) {
		if(this.indexOf(element) >= 0) {
			return true;
		}
		return false;
	}
	/**
	 * Searches for the given String from the starting index in this String
	 * @param string The String to search for
	 * @param start The index to start searching on
	 * @return true if present, false if not
	 */
	public boolean search(String element, int start) {
		if(this.indexOf(element, start) >= 0) {
			return true;
		}
		return false;
	}
	/**
	 * Returns a new String from the start index to the end of the String
	 * @param start The index to start searching returning from
	 * @return String a portion of this String
	 */
	public String substring(int start) throws NullPointerException{
		this.moveCurrent(start);
		return new String(this.current);
	}
	/**
	 * Returns a new String from the start index to the end index
	 * @param start The index to start searching returning from
	 * @param end The index to end on
	 * @return String a portion of this String
	 */
	public String substring(int start, int end) throws NullPointerException{
		this.moveCurrent(start);
		String toReturn = new String(this.current);
		toReturn.moveCurrent(end - start - 1);
		toReturn.getCurrent().setPointer(null);
		return toReturn;
	}
	/**
	 * Moves the current node to specified index, not called by other classes
	 * @param i The index to move current to
	 * @throws NullPointerException
	 */
	public void moveCurrent(int i) throws NullPointerException, IndexOutOfBoundsException {
		//this.current = this.head;
		try {
			this.charAt(i);
		} catch (NullPointerException e) {
			throw new NullPointerException();
		}
		this.current = this.head;
		for(int j = 0; j < i && current.getPointer() != null; j++, this.current = this.current.getPointer());
	}
	/**
	 * The length of this String
	 * @return Length of this String
	 */
	public int length() {
		int toReturn = 0;
		
		if(this.head == null) {
			return -1;
		}
		this.current = head;
		for(; this.current != null; toReturn++, this.current = this.current.getPointer());
		
		return toReturn;
	}
	/**
	 * Returns this String
	 * @return this String
	 */
	public String ToString() {
		return this;
		/*String toReturn = "";
		CharNode temp = this.head;
		for(;temp.getPointer() != null; toReturn += temp.getData() + "", temp = temp.getPointer());
		return toReturn;*/
	}
//	/**
//	 * Returns the java.lang.String representation of this String
//	 * @return java.lang.String representation of this String
//	 */
//	public java.lang.String toString() {
//		java.lang.String toReturn = "";
//		this.current = this.head;
//		for(; this.current != null; toReturn += this.current.getData(), this.current = this.current.getPointer());
//		return toReturn;
//	}
	/**
	 * Sets an individual character in this String
	 * @param toSet The character to change
	 * @param index The index to change
	 */
	public void set(char toSet, int index) throws NullPointerException{
		this.moveCurrent(index);
		this.current.setData(toSet);
	}
	/**
	 * Gets the first node in this String
	 * @return The first Node of this String
	 */
	public CharNode getHead() {
		return head;
	}
	/**
	 * Sets the first node of this String
	 * @param head The node to be set as the first node
	 */
	public void setHead(CharNode head) {
		this.head = head;
	}
	/**
	 * Gets the "Current" node
	 * @return The "Current" CharNode
	 */
	public CharNode getCurrent() {
		return current;
	}
	/**
	 * Sets the "Current" node
	 * @param current The node to be set
	 */
	public void setCurrent(CharNode current) {
		this.current = current;
	}
	
	
}
