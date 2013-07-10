/**
 * 
 * @author James Roberts jpr242
 *
 */
public class CharNode {
	
	private char data;
	private CharNode pointer;
	
	public CharNode(char data) {
		this.data = data;
		this.pointer = null;
	}
	
	public CharNode() {
		this.pointer = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public CharNode getPointer() {
		return pointer;
	}

	public void setPointer(CharNode pointer) {
		this.pointer = pointer;
	}
	
	
}
