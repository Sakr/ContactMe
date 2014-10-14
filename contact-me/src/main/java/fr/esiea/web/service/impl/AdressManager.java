package fr.esiea.web.service.impl;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.service.AdressService;

public class AdressManager implements AdressService{
	private DataStoreSingleton dataStoreSingleton;
	
	
	public AdressManager(DataStoreSingleton dataStoreSingleton) {
		this.dataStoreSingleton = dataStoreSingleton;
	}

	@Override
	public void createAdress(AdressBean adressBean) {
		int idAdress=dataStoreSingleton.getAdressBeanMap().size();
		adressBean.setIdAdress(idAdress);
		dataStoreSingleton.getAdressBeanMap().put(idAdress, adressBean);
	}

	@Override
	public AdressBean readAdress(int idAdress) {
		return dataStoreSingleton.getAdressBeanMap().get(idAdress);
	}

	@Override
	public void updateAdress(AdressBean adressBean) {
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setNumberAdress(adressBean.getNumberAdress());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setStreetNameAdress(adressBean.getStreetNameAdress());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setCodeAdess(adressBean.getCodeAdess());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setCityAdress(adressBean.getCityAdress());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setIdContactAdress(adressBean.getIdContactAdress());
	}

	@Override
	public void deleteAdress(int idAdress) {
		dataStoreSingleton.getAdressBeanMap().remove(idAdress);
	}

}
