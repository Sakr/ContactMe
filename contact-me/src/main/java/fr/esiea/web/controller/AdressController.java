package fr.esiea.web.controller;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.expression.ParseException;
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
@SessionAttributes({"adressFormBean","adressList","contactList","index","indexA","contactFormBean"})
public class AdressController {
	
	private AdressManager adressManager;
	private static final Logger logger = LoggerFactory.getLogger(AdressController.class);

	
	@RequestMapping("/addAdress")
	public ModelAndView addAdress(ModelMap model,
		@ModelAttribute("adressFormBean") AdressFormBean adressFormBean,
		@ModelAttribute("contactList") List<ContactBean> listContactBean,
		@ModelAttribute("adressList") List<AdressBean> listAdressBean,
		
		@ModelAttribute("index") int index) throws ServiceException, ParseException{
		
		
		ModelAndView mav = new ModelAndView("viewDetails");
		
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		//On recupere l'id du contact sur lequel on ajoute l'adresse
		int idContact= listContactBean.get(index).getIdContact();
		//ajout de l'adresse
		AdressBean adressBean=new AdressBean();
		adressBean.setNumberAdress(adressFormBean.getNumberAdress());
		adressBean.setStreetNameAdress(adressFormBean.getStreetNameAdress());
		adressBean.setCodeAdess(adressFormBean.getCodeAdess());
		adressBean.setCityAdress(adressFormBean.getCityAdress());
		adressBean.setShippingAdress(adressFormBean.getAdressShipping());
		adressBean.setBillingAdress(adressFormBean.getAdressBilling());
		adressBean.setIdContactAdress(idContact);
		//Enregistrement
		adressManager.createAdress(adressBean);
		
		//rechargement des données de la page avec le nouvel élément
		listAdressBean=adressManager.findAllById(idContact);
			
		model.addAttribute("adressList", listAdressBean);
		model.addAttribute("adressFormBean", adressFormBean);
		mav.addObject(model);
		return mav;
	}
	
	
	@RequestMapping("/changeAdress")
	public ModelAndView changeAdress(ModelMap model,
		@RequestParam(value = "indexA", required = true) int indexA,
		@ModelAttribute("contactFormBean") ContactFormBean contactFormBean,
		@ModelAttribute("adressList") List<AdressBean> listAdressBean) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewChangeAdress");
		
		AdressFormBean adressFormBean=new AdressFormBean();
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		AdressBean adress=adressManager.readAdress(listAdressBean.get(indexA).getIdAdress());
		adressFormBean.setNumberAdress(adress.getNumberAdress());
		adressFormBean.setStreetNameAdress(adress.getStreetNameAdress());
		adressFormBean.setCodeAdess(adress.getCodeAdess());
		adressFormBean.setCityAdress(adress.getCityAdress());
		adressFormBean.setAdressShipping(adress.getShippingAdress());
		adressFormBean.setAdressBilling(adress.getBillingAdress());
		
		model.addAttribute("adressFormBean", adressFormBean);
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("indexA", indexA);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/saveAdressChanges")
	public ModelAndView saveAdressChanges(ModelMap model,
		@ModelAttribute("adressList") List<AdressBean> listAdressBean,
		@ModelAttribute("contactFormBean") ContactFormBean contactFormBean,
		@ModelAttribute("adressFormBean") AdressFormBean adressFormBean,
		@ModelAttribute("indexA") int indexA) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewDetails");
		
		//On recupere l'id du contact sur lequel on ajoute l'adresse
		int idAdress= listAdressBean.get(indexA).getIdAdress();
		int idContact= listAdressBean.get(indexA).getIdContactAdress();
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		AdressBean adress=adressManager.readAdress(listAdressBean.get(indexA).getIdAdress());
		adress.setNumberAdress(adressFormBean.getNumberAdress());
		adress.setStreetNameAdress(adressFormBean.getStreetNameAdress());
		adress.setCodeAdess(adressFormBean.getCodeAdess());
		adress.setCityAdress(adressFormBean.getCityAdress());
		adress.setShippingAdress(adressFormBean.getAdressShipping());
		adress.setBillingAdress(adressFormBean.getAdressBilling());
		adress.setIdAdress(idAdress);
		adress.setIdContactAdress(idContact);
		//Enregistrement
		adressManager.updateAdress(adress);
		
		//On charge laliste des adresses du contact
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		listAdressBean=adressManager.findAllById(idContact);
		
		model.addAttribute("adressList", listAdressBean);
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("adressFormBean", adressFormBean);
		
		model.addAttribute("indexA", indexA);
		mav.addObject(model);
		return mav;
	}
	//
	@RequestMapping("/deleteAdress")
	public ModelAndView deleteAdress(ModelMap model,
			@ModelAttribute("adressList") List<AdressBean> listAdressBean,
			@ModelAttribute("contactFormBean") ContactFormBean contactFormBean,
			@ModelAttribute("adressFormBean") AdressFormBean adressFormBean,
			@RequestParam(value = "indexA", required = true) int indexA) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewDeleteAdress");
		
		model.addAttribute("adressList", listAdressBean);
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("adressFormBean", adressFormBean);
		
		model.addAttribute("indexA", indexA);
		mav.addObject(model);
		return mav;
	}
	
	//
	@RequestMapping("/saveDeleteAdress")
	public ModelAndView saveDeleteAdress(ModelMap model,
			@ModelAttribute("adressList") List<AdressBean> listAdressBean,
			@ModelAttribute("contactFormBean") ContactFormBean contactFormBean,
			@ModelAttribute("adressFormBean") AdressFormBean adressFormBean,
			@ModelAttribute("indexA") int indexA) throws ServiceException{
		ModelAndView mav = new ModelAndView("viewDetails");
		
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		adressManager.deleteAdress(listAdressBean.get(indexA));
		
		//
		int idContact= listAdressBean.get(indexA).getIdContactAdress();
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		
		//On charge laliste des adresses du contact
		adressManager=new AdressManager(DataStoreSingleton.getInstance());
		listAdressBean=adressManager.findAllById(idContact);
		
		model.addAttribute("adressList", listAdressBean);
		model.addAttribute("contactFormBean", contactFormBean);
		model.addAttribute("adressFormBean", adressFormBean);
		model.addAttribute("indexA", indexA);
		mav.addObject(model);
		return mav;
	}
	
	@RequestMapping("/resetDeleteAdress")
	public ModelAndView resetDeleteAdress(ModelMap model) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewDetails");
		

		mav.addObject(model);
		return mav;
	}
	@RequestMapping("/resetAdressChanges")
	public ModelAndView resetAdressChanges(ModelMap model) throws ServiceException{
		
		ModelAndView mav = new ModelAndView("viewDetails");
		

		mav.addObject(model);
		return mav;
	}
}
