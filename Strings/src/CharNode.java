/**
 * 
 * @author James Roberts jpr242
 *
 */
public class CharNode {
	
	private char data;
	private CharNode pointer;
	/**
	 * Creates a new Node with the given data
	 * @param data the Character to be held
	 */
	public CharNode(char data) {
		this.data = data;
		this.pointer = null;
	}
	/**
	 * Creates a new Node no data
	 */
	public CharNode() {
		this.pointer = null;
	}
	/**
	 * Returns the data held by this node
	 * @return the data character
	 */
	public char getData() {
		return data;
	}
	/**
	 * Sets the data held by this node
	 * @param data The character to be held
	 */
	public void setData(char data) {
		this.data = data;
	}
	/**
	 * Gets the pointer to the next node
	 * @return the pointer
	 */
	public CharNode getPointer() {
		return pointer;
	}
	/**
	 * Sets the pointer to the next node
	 * @param pointer the node to be set
	 */
	public void setPointer(CharNode pointer) {
		this.pointer = pointer;
	}
	
	
}
