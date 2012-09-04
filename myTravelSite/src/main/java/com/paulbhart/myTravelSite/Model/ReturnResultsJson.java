package com.paulbhart.myTravelSite.Model;

import java.util.ArrayList;

import com.paulbhart.myTravelSite.Model.Hotel;

public class ReturnResultsJson {


    int firstResultPosition;
    int totalResultsReturned;
    ArrayList<Hotel> Result;
    
    public int getFirstResultPosition() {
	return firstResultPosition;
    }
    public void setFirstResultPosition(int firstResultPosition) {
        this.firstResultPosition = firstResultPosition;
    }
    public int getTotalResultsReturned() {
        return totalResultsReturned;
    }
    public void setTotalResultsReturned(int totalResultsReturned) {
        this.totalResultsReturned = totalResultsReturned;
    }
    public ArrayList<Hotel> getResult() {
        return Result;
    }
    public void setResult(ArrayList<Hotel> result) {
        Result = result;
    }
    
 

}
