/**
 * 
 * @author James Roberts jpr242
 *
 */
public interface LLStringInterface {

	/**
	 * Returns the character at a given index
	 * @throws IndexOutOfBoundsException for an invalid index
	 * @throws NullPointerException for an empty string
	 * @param index The index who's character is to be returned
	 * @return the character at this index
	 */
	public char charAt(int index);
	/**
	 * Searches for the given String
	 * @param string The String to search for
	 * @return true if present, false if not
	 */
	public boolean search(String element);
	/**
	 * Searches for the given String from the starting index in this String
	 * @param string The String to search for
	 * @param start The index to start searching on
	 * @return true if present, false if not
	 */
	public boolean search(String element, int index);
	/**
	 * Inserts the given String at the end of the this String
	 * @param toInsert The String to insert
	 */
	public void insert(String toInsert);
	/**
	 * Inserts the given String at the index in this String
	 * @param toInsert The String to insert
	 * @param index The location to insert (0 at beginning)
	 */
	public void insert(String toInsert, int startIndex);
	/**
	 * Searches for the given String from the beginning of this String
	 * @param string The String to search for
	 * @return -1 if not present, otherwise the location
	 */
	public int indexOf(String toFind);
	/**
	 * Searches for the given String from the starting index in this String
	 * @param string The String to search for
	 * @param start The index to start searching on
	 * @return -1 if not present, otherwise the location
	 */
	public int indexOf(String toFine, int startIndex);
	/**
	 * Returns a new String from the start index to the end of the String
	 * @param start The index to start searching returning from
	 * @return String a portion of this String
	 */
	public String substring(int startIndex);
	/**
	 * Returns a new String from the start index to the end index
	 * @param start The index to start searching returning from
	 * @param end The index to end on
	 * @return String a portion of this String
	 */
	public String substring(int startIndex, int endIndex);
	/**
	 * Returns this String
	 * @return this String
	 */
	public String ToString();
//	public java.lang.String toString();	
	
}
