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

import fr.esiea.web.bean.AdressBean;
import fr.esiea.web.bean.AdressFormBean;
import fr.esiea.web.bean.ContactBean;
import fr.esiea.web.bean.ContactFormBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.service.impl.AdressManager;
import fr.esiea.web.service.impl.ContactManager;

@Controller
@SessionAttributes({"contactFormBean","adressFormBean","contactList","index","adressList","doublon"})
public class ContactController {
	
	private ContactManager contactManager;
	private AdressManager adressManager;
	
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
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		model.addAttribute("contactFormBean", contactFormBean);
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		List<ContactBean> listContactBean=contactManager.findAll();
		model.addAttribute("contactList", listContactBean);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/addContact")
	public ModelAndView addContact(ModelMap model,
		@ModelAttribute("contactFormBean") ContactFormBean contactFormBean) throws ServiceException, ParseException{
		ModelAndView mav = new ModelAndView("viewContactList"); ;
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		
		ContactBean contactBean=new ContactBean();
		contactBean.setFirstNameContact(contactFormBean.getFirstNameContact());
		contactBean.setSecondNameContact(contactFormBean.getSecondNameContact());
		contactBean.setDateBirthContact( new SimpleDateFormat("dd/MM/yyyy").parse(contactFormBean.getDateBirthContact()));
		contactBean.setMailContact(contactFormBean.getMailContact());
		contactBean.setActiveContact(contactBean.getActiveContact());
		
		
		if(!contactManager.createContact(contactBean)){
			model.addAttribute("doublon", contactManager.createContact(contactBean));
		}
		List<ContactBean> listContactBean=contactManager.findAll();
			
		model.addAttribute("contactList", listContactBean);
		
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/popupAddContact")
	public ModelAndView addContactPopup(ModelMap model,
			@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewAddContact");
		
		ContactFormBean contactFormBean=new ContactFormBean();
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
		model.addAttribute("doublon", "");
		model.addAttribute("contactFormBean", contactFormBean);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/resetDelete")
	public ModelAndView resetDeleteContact(ModelMap model,
			@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
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
		model.addAttribute("doublon", "");
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
		
		model.addAttribute("contactList", listContactBean);
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("index", index);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/consult")
	public ModelAndView consult(ModelMap model,
		@RequestParam(value = "index", required = true) int index,
		@ModelAttribute("contactList") List<ContactBean> listContactBean) throws ServiceException{
		
		model.addAttribute("doublon", "");
		ModelAndView mav = new ModelAndView("viewDetails");
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
		
		AdressFormBean adressFormBean=new AdressFormBean();
		
		//On charge laliste des adresses du contact
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		List<AdressBean> listAdressBean=adressManager.findAllById(contact.getIdContact());
		model.addAttribute("contactList", listContactBean);
		model.addAttribute("adressList", listAdressBean);
		
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("contactList", listContactBean);
		model.addAttribute("adressFormBean", adressFormBean);
		model.addAttribute("contactList", listContactBean);
		
		model.addAttribute("index", index);
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
	
	@RequestMapping("/resetAddContact")
	public ModelAndView resetContactAdd(ModelMap model) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewDetails");
		

		mav.addObject(model);
		return mav;
	}
	
//	@RequestMapping(value = "/getContactData", method = RequestMethod.GET)
//	public void getData(ModelMap model,
//			@ModelAttribute("contactList") List<ContactBean> listContactBean,
//			HttpServletRequest request,
//			HttpServletResponse response) throws JSONException, IOException {
//		
//	
//		String contextPath = request.getContextPath();
//		
//		JSONObject result = new JSONObject();
//	    JSONArray arrayTable = new JSONArray();
//
//	    int contactIndex = 0;
//	    for(ContactBean contactBean : listContactBean) {
//	    	JSONArray arrayLine = new JSONArray();
//	    	
//	    	String linkurl =null;
//	    	String libelle =null;
//	    	String title =null;
//	    	String classes=null;
//	    	String link =null;
//	    	
//	    	arrayLine.put("");
//	    	    
//	    	linkurl = contextPath+"";
//	    	libelle = "";
//	    	title = "";
//	    	classes = "lien iframe";
//		    	
//	    	link = FillTableElementWithJSON.generateLink(linkurl, libelle, title, classes);
//	    	arrayLine.put(link);
//	    	arrayLine.put("");
// 	    	arrayLine.put("");
// 	    	arrayLine.put("");
// 	    	arrayLine.put("");
// 	    	arrayLine.put("");
// 	    	arrayLine.put("");
//    		// Ajout de la ligne au tableau
//	    	arrayTable.put(arrayLine);
//
//	    	contactIndex++;
//	    }
//
//
//	    
//	    result.put("aaData", arrayTable);
//
//    	response.setCharacterEncoding("ISO-8859-1");
//    	response.setContentType("application/json;charset=ISO-8859-1");
//    	
//    	OutputStream os = response.getOutputStream();
//    	os.write(result.toString().getBytes());
//
//		if (os != null) {
//			os.flush();
//			os.close();
//		}
//		
//	}
	
}
