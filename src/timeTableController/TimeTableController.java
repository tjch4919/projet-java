package timeTableController;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import timeTableModel.TimeTable;
import timeTableModel.TimeTableDB;
import timeTableModel.book;
import timeTableModel.room;
/**
 * Cette classe est le contr√¥leur d'emplois du temps que vous devez impl√©menter. 
 * Elle contient un attribut correspondant √† la base de donn√©es d'emplois du temps que vous allez cr√©er.
 * Elle contient toutes les fonctions de l'interface ITimeTableController que vous devez impl√©menter.
 * 
 * @author Jose Mennesson (Mettre √† jour)
 * @version 04/2016 (Mettre √† jour)
 * 
 */

//TODO Classe √† modifier

public class TimeTableController implements ITimeTableController{

	/**
	 * Contient une instance de base de donn®¶es d'emplois du temps
	 * 
	 */
	TimeTableDB tTDB;
	/**
	 * Constructeur de controleur d'emplois du temps cr®¶ant la base de donn®¶es d'emplois du temps
	 * 
	 * @param tTfile
	 * 		Fichier XML contenant la base de donn®¶es d'emplois du temps
	 */
	public TimeTableController(String tTfile) {
		TimeTableDB tTDB=new TimeTableDB(tTfile);
		this.tTDB=tTDB;
	}

	//@Override
	public String getTeacherLogin(int timeTableId, int bookId) {
		// TODO Auto-generated method stub
		String L = null ; 
		Iterator<TimeTable> iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			TimeTable t = iter.next();
			if(t.GroupId == timeTableId){
				Iterator<book> iter2 = t.books.iterator();
				while(iter2.hasNext()){
					book b = iter2.next();
					if(b.BookingId == bookId){
						L = b.getLogin();
						
					}
				}
			}
		}
		
		return L;
	}

	//@Override
	public String[] roomsIdToString() {
		// TODO Auto-generated method stub
		int i =0;
		String [] s ;
		int m =  tTDB.rooms.size();
		s = new String[m];
		
		for(Iterator<room>iter = tTDB.rooms.iterator();iter.hasNext();i++){
			s[i] = iter.next().roomIDtoS();
		}
		return s;
	}

	//@Override
	public String[] roomsToString() {
		// TODO Auto-generated method stub
		int i = 0;
		String [] s ;
		int m = tTDB.rooms.size();
		s = new String[m];
		for(Iterator<room>iter = tTDB.rooms.iterator();iter.hasNext();i++){
			s[i] = iter.next().roomIFtos();
		}
		return s;
	}

	//@Override
	public String[] timeTablesIDToString() {
		// TODO Auto-generated method stub
		int i = 0 ; 
		String [] s ;
		int m = tTDB.timeTables.size();
		s = new String[m];
		for(Iterator<TimeTable> iter = tTDB.timeTables.iterator();iter.hasNext();i++){
			s[i] = iter.next().timetIDtos();
		}
		return s;
	}

	//@Override
	public String[] booksIdToString(int timeTableId) {
		// TODO Auto-generated method stub
		int i = 0;
		String [] s,p;
		p = new String[100]; 
		Iterator<TimeTable>iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			TimeTable t = iter.next();
			if (t.GroupId == timeTableId){
				Iterator<book>iter2 = t.books.iterator();
				int m = t.books.size();
				
				s = new String[m];
				for(;iter2.hasNext();i++){
					s[i] = iter2.next().bookIDtoS();
					p=s;
				}
					
				
			}
		}
		return p ;
	}

	//@Override
	public boolean addRoom(int roomId, int capacity) {
		// TODO Auto-generated method stub
		boolean o = false,p=true;
		Iterator<room> iter = tTDB.rooms.iterator();
		while(iter.hasNext()){
			room r = iter.next();
			if(r.getRoomId() == roomId){
				p = false ;
			}
		}
		if(p){
			room R = new room(roomId,capacity);
			tTDB.rooms.add(R);	
			o = true ;
			
		}
		saveDB();
		return o;
	}

	//@Override
	public boolean removeRoom(int roomId) {
		// TODO Auto-generated method stub
		int flag = 0;
		Iterator<room> iter = tTDB.rooms.iterator();
		room r = null;
		while(iter.hasNext()){
			 r = iter.next();
			if (r.getRoomId() == roomId ){
				flag=1;
				break;
			}
		}
		if (flag==1){
			tTDB.rooms.remove(r);
			saveDB();
			return true;
		}
		else 
		return false;
	}

	//@Override
	public int getRoom(int timeTableId, int bookId) {
		// TODO Auto-generated method stub
		int ID = -1;
		Iterator <TimeTable> iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			TimeTable t = iter.next();
			if(t.GroupId == timeTableId){
				Iterator<book> iter2 = t.books.iterator();
				while(iter2.hasNext()){
					book b = iter2.next();
					if(b.BookingId == bookId){
						ID=b.RoomId;
					}
				}
			}
		}
		return ID ;
	}

	//@Override
	public boolean addTimeTable(int timeTableId) {
		boolean o = false, p=true;
		Iterator<TimeTable> iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			TimeTable t = iter.next();
			if(t.GroupId == timeTableId){
				p = false ;
			}	
		}
		if(p){	
			TimeTable T = new TimeTable(timeTableId);
			tTDB.timeTables.add(T);
			o= true;	
		}
		saveDB();
		return o ;
	}

	//@Override
	public boolean removeTimeTable(int timeTableId) {
		// TODO Auto-generated method stub
		boolean f = false ;
		TimeTable t= null;
		Iterator<TimeTable> iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			t = iter.next();
			if(t.GroupId == timeTableId){
				f = true ;
				break;
			}
		}
		if (f)
			tTDB.timeTables.remove(t);
		saveDB();
		return f ;	
			
	}

	//@Override
	public boolean addBooking(int timeTableId, int bookingId, String login, Date dateBegin, Date dateEnd, int roomId) {
		boolean o =false,p=true;
		Iterator<TimeTable>iter = tTDB.timeTables.iterator();  
		while(iter.hasNext()){
			TimeTable t = iter.next();
			if(t.GroupId == timeTableId ){
				Iterator<book> iter2 = t.books.iterator();
				while(iter2.hasNext()){
					book b = iter2.next();
					if(b.getBookingId()==bookingId){
						p = false ;
					}
				}
				if(p){
					book B = new book(login,roomId,bookingId,dateBegin,dateEnd);
					t.books.add(B);
					o = true ;
				}
			}
		}
		
		saveDB();
		return o;
	}

	//@Override
	public void getBookingsDate(int timeTableId, Hashtable<Integer, Date> dateBegin, Hashtable<Integer, Date> dateEnd) {
		// TODO Auto-generated method stub
		Iterator<TimeTable> iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			TimeTable t = iter.next();
			if(t.GroupId == timeTableId){
				Iterator<book>iter2 = t.books.iterator();
				while(iter2.hasNext()){
					book b = iter2.next();
					dateBegin.put(b.BookingId , b.DateBegin);
					dateEnd.put(b.BookingId, b.DateEnd);
				}
				
			}
		}
			
		
	}

	//@Override
	public boolean removeBook(int timeTableId, int bookId) {
		// TODO Auto-generated method stub
		boolean o = false;
		TimeTable t=null;
		book b = null;
		Iterator<TimeTable>iter = tTDB.timeTables.iterator();
		while(iter.hasNext()) {
			t = iter.next();
			if(t.GroupId == timeTableId){
				Iterator<book> iter2 = t.books.iterator();
				while(iter2.hasNext()){
					b = iter2.next();
					if(b.BookingId == bookId){
						o = true;
						break;
					}
				}
				break;
			}
		}
		if(o){
			tTDB.timeTables.remove(t);
		    t.books.remove(b);
		    tTDB.timeTables.add(t);
		}
		saveDB();
		return o;
	}

	//@Override
	public int getBookingsMaxId(int timeTableId) {
		// TODO Auto-generated method stub
		int ID=0;
		Iterator<TimeTable>iter = tTDB.timeTables.iterator();
		while(iter.hasNext()){
			TimeTable ittb = iter.next();
			if(ittb.GroupId == timeTableId){
				ID = ittb.books.size();
			}
		}
		return ID;
	}

	//@Override
	public boolean saveDB() {
		// TODO Auto-generated method stub
		
		Element rootElt = new Element("timeTableDB");
		org.jdom2.Document document = new Document(rootElt);
		Element unTTsElt = new Element ("timeTables");
		Element unRoomsElt = new Element ("Rooms");		
		rootElt.addContent(unTTsElt);
		rootElt.addContent(unRoomsElt);
		for(Iterator<room> iter3 = tTDB.rooms.iterator();iter3.hasNext();){
			room r = iter3.next();
			Element unRoomElt = new Element("Room");
			unRoomsElt.addContent(unRoomElt);
			Element unRoomIdElt = new Element("RoomId");
			unRoomIdElt.setText(""+r.getRoomId());
			unRoomElt.addContent(unRoomIdElt);
			Element unCapacityElt = new Element ("Capacity");
			unCapacityElt.setText(""+r.getCapacity());
			unRoomElt.addContent(unCapacityElt);
		}
		for(Iterator<TimeTable> iter = tTDB.timeTables.iterator();iter.hasNext();){
			TimeTable t = iter.next();
			Element unTTElt = new Element("timeTable");
			unTTsElt.addContent(unTTElt);
			Element GroupIdElt = new Element("GroupId");
			GroupIdElt.setText(""+t.GroupId);
			unTTElt.addContent(GroupIdElt);
			Element unBKsElt = new Element ("Books");
			unTTElt.addContent(unBKsElt);
			for(Iterator<book> iter2 = t.books.iterator();iter2.hasNext();){
				book b = iter2.next();
				Element unBookElt = new Element("Book");
				unBKsElt.addContent(unBookElt); 
				Element unBookingIdElt  = new Element ("BookingId");
			    unBookingIdElt.setText(""+b.BookingId);
			    unBookElt.addContent(unBookingIdElt);
				Element unLoginElt = new Element ("Login");
				unLoginElt.addContent(b.Login);
				unBookElt.addContent(unLoginElt);
				Element unDateEndElt = new Element ("DateEnd");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				unDateEndElt.setText(sdf.format(b.DateEnd));
				unBookElt.addContent(unDateEndElt);
				Element unDateBeginElt = new Element ("DateBegin");
				SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
				unDateBeginElt.setText(sdf2.format(b.DateBegin));
				unBookElt.addContent(unDateBeginElt);
				Element unRoomIdElt = new Element ("RoomId");
				unRoomIdElt.setText(""+b.RoomId);
				unBookElt.addContent(unRoomIdElt);
			}
			try{
				XMLOutputter sortie =
				new XMLOutputter(Format.getPrettyFormat());
				sortie.output(document, new FileOutputStream("timeTableDB.xml"));
				}catch (java.io.IOException e){}
		}
		return true;
	}

	//@Override
	public boolean loadDB() {
		tTDB.loadDB();
		return true;
	}
	
	

}
