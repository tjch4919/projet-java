/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package timeTableModel;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of TimeTableDB.
 * 
 * @author chu
 */
public class TimeTableDB {
	/**
	 * Description of the property file.
	 */
	private String file ;

	/**
	 * Description of the property timeTables.
	 */
	public HashSet<TimeTable> timeTables = new HashSet<TimeTable>();

	/**
	 * Description of the property rooms.
	 */
	public HashSet<room> rooms = new HashSet<room>();

	// Start of user code (user defined attributes for TimeTableDB)

	// End of user code

	/**
	 * The constructor.
	 */
	public TimeTableDB(String file) {
		// Start of user code constructor for TimeTableDB)
		
		this.setFile(file); 
		// End of user code
	}


	/**
	 * Description of the method loadDB.
	 */
	public void loadDB() {
		org.jdom2.Document document = null ;
		Element rootElt;
		SAXBuilder sxb = new SAXBuilder();
		try{
		document = sxb.build(new File(file));
		}catch(Exception e){}
		if(document!=null){
			rootElt = document.getRootElement();
			Element RoomsElt = rootElt.getChild("Rooms");
			 List<Element> RoomElt = RoomsElt.getChildren("Room");
			  Iterator <Element> it =  RoomElt.iterator();
			  while (it.hasNext()){
				  Element e = it.next();
				  String roomid = e.getChild("RoomId").getText();
				  String Capacity = e.getChild("Capacity").getText();
				  room R = new room (Integer.parseInt(roomid),Integer.parseInt(Capacity));
				  rooms.add(R);
			  }
			Element TimetablesElt = rootElt.getChild("timeTables");
			 List<Element> TimetableElt = TimetablesElt.getChildren("timeTable");
				Iterator <Element> it1 =  TimetableElt.iterator();	
				while (it1.hasNext()){
					Element e2 = it1.next();
					String groupID = e2.getChild("GroupId").getText();
					Element BooksElt = e2.getChild("Books");
					List<Element> BookElt = BooksElt.getChildren("Book");
					Iterator <Element> it2 = BookElt.iterator();
					TimeTable ttable = new TimeTable(Integer.parseInt(groupID));
					while (it2.hasNext()){
						Element e3 = it2.next();
						String BookingId = e3.getChild("BookingId").getText();
						String Login = e3.getChild("Login").getText();
						String DateBegin = e3.getChild("DateBegin").getText();
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
						Date datebegin = null;
						try {
							datebegin = sdf.parse(DateBegin);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						String DateEnd = e3.getChild("DateEnd").getText();
						Date dateend = null;
						try {
							dateend = sdf.parse(DateEnd);
						} catch (ParseException e) {
							e.printStackTrace();
						}
						String RoomId = e3.getChild("RoomId").getText();
						book newBook = new book(Login,Integer.parseInt(RoomId),Integer.parseInt(BookingId),datebegin,dateend);
						ttable.books.add(newBook);
					}
					timeTables.add(ttable);
				}
		}
	}

	/**
	 * Description of the method addRoom.
	 */

	/**
	 * Returns file.
	 * @return file 
	 * Getter de file
	 * 
	 * @return 
	 * 		Le nom du fichier qui contient la base de donn¨¦es.
	 */
	public String getFile() {
		return file;
	}
	/**
	 * Setter de file
	 * 
	 * @param file
	 * 		Le nom du fichier qui contient la base de donn¨¦es.
	 */
	public void setFile(String file) {
		this.file = file;
	}
	public HashSet<TimeTable> getTimeTables() {
		return this.timeTables;
	}

	/**
	 * Returns rooms.
	 * @return rooms 
	 */
	public HashSet<room> getRooms() {
		return this.rooms;
	}

}
