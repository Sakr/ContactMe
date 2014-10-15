package fr.esiea.web.bean;

import java.io.Serializable;
import java.util.Date;

public class ContactFormBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8702795988879182448L;
	/**
	 * 
	 */
	
	private String firstNameContact;
	private String secondNameContact;
	private String dateBirthContact;
	private String mailContact;
	private boolean activeContact;
	
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
	public String getDateBirthContact() {
		return dateBirthContact;
	}
	public void setDateBirthContact(String dateBirthContact) {
		this.dateBirthContact = dateBirthContact;
	}
	public boolean getActiveContact() {
		return activeContact;
	}
	public void setActiveContact(boolean activeContact) {
		this.activeContact = activeContact;
	}
	public String getMailContact() {
		return mailContact;
	}
	public void setMailContact(String mailContact) {
		this.mailContact = mailContact;
	}
	
	
}
