package timeTableModel;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Hashtable;

import timeTableController.TimeTableController;
/**
 * Cette classe permet de tester les fonctions du contrôleur d'emplois du temps.
 * Elle crée une base de données de 3 salles et de 4 réservations d'emplois du temps et les sauvegarde dans le fichier "timeTableDB.xml". 
 * 
 * @author Jose Mennesson (Mettre à jour)
 * @version 04/2016 (Mettre à jour)
 * 
 */

//TODO Classe pouvant être modifiée suivant vos besoins

public class Main {
	/**
	 * Fonction principale 
	 * 
	 * @param args
	 * 			Les arguments donnés en entrée du programme.
	 * 
	 */
	public static void test_addingTimetable(TimeTableController UC){
		System.out.println(UC.addTimeTable(3));
		UC.addTimeTable(1);
	}
	public static void test_addingroom(TimeTableController UC){
		UC.addRoom(1,50);
		UC.addRoom(4,100);
		UC.addRoom(3,150);
		UC.addRoom(4,30);
		UC.addRoom(5,90);
		System.out.println(UC.addRoom(7,102));
	}
	public static void test_addingbooking(TimeTableController UC){
		Calendar dbeg1 = new GregorianCalendar(2016,3,6,8,00);
		Calendar dend1 = new GregorianCalendar(2016,3,6,10,00);	
		Date dated1=dbeg1.getTime();
		Date datee1=dend1.getTime();
		
		Calendar dbeg2 = new GregorianCalendar(2016,3,6,13,00);
		Calendar dend2 = new GregorianCalendar(2016,3,6,17,00);	
		Date dated2=dbeg2.getTime();
		Date datee2=dend2.getTime();
		
		Calendar dbeg3 = new GregorianCalendar(2016,3,7,8,15);
		Calendar dend3 = new GregorianCalendar(2016,3,7,11,45);	
		Date dated3=dbeg3.getTime();
		Date datee3=dend3.getTime();
		
		Calendar dbeg4 = new GregorianCalendar(2016,3,8,16,00);
		Calendar dend4 = new GregorianCalendar(2016,3,8,18,00);	
		Date dated4=dbeg4.getTime();
		Date datee4=dend4.getTime();
		UC.addBooking(2,0,"GS",dated1,datee1,1);  
		UC.addBooking(4,1,"MF",dated2,datee2,1);
		System.out.println(UC.addBooking(3,3,"GS",dated3,datee3,2));
		//UC.addBooking(1,3,"MF",dated4,datee4,3);
	}
	public static void test_remove(TimeTableController UC){
		System.out.println(UC.removeRoom(2));
	    System.out.println(UC.removeTimeTable(5));
	    System.out.println(UC.removeBook(2, 0));
	}
	public static void test_getting(TimeTableController UC){
		System.out.println(UC.getTeacherLogin(2, 2));
		System.out.println(UC.getBookingsMaxId(1));
		System.out.println("The roomID is "+UC.getRoom(4, 3));
	}
	public static void test_toString(TimeTableController UC){
		String[]  s= UC.roomsIdToString();
		for(int i=0;i<s.length;i++)
			System.out.println(s[i]);
		String[] ss = UC.roomsToString();
		for(int i=0;i<ss.length;i++)
			System.out.println(ss[i]);
		String[] ts = UC.timeTablesIDToString();
		for(int i=0;i<ts.length;i++)
			System.out.println(ts[i]);
		String[] bs = UC.booksIdToString(1);
		for(int i=0;i<bs.length;i++)
			System.out.println(bs[i]);
	}
	public static void test_getBookingsDate(TimeTableController UC){
		Hashtable<Integer,Date> dateBegin = new Hashtable();
		Hashtable<Integer,Date> dateEnd = new Hashtable();
		UC.getBookingsDate(2, dateBegin,  dateEnd); 
		System.out.println("The Dates of the beginning of this Timetable are:");
		for(Integer keyd : dateBegin.keySet()){
			Date valued = dateBegin.get(keyd);
			SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println("For reservation "+keyd+" the time of beginning is");
			System.out.println(sdf1.format(valued));
		}
		System.out.println("The Dates of the end of this Timetable are:");
		for(Integer keye : dateEnd.keySet()){
			Date valuee = dateEnd.get(keye);
			SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			System.out.println("For reservation "+keye+" the time of beginning is");
			System.out.println(sdf2.format(valuee));
		}
	}
	public static void main(String[] args) {
		
		final String file="timeTableDB.xml";
		TimeTableController UC=new TimeTableController(file);
		UC.loadDB();
		test_addingroom(UC);
		test_addingTimetable(UC);
		test_addingbooking(UC);
	    test_getting(UC);
	    test_toString(UC);
	    test_getBookingsDate(UC);
	    test_remove(UC);
		UC.saveDB();
	}
}
