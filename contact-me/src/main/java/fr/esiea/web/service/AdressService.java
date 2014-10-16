package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.bean.AdressBean;

public interface AdressService {
	
	public void createAdress(AdressBean adressBean);
	public AdressBean readAdress(int idAdress);
	public void updateAdress(AdressBean adressBean);
	public List<AdressBean> findAll();
	List<AdressBean> findAllById(int idContact);
	void deleteAdress(AdressBean adressBean);
}
