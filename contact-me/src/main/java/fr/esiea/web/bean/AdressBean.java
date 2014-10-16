package fr.esiea.web.bean;

import java.io.Serializable;

public class AdressBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1610296136502440248L;
	
	
	private int idAdress;
	private int numberAdress;
	private String streetNameAdress;
	private int codeAdess;
	private String cityAdress;
	private int idContactAdress;
	private boolean shippingAdress;
	private boolean billingAdress;
	
	public AdressBean(int idAdress, int numberAdress, String streetNameAdress,
			int codeAdess, String cityAdress, int idContactAdress,
			boolean shippingAdress, boolean billingAdress) {
		super();
		this.idAdress = idAdress;
		this.numberAdress = numberAdress;
		this.streetNameAdress = streetNameAdress;
		this.codeAdess = codeAdess;
		this.cityAdress = cityAdress;
		this.idContactAdress = idContactAdress;
		this.shippingAdress = shippingAdress;
		this.billingAdress = billingAdress;
	}
	public AdressBean() {
	}
	public int getIdContactAdress() {
		return idContactAdress;
	}
	public void setIdContactAdress(int idContactAdress) {
		this.idContactAdress = idContactAdress;
	}
	public int getIdAdress() {
		return idAdress;
	}
	public void setIdAdress(int idAdress) {
		this.idAdress = idAdress;
	}
	public int getNumberAdress() {
		return numberAdress;
	}
	public void setNumberAdress(int numberAdress) {
		this.numberAdress = numberAdress;
	}
	public String getStreetNameAdress() {
		return streetNameAdress;
	}
	public void setStreetNameAdress(String streetNameAdress) {
		this.streetNameAdress = streetNameAdress;
	}
	public int getCodeAdess() {
		return codeAdess;
	}
	public void setCodeAdess(int codeAdess) {
		this.codeAdess = codeAdess;
	}
	public String getCityAdress() {
		return cityAdress;
	}
	public void setCityAdress(String cityAdress) {
		this.cityAdress = cityAdress;
	}
	public boolean getShippingAdress() {
		return shippingAdress;
	}
	public void setShippingAdress(boolean shippingAdress) {
		this.shippingAdress = shippingAdress;
	}
	public boolean getBillingAdress() {
		return billingAdress;
	}
	public void setBillingAdress(boolean billingAdress) {
		this.billingAdress = billingAdress;
	}
	
	
}
