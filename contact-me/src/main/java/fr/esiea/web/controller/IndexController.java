package fr.esiea.web.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.repackaged.com.google.protobuf.ServiceException;

import fr.esiea.web.bean.ContactBean;
import fr.esiea.web.bean.ContactFormBean;
import fr.esiea.web.model.DataStoreSingleton;
import fr.esiea.web.model.InitDataTest;
import fr.esiea.web.service.impl.ContactManager;


@Controller("index")
@SessionAttributes({"contactFormBean","contactList"})
public class IndexController {

	private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
	private ContactManager contactManager;
	@RequestMapping("/startIndex")
	public ModelAndView start(ModelMap model) throws ServiceException{
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping("/contacts")
	public ModelAndView listControllerLaunch(ModelMap model) throws ServiceException, ParseException{
		InitDataTest.run();
		ModelAndView mav = new ModelAndView("viewContactList");
		ContactFormBean contactFormBean=new ContactFormBean();
		model.addAttribute("contactFormBean", contactFormBean);
		contactManager=new ContactManager(DataStoreSingleton.getInstance());
		List<ContactBean> listContactBean=contactManager.findAll();
			
		model.addAttribute("contactList", listContactBean);
		mav.addObject(model);
		return mav;
	}
	
	
}
