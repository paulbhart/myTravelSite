package com.paulbhart.myTravelSite.Model;

public enum ReviewRating { OneStar, TwoStars, ThreeStars, FourStars, FiveStars;

  public static ReviewRating fromInt (int rating) {

	if (rating > 5 || rating < 1 )
		throw new IllegalArgumentException();
	
	switch(rating) {
	
	case 1:
		return ReviewRating.OneStar;
	case 2:
		return ReviewRating.TwoStars;
	case 3:
		return ReviewRating.ThreeStars;
	case 4:
		return ReviewRating.FourStars;
	case 5:
		return ReviewRating.FiveStars;
	
	}
	return ReviewRating.OneStar; // Not reachable, used to avoid eclipse errors

}	

}
