package com.paulbhart.myTravelSite.Controllers;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;

import org.springframework.ui.Model;

import com.paulbhart.myTravelSite.Model.CostRating;
import com.paulbhart.myTravelSite.Model.ReturnResultsJson;
import com.paulbhart.myTravelSite.Model.Hotel;
import com.paulbhart.myTravelSite.Model.ReviewRating;
import com.paulbhart.myTravelSite.Model.TwoCharState;
import com.paulbhart.myTravelSite.Services.MockSearchService;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import com.paulbhart.myTravelSite.Services.SearchServiceInterface;
import static org.junit.Assert.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import com.paulbhart.myTravelSite.Model.ReturnResultsJson;

public class testContollers {

    
     HotelController controller;
     SearchServiceInterface ss;
     
    @Before
    public void setUp() throws Exception {
	controller = new HotelController();
	ss = new MockSearchService(); 
	controller.setSearchService(ss);
	    }

    @Test
    @SuppressWarnings("unchecked")
    public void test() throws Exception {
	
	String HotelID = "1";
	ExtendedModelMap model = new ExtendedModelMap();
	Locale locale = new Locale("US");
	assertEquals("JsonView",controller.getHotel(HotelID,locale, (Model) model));
	
	String json = (String) model.get("json");
	
	assertNotNull(json);
	
	ObjectMapper mapper = new ObjectMapper();
	Map<String,Object>  map = mapper.readValue(json,Map.class);
	
	assertNotNull(map);
	
	Map<String,Object> rs = (Map<String, Object>) map.get("ResultSet");
	ArrayList<Map<String,String>> result = (ArrayList<Map<String,String>>) rs.get("Result");
	
	assertEquals(rs.get("totalResultsReturned"),1);
	
	Map<String, String> hotel = result.get(0);
	
	assertEquals(hotel.get("Name"), "Crown Prince");
	assertEquals(hotel.get("CostRate"),"$$$$");
//	assertEquals(ht.getReviewRate(),ReviewRating.FourStars);
//	assertEquals(ht.getAddress().getCity(),"Los Angles");
//	assertEquals(ht.getAddress().getStreetAddress1(),"2222 Rich Ave");
//	assertEquals(ht.getAddress().getCountry(),"United States");
//	assertEquals(ht.getAddress().getZipCode(),"88888");
//	assertEquals(ht.getAddress().getState(),TwoCharState.CA);
	
	
	
	
	
	
    }

}
