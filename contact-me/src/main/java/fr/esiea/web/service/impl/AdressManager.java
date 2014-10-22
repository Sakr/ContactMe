package fr.esiea.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.ContactBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.service.AdressService;

public class AdressManager implements AdressService{
	
	private DataStoreSingleton dataStoreSingleton;
	
	public AdressManager(DataStoreSingleton dataStoreSingleton) {
		this.dataStoreSingleton = dataStoreSingleton;
	}
	@Override
	public boolean createAdress(AdressBean adressBean) {
		int idAdress=dataStoreSingleton.getAdressBeanMap().size();
		adressBean.setIdAdress(idAdress);
		//On insere l'adresse sur une map
		dataStoreSingleton.getAdressBeanMap().put(idAdress, adressBean);
		//Et on l'insere sur la map de l'utilisateur
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().put(idAdress, adressBean);
		return false;
	}
	@Override
	public AdressBean readAdress(int idAdress) {
		return dataStoreSingleton.getAdressBeanMap().get(idAdress);
	}
	@Override
	public void updateAdress(AdressBean adressBean) {
		//On met a jour l'entité sur la map
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setNumberAdress(adressBean.getNumberAdress());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setStreetNameAdress(adressBean.getStreetNameAdress());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setCodeAdess(adressBean.getCodeAdess());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setCityAdress(adressBean.getCityAdress());
		dataStoreSingleton.getAdressBeanMap().get(adressBean.getIdAdress()).setIdContactAdress(adressBean.getIdContactAdress());
	
		//On met a jour l'entité sur la map du contact
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().get(adressBean.getIdAdress()).setNumberAdress(adressBean.getNumberAdress());
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().get(adressBean.getIdAdress()).setStreetNameAdress(adressBean.getStreetNameAdress());
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().get(adressBean.getIdAdress()).setCodeAdess(adressBean.getCodeAdess());
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().get(adressBean.getIdAdress()).setCityAdress(adressBean.getCityAdress());
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().get(adressBean.getIdAdress()).setIdContactAdress(adressBean.getIdContactAdress());
	
	}
	@Override
	public void deleteAdress(AdressBean adressBean) {
		dataStoreSingleton.getAdressBeanMap().remove(adressBean.getIdAdress());
		dataStoreSingleton.getContactBeanMap().get(adressBean.getIdContactAdress()).getMapAdressBean().remove(adressBean.getIdAdress());
	}
	@Override
	public List<AdressBean> findAll() {
		List<AdressBean> listAdressBean=new ArrayList<AdressBean>();
		Map<Integer,AdressBean>adressMap=dataStoreSingleton.getAdressBeanMap();
		for (Integer mapKey : adressMap.keySet()) {
			listAdressBean.add(adressMap.get(mapKey));
		}
		return listAdressBean;
	}
	@Override
	public List<AdressBean> findAllById(int idContact) {
		List<AdressBean> listAdressBean=new ArrayList<AdressBean>();
		if(!dataStoreSingleton.getContactBeanMap().get(idContact).getMapAdressBean().isEmpty()){
			Map<Integer,AdressBean>adressMap=dataStoreSingleton.getContactBeanMap().get(idContact).getMapAdressBean();
			for (Integer mapKey : adressMap.keySet()) {
					listAdressBean.add(adressMap.get(mapKey));
			}
		}
		
		return listAdressBean;
	}
}
