/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;



// Start of user code (user defined imports)

// End of user code

/**
 * Description of room.
 * 
 * @author chu
 */
public class room {
	/**
	 * Description of the property books.
	 */
	//public HashSet<book> books = new HashSet<book>();

	/**
	 * Description of the property roomId.
	 */
	private int roomId ;

	/**
	 * Description of the property capacity.
	 */
	private int capacity  ;
	
	// Start of user code (user defined attributes for room)
	
	// End of user code

	/**
	 * The constructor.
	 */
	public room(int roomId, int capacity) {
		// Start of user code constructor for room)
		this.roomId = roomId;
		this.capacity = capacity;
		// End of user code
	}



	// Start of user code (user defined methods for room)

	// End of user code
	/**
	 * Returns books.
	 * @return books 
	 */

	/**
	 * Returns roomId.
	 * @return roomId 
	 */
	public int getRoomId() {
		return this.roomId;
	}

	public String roomIDtoS() {
		return "" + roomId;
	}

	public String roomIFtos() {
		return "roomID:" + roomId + "\n" + "capacity:" + capacity;
		
	}

	/**
	 * Sets a value to attribute roomId. 
	 * @param newRoomId 
	 */
	public void setRoomId(int newRoomId) {
		this.roomId = newRoomId;
	}

	/**
	 * Returns capacity.
	 * @return capacity 
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Sets a value to attribute capacity. 
	 * @param newCapacity 
	 */
	public void setCapacity(int newCapacity) {
		this.capacity = newCapacity;
	}

}
