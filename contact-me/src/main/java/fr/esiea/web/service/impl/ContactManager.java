package fr.esiea.web.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import fr.esiea.web.bean.ContactBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.service.ContactService;


/**
 * Dans le cas d'utilisation d'une base de donn�es le contenu des m�thodes CRUD suivantes devra etre remplac� par 
 * des requetes SQL
 * @author sakr
 *
 */
public class ContactManager implements ContactService{
	
	private DataStoreSingleton dataStoreSingleton;
	
	public ContactManager(DataStoreSingleton dataStoreSingleton) {
		this.dataStoreSingleton = dataStoreSingleton;
	}
	@Override
	public void createContact(ContactBean contactBean) {
		int idContact=dataStoreSingleton.getAdressBeanMap().size();
		contactBean.setIdContact(idContact);
		dataStoreSingleton.getContactBeanMap().put(idContact, contactBean);
	}

	@Override
	public ContactBean readContact(int idContact) {
		return dataStoreSingleton.getContactBeanMap().get(idContact);
	}

	@Override
	public void updateContact(ContactBean contactBean) {
		dataStoreSingleton.getContactBeanMap().get(contactBean.getIdContact()).setFirstNameContact(contactBean.getFirstNameContact());
		dataStoreSingleton.getContactBeanMap().get(contactBean.getIdContact()).setSecondNameContact(contactBean.getSecondNameContact());
		dataStoreSingleton.getContactBeanMap().get(contactBean.getIdContact()).setDateBirthContact(contactBean.getDateBirthContact());
		dataStoreSingleton.getContactBeanMap().get(contactBean.getIdContact()).setMailContact(contactBean.getMailContact());
		dataStoreSingleton.getContactBeanMap().get(contactBean.getIdContact()).setActiveContact(contactBean.getActiveContact());
	}

	@Override
	public void deleteContact(int idContact) {
		dataStoreSingleton.getContactBeanMap().remove(idContact);
	}

	@Override
	public List<ContactBean> findAll() {
		List<ContactBean> listContactBean=new ArrayList<ContactBean>();
		Map<Integer,ContactBean>contactMap=dataStoreSingleton.getContactBeanMap();
		for (Integer mapKey : contactMap.keySet()) {
			listContactBean.add(contactMap.get(mapKey));
		}
		return listContactBean;
	}
}
