package fr.esiea.web.service;

import java.util.Date;
import java.util.List;

import fr.esiea.web.bean.ContactBean;

public interface ContactService {
	public boolean createContact(ContactBean contactBean);
	public ContactBean readContact(int idContact);
	public void updateContact(ContactBean contactBean);
	public void deleteContact(int idContact);
	public List<ContactBean> findAll();
	public List<ContactBean>findByCriteria(String firstName,String lastName,Date dateOfBirth,String mailContact,Boolean actif);
}
