package fr.esiea.web.service;

import fr.esiea.web.bean.AdressBean;

public interface AdressService {
	
	public void createAdress(AdressBean adressBean);
	public AdressBean readAdress(int idAdress);
	public void updateAdress(AdressBean adressBean);
	public void deleteAdress(int idAdress);
}
