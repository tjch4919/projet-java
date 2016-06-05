/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.util.Date;


// Start of user code (user defined imports)

// End of user code

/**
 * Description of book.
 * 
 * @author chu
 */
public class book {
	/**
	 * Description of the property rooms.
	 */
	//public HashSet<room> rooms = new HashSet<room>();

	/**
	 * Description of the property Login.
	 */
	public String Login  ;

	/**
	 * Description of the property DateBegin.
	 */
	public Date DateBegin  ;

	/**
	 * Description of the property RoomId.
	 */
	public int RoomId  ;

	/**
	 * Description of the property BookingId.
	 */
	public int BookingId ;

	/**
	 * Description of the property DateEnd.
	 */
	public Date DateEnd ; 
	
	// Start of user code (user defined attributes for book)
	
	// End of user code

	/**
	 * The constructor.
	 */
	public book(String Login, int RoomId, int BookingId,Date DateBegin,Date DateEnd) {
		// Start of user code constructor for book)
		this.Login = Login;
		this.RoomId = RoomId;
		this.BookingId = BookingId;
		this.DateBegin = DateBegin;
		this.DateEnd = DateEnd ;
		// End of user code
	}

	/**
	 * Description of the method getTeacherLogin.
	 */

	
	public String bookIDtoS(){
		return "" + BookingId ;
	}
	/**
	 * Returns Login.
	 * @return Login 
	 */
	public String getLogin() {
		return this.Login;
	}

	/**
	 * Sets a value to attribute Login. 
	 * @param newLogin 
	 */
	public void setLogin(String newLogin) {
		this.Login = newLogin;
	}

	/**
	 * Returns DateBegin.
	 * @return DateBegin 
	 */
	public Object getDateBegin() {
		return this.DateBegin;
	}

	/**
	 * Sets a value to attribute DateBegin. 
	 * @param newDateBegin 
	 */
	public void setDateBegin(Date newDateBegin) {
		this.DateBegin = newDateBegin;
	}

	/**
	 * Returns RoomId.
	 * @return RoomId 
	 */
	public Object getRoomId() {
		return this.RoomId;
	}

	/**
	 * Sets a value to attribute RoomId. 
	 * @param newRoomId 
	 */
	public void setRoomId(int newRoomId) {
		this.RoomId = newRoomId;
	}

	/**
	 * Returns BookingId.
	 * @return BookingId 
	 */
	public int getBookingId() {
		return this.BookingId;
	}

	/**
	 * Sets a value to attribute BookingId. 
	 * @param newBookingId 
	 */
	public void setBookingId(int newBookingId) {
		this.BookingId = newBookingId;
	}

	/**
	 * Returns DateEnd.
	 * @return DateEnd 
	 */
	public Date getDateEnd() {
		return this.DateEnd;
	}

	/**
	 * Sets a value to attribute DateEnd. 
	 * @param newDateEnd 
	 */
	public void setDateEnd(Date newDateEnd) {
		this.DateEnd = newDateEnd;
	}

}
