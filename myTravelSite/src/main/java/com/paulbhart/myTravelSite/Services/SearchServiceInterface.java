package com.paulbhart.myTravelSite.Services;

import java.util.ArrayList;

import com.paulbhart.myTravelSite.Model.*;

public interface SearchServiceInterface {
	
	public ArrayList<Hotel> getHotelsByState(TwoCharState State) throws Exception;
	public Hotel getHotel(int id) throws Exception;
}
