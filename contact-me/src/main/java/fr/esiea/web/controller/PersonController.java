package fr.esiea.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.repackaged.com.google.protobuf.ServiceException;

@Controller("personController")
@SessionAttributes({"personFormBean"})
public class PersonController {

	private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@RequestMapping("/")
	public ModelAndView start(ModelMap model) throws ServiceException{
		//viewContactList
		
		ModelAndView mav = new ModelAndView("");
		return mav;
	}
}
