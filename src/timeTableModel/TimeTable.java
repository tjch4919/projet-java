/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.HashSet;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimeTable.
 * 
 * @author chu
 */
public class TimeTable {
	/**
	 * Description of the property groupId.
	 */
	public int GroupId  ;

	/**
	 * Description of the property books.
	 */
	public HashSet<book> books = new HashSet<book>();

	// Start of user code (user defined attributes for TimeTable)

	// End of user code

	/**
	 * The constructor.
	 */
	public TimeTable(int GroupId) {
		// Start of user code constructor for TimeTable)
		this.GroupId = GroupId;
		// End of user code
	}

	/**
	 * Description of the method addBooking.
	 */

	 
	public int getGroupId() {
		return this.GroupId;
	}

	public String timetIDtos(){
		return "" + this.GroupId;
	}
	/**
	 * Sets a value to attribute groupId. 
	 * @param newGroupId 
	 */
	public void setGroupId(int newGroupId) {
		this.GroupId = newGroupId;
	}

	/**
	 * Returns books.
	 * @return books 
	 */
	public HashSet<book> getBooks() {
		return this.books;
	}

}
