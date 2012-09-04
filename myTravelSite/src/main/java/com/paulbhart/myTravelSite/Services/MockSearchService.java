package com.paulbhart.myTravelSite.Services;


import java.util.ArrayList;

import com.paulbhart.myTravelSite.Model.Address;
import com.paulbhart.myTravelSite.Model.CostRating;
import com.paulbhart.myTravelSite.Model.ReviewRating;
import com.paulbhart.myTravelSite.Model.TwoCharState;
import com.paulbhart.myTravelSite.Model.Hotel;


public class MockSearchService implements SearchServiceInterface {
	@Override
	public ArrayList<Hotel> getHotelsByState(TwoCharState XXState) {
		ArrayList<Hotel> hotelList = new ArrayList<Hotel>(); 
		
		TwoCharState myState = XXState;
				
		Address addr1 = new Address("2222 Rich Ave", "", "Los Angles", myState, "United States", "88888");
		Hotel hotel1 = new Hotel("Crown Prince", CostRating.$$$$ , ReviewRating.FourStars, addr1);
		
		Address addr2 = new Address("2222 Boring Rd", "", "Los Gatos", myState, "United States", "88898");
		Hotel hotel2 = new Hotel("Ramada Inn", CostRating.$$, ReviewRating.OneStar, addr2);
		
		Address addr3 = new Address("2222 Anywhere Ave", "", "Houston", myState, "United States", "78888");
		Hotel hotel3 = new Hotel("Hilton", CostRating.$$$, ReviewRating.TwoStars, addr3);
		
		hotelList.add(hotel1);
		hotelList.add(hotel2);
		hotelList.add(hotel3);
		
		return hotelList;
		
	}
		
	public Hotel getHotel(int id) throws Exception {
		Address addr1 = new Address("2222 Rich Ave", "", "Los Angles", TwoCharState.CA, "United States", "88888");
		Hotel hotel1 = new Hotel("Crown Prince", CostRating.$$$$ , ReviewRating.FourStars, addr1);
		return hotel1;
	}

}
