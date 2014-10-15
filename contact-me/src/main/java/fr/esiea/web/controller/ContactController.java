package fr.esiea.web.controller;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.repackaged.com.google.protobuf.ServiceException;

import fr.esiea.web.bean.AdressFormBean;
import fr.esiea.web.bean.ContactBean;
import fr.esiea.web.bean.ContactFormBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.service.impl.ContactManager;

@Controller
@SessionAttributes({"contactFormBean","adressFormBean","contactList","index"})
public class ContactController {
	
	private ContactManager contactManager;
	private static final Logger logger = LoggerFactory.getLogger(ContactController.class);
	@RequestMapping("/start")
	public ModelAndView start(ModelMap model) throws ServiceException{
		//viewContactList
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		model.addAttribute("contactFormBean", contactFormBean);
		
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/search")
	public ModelAndView searchContact(ModelMap model,
			@ModelAttribute("contactFormBean") ContactFormBean contactFormBean) throws ServiceException, ParseException{
		ModelAndView mav = new ModelAndView("viewContactList");
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		
		ContactBean contactBean=new ContactBean();
		contactBean.setFirstNameContact(contactFormBean.getFirstNameContact());
		contactBean.setSecondNameContact(contactFormBean.getSecondNameContact());
		Date dateBirthContact=null;
		if(contactFormBean.getDateBirthContact()!=null && !contactFormBean.getDateBirthContact().equals("")){
			dateBirthContact= new SimpleDateFormat("dd/MM/yyyy").parse(contactFormBean.getDateBirthContact());
		}
		contactBean.setDateBirthContact(dateBirthContact);
		contactBean.setMailContact(contactFormBean.getMailContact());
		contactBean.setActiveContact(contactBean.getActiveContact());
		
		List<ContactBean> listContactBean=contactManager.findByCriteria(contactFormBean.getFirstNameContact(), contactFormBean.getSecondNameContact(), dateBirthContact, contactFormBean.getMailContact(), contactBean.getActiveContact());
			
		model.addAttribute("contactList", listContactBean);
		
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/reset")
	public ModelAndView reset(ModelMap model) throws ServiceException{
		//viewContactList
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/addContact")
	public ModelAndView addContact(ModelMap model,
		@ModelAttribute("contactFormBean") ContactFormBean contactFormBean) throws ServiceException, ParseException{
		ModelAndView mav = new ModelAndView("viewContactList");
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		
		ContactBean contactBean=new ContactBean();
		contactBean.setFirstNameContact(contactFormBean.getFirstNameContact());
		contactBean.setSecondNameContact(contactFormBean.getSecondNameContact());
		contactBean.setDateBirthContact( new SimpleDateFormat("dd/MM/yyyy").parse(contactFormBean.getDateBirthContact()));
		contactBean.setMailContact(contactFormBean.getMailContact());
		contactBean.setActiveContact(contactBean.getActiveContact());
		contactManager.createContact(contactBean);
		List<ContactBean> listContactBean=contactManager.findAll();
			
		model.addAttribute("contactList", listContactBean);
		
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(ModelMap model,
		@RequestParam(value = "index", required = true) int index) throws ServiceException{
		//viewContactList
		ModelAndView mav = new ModelAndView("viewDelete");
		model.addAttribute("index", index);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/deleteContact")
	public ModelAndView deleteContact(ModelMap model,
			@ModelAttribute("contactList") List<ContactBean> listContactBean,
			@ModelAttribute("index") int index) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		contactManager.deleteContact(listContactBean.get(index).getIdContact());
		
		listContactBean=contactManager.findAll();
		
		model.addAttribute("contactList", listContactBean);
		
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/resetDelete")
	public ModelAndView resetDeleteContact(ModelMap model,
			@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		listContactBean=contactManager.findAll();
		model.addAttribute("contactList", listContactBean);
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/change")
	public ModelAndView change(ModelMap model,
		@RequestParam(value = "index", required = true) int index,
		@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewChange");
		
		ContactFormBean contactFormBean=new ContactFormBean();
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		ContactBean contact=contactManager.readContact(listContactBean.get(index).getIdContact());
		
		contactFormBean.setFirstNameContact(contact.getFirstNameContact());
		contactFormBean.setSecondNameContact(contact.getSecondNameContact());
		
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = formatter.format(contact.getDateBirthContact());
		
		contactFormBean.setDateBirthContact(dateString);
		contactFormBean.setMailContact(contact.getMailContact());
		contactFormBean.setActiveContact(contact.getActiveContact());
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("index", index);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/consult")
	public ModelAndView consult(ModelMap model,
		@RequestParam(value = "index", required = true) int index,
		@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		
		
		ModelAndView mav = new ModelAndView("viewDetails");
		ContactFormBean contactFormBean=new ContactFormBean();
		ContactBean contact=DataStoreSingleton.getInstance().getContactBeanMap().get(listContactBean.get(index).getIdContact());
		contactFormBean.setFirstNameContact(contact.getFirstNameContact());
		contactFormBean.setSecondNameContact(contact.getSecondNameContact());
		Format formatter = new SimpleDateFormat("dd/MM/yyyy");
		String dateString = formatter.format(contact.getDateBirthContact());
		contactFormBean.setDateBirthContact(dateString);
		contactFormBean.setMailContact(contact.getMailContact());
		contactFormBean.setActiveContact(contact.getActiveContact());
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("contactList", listContactBean);
		AdressFormBean adressFormBean=new AdressFormBean();
		model.addAttribute("adressFormBean", adressFormBean);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/resetChanges")
	public ModelAndView resetChanges(ModelMap model,
			@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		listContactBean=contactManager.findAll();
		model.addAttribute("contactList", listContactBean);
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/saveChanges")
	public ModelAndView saveChanges(ModelMap model,
		@ModelAttribute("contactList") List<ContactBean> listContactBean,
		@ModelAttribute("contactFormBean") ContactFormBean contactFormBean,
		@ModelAttribute("index") int index) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewContactList");
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		ContactBean contactBean=listContactBean.get(index);
		contactBean.setFirstNameContact(contactFormBean.getFirstNameContact());
		contactBean.setSecondNameContact(contactFormBean.getSecondNameContact());
	
		contactBean.setMailContact(contactFormBean.getMailContact());
		contactBean.setActiveContact(contactFormBean.getActiveContact());
		contactManager.updateContact(contactBean);
		
		listContactBean=contactManager.findAll();
		
		model.addAttribute("contactList", listContactBean);
		
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
}
