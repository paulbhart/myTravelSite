package com.paulbhart.myTravelSite.Controllers;


import java.util.Locale;

import javax.servlet.http.HttpServletRequest;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;



/**
 * Handles requests for the application home page.
 */
@Controller
public class testScriptsController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
		
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/testScripts", method = RequestMethod.GET)
	public String getHotel(Locale locale, Model model, HttpServletRequest HttpServletRequest) throws Exception {
		logger.info("testScripts Controller" );
		
		
	    
		return "testScripts";
	}
	
}

