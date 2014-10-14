package fr.esiea.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller("deleteContactController")
@SessionAttributes({"contactFormBean"})
public class DeleteContactController {
	
	
	private static final Logger logger = LoggerFactory.getLogger(DeleteContactController.class);
	
	
}
