package fr.esiea.web.utils;

import java.util.Comparator;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.ContactBean;

public class ObjectComparator implements Comparator<Object> {

	public ObjectComparator() {
	}

	@Override
	public int compare(Object o1, Object o2) {
		boolean comparatorReturn=false;
		if(o1 instanceof ContactBean){
			ContactBean contactBean= (ContactBean)o1;
			ContactBean contactBean2= (ContactBean)o2;
			comparatorReturn= contactBean.getFirstNameContact().equalsIgnoreCase(contactBean2.getFirstNameContact()) 
					&& contactBean.getSecondNameContact().equalsIgnoreCase(contactBean2.getSecondNameContact())
					&& contactBean.getMailContact().equalsIgnoreCase(contactBean2.getMailContact());
		}//
		else if(o1 instanceof AdressBean){
			
			AdressBean adressBean =(AdressBean)o1;
			AdressBean adressBean2= (AdressBean)o2;
			comparatorReturn= adressBean.getNumberAdress()==adressBean2.getNumberAdress()
					&& adressBean.getStreetNameAdress().equals(adressBean2.getStreetNameAdress())
					&& adressBean.getCodeAdess()==adressBean2.getCodeAdess()
					&& adressBean.getCityAdress().equals(adressBean2.getCityAdress());
		}else{
			comparatorReturn=o1.equals(o2);
		}
		return ((comparatorReturn) ? 0 : 1);
	}

}