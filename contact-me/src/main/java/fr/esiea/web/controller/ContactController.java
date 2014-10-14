package fr.esiea.web.controller;

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
@SessionAttributes({"contactFormBean","adressFormBean","contactList"})
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
	public ModelAndView searchContact(ModelMap model) throws ServiceException{
		//
		
		System.out.println(DataStoreSingleton.getInstance().getContactBeanMap().get(1).getFirstNameContact()+DataStoreSingleton.getInstance().getContactBeanMap().get(1).getSecondNameContact());
		ModelAndView mav = new ModelAndView("index");
		
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
	
	
	@RequestMapping("/delete")
	public ModelAndView delete(ModelMap model,
		@RequestParam(value = "index", required = true) int index) throws ServiceException{
		//viewContactList
		ModelAndView mav = new ModelAndView("viewDelete");
		System.out.println("L'index est: "+index);
		return mav;
	}
	@RequestMapping("/deleteContact")
	public ModelAndView deleteContact(ModelMap model) throws ServiceException{
		//viewContactList
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/resetDelete")
	public ModelAndView resetDeleteContact(ModelMap model) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
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
		contactFormBean.setDateBirthContact(contact.getDateBirthContact());
		contactFormBean.setMailContact(contact.getMailContact());
		contactFormBean.setActiveContact(contact.getActiveContact());
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/consult")
	public ModelAndView consult(ModelMap model,
		@RequestParam(value = "index", required = true) int index,
		@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		//viewContactList
		
		ModelAndView mav = new ModelAndView("viewDetails");
		ContactFormBean contactFormBean=new ContactFormBean();
		
		ContactBean contact=DataStoreSingleton.getInstance().getContactBeanMap().get(listContactBean.get(index).getIdContact());
		contactFormBean.setFirstNameContact(contact.getFirstNameContact());
		contactFormBean.setSecondNameContact(contact.getSecondNameContact());
		contactFormBean.setDateBirthContact(contact.getDateBirthContact());
		contactFormBean.setMailContact(contact.getMailContact());
		contactFormBean.setActiveContact(contact.getActiveContact());
		model.addAttribute("contactFormBean", contactFormBean);
		
		AdressFormBean adressFormBean=new AdressFormBean();
		model.addAttribute("adressFormBean", adressFormBean);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/resetChanges")
	public ModelAndView saveChanges(ModelMap model) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
}
