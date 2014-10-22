package fr.esiea.web.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.appengine.repackaged.com.google.protobuf.ServiceException;

import fr.esiea.web.bean.ContactFormBean;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Locale locale) {
		logger.info("Start Contact Me");
		return "index";
	}
	
	@RequestMapping("/back")
	public ModelAndView back(ModelMap model) throws ServiceException{
		//viewContactList
		
		HttpServletRequest request=((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		System.out.println(request.getServletPath()); 
		String scheme = request.getScheme()+"://";             // http
		String host = request.getHeader("host");     // localhost:8888
		String baseName=scheme+host;
		String referrer = request.getHeader("referer");//http://localhost:8888/contacts
		String lastView=referrer.substring(baseName.length(),referrer.length() );
		ModelAndView mav=null;
		if(lastView.indexOf("/reset")!=-1 ||lastView.indexOf("/contacts")!=-1 || lastView.indexOf("/back")!=-1 || lastView.indexOf("/deleteContact")!=-1 ||lastView.indexOf("/addContact")!=-1||lastView.indexOf("/saveChanges")!=-1){
			mav = new ModelAndView("index");
		}else if(lastView.indexOf("/consult")!=-1 || lastView.indexOf("/saveDeleteAdress")!=-1 || lastView.indexOf("/saveAdressChanges")!=-1 ){
			ContactFormBean contactFormBean=new ContactFormBean();
			model.addAttribute("contactFormBean", contactFormBean);
			mav = new ModelAndView("viewContactList");
		}
		mav.addObject(model);
		return mav;
	}
	
	
}
