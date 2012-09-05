package com.paulbhart.myTravelSite.Controllers;

import com.paulbhart.myTravelSite.Model.Hotel;
import com.paulbhart.myTravelSite.Model.TwoCharState;
import com.paulbhart.myTravelSite.Services.SearchServiceInterface;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ListController {

    private static final Logger logger = LoggerFactory
	    .getLogger(HotelController.class);
    private SearchServiceInterface mySearchService;

    @Autowired
    public void setSearchService(SearchServiceInterface SearchService) {
	mySearchService = SearchService;
    }

    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/Hotels/State/{state}", method = RequestMethod.GET)
    public String getHotelsbyState(@PathVariable String state, Locale locale,
	    Model model, HttpServletRequest HttpServletRequest,
	    @RequestParam(value = "format") String format) throws Exception {
//	logger.info("Hotels Controller /State" + state);

	ArrayList<Hotel> htls = mySearchService.getHotelsByState(TwoCharState
		.toEnum(state));

	ObjectMapper mapper = new ObjectMapper();

	String hotels = mapper.writeValueAsString(htls);

	hotels = "{ \"ResultSet\": { \"firstResultPosition\": 1, \"totalResultsReturned\": "
		+ htls.size() + ", \"Result\": " + hotels + "}}";
	model.addAttribute("json", hotels);

	if (format.equals("json")) {
	    return "JsonView";
	} else
	    // Default is HTML{
	    return "SimpleTableView";
    }
}