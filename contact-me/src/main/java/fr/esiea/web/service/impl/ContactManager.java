package fr.esiea.web.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.ContactBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.service.ContactService;
import fr.esiea.web.utils.ObjectComparator;


/**
 * Dans le cas d'utilisation d'une base de données le contenu des méthodes CRUD suivantes devra etre remplacé par 
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
	public boolean createContact(ContactBean contactBean) {
		int idContact=dataStoreSingleton.getAdressBeanMap().size();
		contactBean.setIdContact(idContact);
		
		boolean returnValue=true;
		ObjectComparator objectComparator=new ObjectComparator();
		Map<Integer,ContactBean>contactMap=dataStoreSingleton.getContactBeanMap();
		for (Integer mapKey : contactMap.keySet()) {
			if(objectComparator.compare(contactBean, contactMap.get(mapKey))==0){
				returnValue=false;
				continue;
			}
		}
		
		//On ecrit si le contact n'existe pas
		if(returnValue){
			contactBean.setMapAdressBean(new HashMap<Integer,AdressBean>());
			dataStoreSingleton.getContactBeanMap().put(idContact, contactBean);
		}
		
		
		return returnValue;
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
	/**
	 * Les criteres sont disponibles en parametres à l'entrée de cette méthode
	 * Ils seront à utiliser lorsqu'on ajoute une base de donnée à l'application
	 * L'utilisation de SQL facilitera l'implementation d'une recherche plus fine c'est pour cela nous nous restreignions a la recherche par nom ou prenom 
	 */
	@Override
	public List<ContactBean> findByCriteria(String firstName, String lastName, Date dateOfBirth, String mailContact,Boolean actif) {
		
		List<ContactBean> listContactBean=new ArrayList<ContactBean>();
		Map<Integer,ContactBean>contactMap=dataStoreSingleton.getContactBeanMap();
		ContactBean contactBean;
		for (Integer mapKey : contactMap.keySet()) {
			contactBean=contactMap.get(mapKey);
			if(firstName!=null && !firstName.equals("")){
				if(contactBean.getFirstNameContact().equalsIgnoreCase(firstName)){
					if(lastName!=null && !lastName.equals("")){
						if(contactBean.getSecondNameContact().equalsIgnoreCase(lastName)){
							listContactBean.add(contactBean);
						}
					}else{
						listContactBean.add(contactBean);
					}
					
				}	
			}else{
				if(lastName!=null && !lastName.equals("")){
					if(contactBean.getSecondNameContact().equalsIgnoreCase(lastName)){
						listContactBean.add(contactBean);
					}
				}else{
					listContactBean.add(contactBean);
				}
			}
			
		}
		return listContactBean;
		
	}
}
