package fr.esiea.web.service;

import java.util.List;

import fr.esiea.web.bean.ContactBean;

public interface ContactService {
	public void createContact(ContactBean contactBean);
	public ContactBean readContact(int idContact);
	public void updateContact(ContactBean contactBean);
	public void deleteContact(int idContact);
	public List<ContactBean> findAll();
}
