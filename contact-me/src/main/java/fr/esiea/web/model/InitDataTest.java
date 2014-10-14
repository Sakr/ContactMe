package fr.esiea.web.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.ContactBean;

/**
 * Cette class ne sert que pour tester, idéalement elle devra etre remplacer par une base de donnée
 * @author sakr
 *
 */
public class InitDataTest {
	
	private static DataStoreSingleton dataStoreSingleton;
	
	public static void run() throws ParseException {
		//On instancie notre "Singleton sur lequel on va sotcker tous les données.
		dataStoreSingleton=DataStoreSingleton.getInstance();
		//On ecrit les données dessus
		initContactData(dataStoreSingleton);
		initAdressData(dataStoreSingleton);
		
	}
	
	private static void initContactData(DataStoreSingleton dataStoreSingleton) throws ParseException{
		
		Date date;
		String date_1 = "23/12/1993" ; 
		String date_2 = "05/09/1992" ;
		String date_3 = "12/08/1991" ;
		date = new SimpleDateFormat("dd/MM/yyyy").parse(date_1);
		ContactBean contact_3=new ContactBean(1, "MEYER", "Marion",date , "meyer@et.esiea.fr",true);
		date = new SimpleDateFormat("dd/MM/yyyy").parse(date_2);
		ContactBean contact_2=new ContactBean(2, "NOEL", "Benjamin",date, "bnoel@et.esiea.fr",true);
		date = new SimpleDateFormat("dd/MM/yyyy").parse(date_3);
		ContactBean contact_1=new ContactBean(3, "LIMEM", "Sakr",date , "limem@et.esiea.fr",true);
		
		dataStoreSingleton.getContactBeanMap().put(contact_1.getIdContact(), contact_1);
		dataStoreSingleton.getContactBeanMap().put(contact_2.getIdContact(), contact_2);
		dataStoreSingleton.getContactBeanMap().put(contact_3.getIdContact(), contact_3);
	}
	
	
	private static void initAdressData(DataStoreSingleton dataStoreSingleton){
		
		AdressBean adressBean_1=new AdressBean(1, 72, "Avenue Maurice Thorez", 94200, "Vanves", 1);
		AdressBean adressBean_2=new AdressBean(2, 27, "Rue Jean Bleuzen", 92170, "Vanves", 2);
		AdressBean adressBean_3=new AdressBean(3, 29, "Rue Jean Bleuzen", 92170, "Vanves", 3);
		AdressBean adressBean_4=new AdressBean(4, 8, "Rue Abou Oubayda Takafi", 1057, "Gammarth", 3);
		
		dataStoreSingleton.getAdressBeanMap().put(adressBean_1.getIdAdress(), adressBean_1);
		dataStoreSingleton.getAdressBeanMap().put(adressBean_2.getIdAdress(), adressBean_2);
		dataStoreSingleton.getAdressBeanMap().put(adressBean_3.getIdAdress(), adressBean_3);
		dataStoreSingleton.getAdressBeanMap().put(adressBean_4.getIdAdress(), adressBean_4);
	}
	
}
