package com.paulbhart.myTravelSite.Controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import com.paulbhart.myTravelSite.Model.Hotel;
import com.paulbhart.myTravelSite.Services.SearchServiceInterface;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HotelController {

//    private static final Logger _Logger = LoggerFactory
//	    .getLogger(HotelController.class);
  
    private SearchServiceInterface _mySearchService;

    @Autowired
    public void setSearchService(SearchServiceInterface SearchService) {
	_mySearchService = SearchService;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/Hotel/{hotelid}", method = RequestMethod.GET)
    public String getHotel(@PathVariable String hotelid, Locale locale,
	    Model model) {
	
	int i;

	try {
	    i = Integer.parseInt(hotelid);
	} catch (NumberFormatException e) {
	    model.addAttribute("errorMsg", "Illegal Argument: " + hotelid
		    + " is an invalid number");
	    return "error";
	}
	
	Hotel htl = null;
	
	try {
	    htl = _mySearchService.getHotel(i);
	} catch (SQLException e) {
	    model.addAttribute("errorMsg", "SQL Exception: Contact your DB Admin for assistance" );
	    return "error";
	} catch (ClassNotFoundException e) {
	    model.addAttribute("errorMsg", "Class not found exception: Contact your DB Admin for assistance" );
	    return "error";
	}
	
	ObjectMapper mapper = new ObjectMapper();
	String json = "";
	
	try {
	    json = mapper.writeValueAsString(htl);
	} catch (JsonMappingException e) {
	    model.addAttribute("errorMsg", "Error converting DB data to JSON data" );
	    return "error";
	} catch (JsonGenerationException e) {
	    model.addAttribute("errorMsg", "Error converting DB data to JSON data" );
	    return "error";
	} catch (IOException e) {
	    model.addAttribute("errorMsg", "Error converting DB data to JSON data" );
	    return "error";
	}
          
	json = "{ \"ResultSet\": { \"firstResultPosition\": 1, \"totalResultsReturned\": 1,\"Result\": ["
		+ json + "]}}";

	model.addAttribute("json", json);
	return "JsonView";
    }

}
