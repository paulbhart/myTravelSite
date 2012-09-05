package com.paulbhart.myTravelSite.Services;

import java.sql.Connection;
import java.sql.DriverManager;
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

    private Connection _connect = null;
    private Statement _statement = null;
    private ResultSet _resultSet = null;

    private void setUpDBQuery() throws ClassNotFoundException, SQLException {
	// This will load the MySQL driver, each DB has its own driver
	Class.forName("com.mysql.jdbc.Driver");
	// Setup the connection with the DB

	// TODO move these to variables specified in the application.XML file
	String url = "jdbc:mysql://localhost/test";
	_connect = DriverManager.getConnection(url, "root", "ju7Vhdfe");

	// Statements allow to issue SQL queries to the database
	_statement = _connect.createStatement();
	// Result set get the result of the SQL query
    }

    private Hotel DBHoteltoObjectHotel(ResultSet resultSet) throws SQLException {

	// If any of the conversations fail the exception will be thrown and
	// Hotel won't be set.
	Hotel hotel = null;

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
	Address addr = new Address(sa1, sa2, ci, st, co, zip);
	String name = resultSet.getString("Name");
	int id = resultSet.getInt("Id");
	hotel = new Hotel(name, cr, rr, addr, id);

	return hotel;

    }

    public ArrayList<Hotel> getHotelsByState(TwoCharState State)
	    throws ClassNotFoundException, SQLException {

	ArrayList<Hotel> Hotels = new ArrayList<Hotel>();

	setUpDBQuery();

	String query = "select * from test.hotel, test.address where hotel.fk_address = address.id AND address.state LIKE '%"
		+ State.toString() + "%' ORDER BY hotel.name";
	_resultSet = _statement.executeQuery(query);

	while (_resultSet.next()) {
	    Hotels.add(DBHoteltoObjectHotel(_resultSet));
	}

	return Hotels;
    }

    public Hotel getHotel(int id) throws ClassNotFoundException, SQLException {

	Hotel hotel = null;

	setUpDBQuery();
	// Result set get the result of the SQL query
	Integer ID = new Integer(id);

	String query = "select * from test.hotel, test.address where hotel.fk_address = address.id AND hotel.id = "
		+ ID;

	_resultSet = _statement.executeQuery(query);
	_resultSet.next();
	hotel = DBHoteltoObjectHotel(_resultSet);

	return hotel;
    }

}
