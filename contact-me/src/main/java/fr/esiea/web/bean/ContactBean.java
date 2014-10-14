package fr.esiea.web.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ContactBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12048736047565993L;
	
	private int idContact;
	private String firstNameContact;
	private String secondNameContact;
	private Date dateBirthContact;
	private String mailContact;
	private boolean activeContact;
	private Map<Integer,AdressBean> mapAdressBean;
	
	public ContactBean(int idContact, String firstNameContact,
			String secondNameContact, Date dateBirthContact,String mailContact,boolean activeContact) {
		
		this.idContact = idContact;
		this.firstNameContact = firstNameContact;
		this.secondNameContact = secondNameContact;
		this.dateBirthContact = dateBirthContact;
		this.mailContact=mailContact;
		this.activeContact=activeContact;
		this.mapAdressBean=new HashMap<Integer,AdressBean>();
	
		
	}
	
	public ContactBean() {
		// TODO Auto-generated constructor stub
	}

	public int getIdContact() {
		return idContact;
	}
	public void setIdContact(int idContact) {
		this.idContact = idContact;
	}
	public String getFirstNameContact() {
		return firstNameContact;
	}
	public void setFirstNameContact(String firstNameContact) {
		this.firstNameContact = firstNameContact;
	}
	public String getSecondNameContact() {
		return secondNameContact;
	}
	public void setSecondNameContact(String secondNameContact) {
		this.secondNameContact = secondNameContact;
	}
	public Date getDateBirthContact() {
		return dateBirthContact;
	}
	public void setDateBirthContact(Date dateBirthContact) {
		this.dateBirthContact = dateBirthContact;
	}

	public boolean getActiveContact() {
		return activeContact;
	}

	public void setActiveContact(boolean activeContact) {
		this.activeContact = activeContact;
	}

	public Map<Integer, AdressBean> getMapAdressBean() {
		return mapAdressBean;
	}

	public void setMapAdressBean(Map<Integer, AdressBean> mapAdressBean) {
		this.mapAdressBean = mapAdressBean;
	}

	public String getMailContact() {
		return mailContact;
	}

	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}
	
	
	
}
