package com.paulbhart.myTravelSite.Controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.annotate.JsonMethod;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import com.paulbhart.myTravelSite.Model.Hotel;
import com.paulbhart.myTravelSite.Model.TwoCharState;
import com.paulbhart.myTravelSite.Services.SearchServiceInterface;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HotelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	private SearchServiceInterface mySearchService;
	
	@Autowired
	public void setSearchService(SearchServiceInterface SearchService) {
		mySearchService = SearchService;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/Hotel/{hotelid}", method = RequestMethod.GET)
	public String getHotel(@PathVariable String hotelid,Locale locale, Model model) throws Exception {
		logger.info("Hotel Controller" + hotelid);
		
		
	    int	i = Integer.parseInt(hotelid);
		
		Hotel htl = mySearchService.getHotel(i);
		
		ObjectMapper mapper = new ObjectMapper(); 
		
		String hotel=mapper.writeValueAsString(htl);
		
		hotel = "{ \"ResultSet\": { \"firstResultPosition\": 1, \"totalResultsReturned\": 1,\"Result\": [" + hotel + "]}}";
		
		logger.info("hotel = "+ hotel + ">>>>");
		model.addAttribute("json",hotel);
		return "JsonView";
	}
	
}
