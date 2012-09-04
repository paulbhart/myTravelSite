package com.paulbhart.myTravelSite.Services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import com.paulbhart.myTravelSite.Model.Address;
import com.paulbhart.myTravelSite.Model.CostRating;
import com.paulbhart.myTravelSite.Model.Hotel;
import com.paulbhart.myTravelSite.Model.ReviewRating;
import com.paulbhart.myTravelSite.Model.TwoCharState;

public class jdbcSearchService implements SearchServiceInterface {

	 
	  private Connection connect = null;
	  private Statement statement = null;
	  private PreparedStatement preparedStatement = null;
	  private ResultSet resultSet = null;
	    

	 
	private void setUpDB() throws Exception {
		// This will load the MySQL driver, each DB has its own driver
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB

		String url = "jdbc:mysql://localhost/test";
		connect = DriverManager.getConnection(url, "root", "ju7Vhdfe");

		// Statements allow to issue SQL queries to the database
		statement = connect.createStatement();
		// Result set get the result of the SQL query
	}
	
	private Hotel DBHoteltoObjectHotel (ResultSet resultSet) throws Exception{
		
		int myInt = resultSet.getInt("ReviewRating");
		ReviewRating rr = ReviewRating.fromInt(myInt);
		
		myInt = resultSet.getInt("CostRating");
		CostRating cr = CostRating.fromInt(myInt);
		
		String sa1 = resultSet.getString("StreetAddress1"); 
		String sa2 = resultSet.getString("StreetAddress2");
		String ci = resultSet.getString("City");
		TwoCharState st = TwoCharState.valueOf(resultSet.getString("State"));
		String co = resultSet.getString("Country");
		String zip = resultSet.getString("ZipCode");
		Address addr = new Address(sa1,sa2,ci,st,co,zip);
				
		Hotel hotel = new Hotel(resultSet.getString("Name"), cr, rr, addr,
				resultSet.getInt("Id"));
		
		return hotel;
		
	}
	public ArrayList<Hotel> getHotelsByState(TwoCharState State) throws Exception {
		
		setUpDB();
		
		String query = "select * from test.hotel, test.address where hotel.fk_address = address.id AND address.state LIKE '%" + State.toString() + "%' ORDER BY hotel.name";
		
		resultSet = statement.executeQuery(query);
		
		ArrayList<Hotel> Hotels = new ArrayList<Hotel>();
		
		while (resultSet.next()) {
			Hotels.add(DBHoteltoObjectHotel(resultSet));
		}
		
	    return Hotels;	
	}
	
	
	public Hotel getHotel(int id) throws Exception {

		setUpDB();
		// Result set get the result of the SQL query
		Integer ID = new Integer(id);
		
		String query = "select * from test.hotel, test.address where hotel.fk_address = address.id AND hotel.id = " + ID;
		
		resultSet = statement.executeQuery(query);
		resultSet.next();
		return DBHoteltoObjectHotel(resultSet);
	}

}
