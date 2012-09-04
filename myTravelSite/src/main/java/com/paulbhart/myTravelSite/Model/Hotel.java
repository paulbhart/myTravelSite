package com.paulbhart.myTravelSite.Model;

import java.io.Serializable;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;


@JsonAutoDetect(fieldVisibility=Visibility.ANY,
getterVisibility=Visibility.NONE, isGetterVisibility=Visibility.NONE)
public class Hotel implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@JsonProperty
	private String Name; 
	@JsonProperty
	private CostRating CostRate;
	@JsonProperty
	private ReviewRating ReviewRate;
	@JsonProperty
	private Address Address;
	@JsonProperty
	private int Id;
		
	// All hotels must have a name thus no empty constructor
	@JsonIgnore
	public Hotel (String name, CostRating CR, ReviewRating RR, Address addr) {
		Name = new String(name);
		CostRate = CR;
		ReviewRate = RR;
		Address = addr;
	}
	@JsonIgnore
	public Hotel (String name, CostRating CR, ReviewRating RR, Address addr, int id) {
		Name = new String(name);
		CostRate = CR;
		ReviewRate = RR;
		Address = addr;
		Id = id;
	}


	@JsonIgnore
	public String getName() {
		return Name;
	}
	@JsonIgnore
	public CostRating getCostRate() {
		return CostRate;
	}
	@JsonIgnore
	public ReviewRating getReviewRate() {
		return ReviewRate;
	}
	@JsonIgnore
	public Address getAddress() {
		return Address;
	}
	
	@JsonIgnore
	public int getId() {
		return Id;
	}
	
	

}
