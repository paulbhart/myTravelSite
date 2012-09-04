package com.paulbhart.myTravelSite.Model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonAutoDetect.Visibility;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonAutoDetect;
import org.codehaus.jackson.annotate.JsonIgnore;


@JsonAutoDetect(fieldVisibility=Visibility.ANY,
getterVisibility=Visibility.NONE, isGetterVisibility=Visibility.NONE)
public class Address  implements Serializable {
	//TODO refactor properties to use _ in front of name in all classes (except enums)
	private static final long serialVersionUID = 1L;
	
	@JsonProperty
	private String StreetAddress1;
	@JsonProperty
	private String StreetAddress2;
	@JsonProperty
	private String City;
	@JsonProperty
	private TwoCharState State;
	@JsonProperty
	private String Country;
	@JsonProperty
	private String ZipCode;
	
	// PUBLIC getters
	@JsonIgnore
	public String getStreetAddress1() {
		return StreetAddress1;
	}
	@JsonIgnore
	public String getStreetAddress2() {
		return StreetAddress2;
	}
	@JsonIgnore
	public String getCity() {
		return City;
	}
	@JsonIgnore
	public TwoCharState getState() {
		return State;
	}
	@JsonIgnore
	public String getCountry() {
		return Country;
	}
	@JsonIgnore
	public String getZipCode() {
		return ZipCode;
	}

	@JsonIgnore
	public Address(String StreetAddr1, String StreetAddr2, String theCity, TwoCharState theState, String theCountry, String theZipCode) {
		if (StreetAddr1.isEmpty())
			throw new IllegalArgumentException("StreetAddress1 cannot be null in Address constructor");
		   
		StreetAddress1 = new String(StreetAddr1);
		if (StreetAddr2 == null)
			StreetAddr2 = ""; 
		StreetAddress2 = new String (StreetAddr2);
		City = new String(theCity);
		State = theState;
		Country = new String(theCountry);
		ZipCode = new String(theZipCode);
		
		
	}

}
