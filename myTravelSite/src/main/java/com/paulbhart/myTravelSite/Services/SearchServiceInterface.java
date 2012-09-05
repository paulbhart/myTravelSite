package com.paulbhart.myTravelSite.Services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.paulbhart.myTravelSite.Model.*;

public interface SearchServiceInterface {
	
	public ArrayList<Hotel> getHotelsByState(TwoCharState State) throws ClassNotFoundException, SQLException;
	public Hotel getHotel(int id) throws ClassNotFoundException, SQLException;
}
