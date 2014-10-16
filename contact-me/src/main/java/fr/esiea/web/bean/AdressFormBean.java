package fr.esiea.web.bean;

import java.io.Serializable;

public class AdressFormBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4628211442818121415L;
	
	private int idAdress;
	private int numberAdress;
	private String streetNameAdress;
	private int codeAdess;
	private String cityAdress;
	private int idContactAdress;
	private boolean adressShipping;
	private boolean adressBilling;
	
	
	
	
	public AdressFormBean() {
		super();
	}
	public AdressFormBean(int idAdress, int numberAdress,
			String streetNameAdress, int codeAdess, String cityAdress,
			int idContactAdress, boolean adressShipping, boolean adressBilling) {
		super();
		this.idAdress = idAdress;
		this.numberAdress = numberAdress;
		this.streetNameAdress = streetNameAdress;
		this.codeAdess = codeAdess;
		this.cityAdress = cityAdress;
		this.idContactAdress = idContactAdress;
		this.adressShipping = adressShipping;
		this.adressBilling = adressBilling;
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
	public int getIdContactAdress() {
		return idContactAdress;
	}
	public void setIdContactAdress(int idContactAdress) {
		this.idContactAdress = idContactAdress;
	}
	public boolean getAdressShipping() {
		return adressShipping;
	}
	public void setAdressShipping(boolean adressShipping) {
		this.adressShipping = adressShipping;
	}
	public boolean getAdressBilling() {
		return adressBilling;
	}
	public void setAdressBilling(boolean adressBilling) {
		this.adressBilling = adressBilling;
	}
	
	
}
