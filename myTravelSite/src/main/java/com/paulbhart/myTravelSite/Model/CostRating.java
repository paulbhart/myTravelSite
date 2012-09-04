package com.paulbhart.myTravelSite.Model;

public enum CostRating { $, $$, $$$, $$$$, $$$$$;

public static CostRating fromInt (int rating) {

	if (rating > 5 || rating < 1 )
		throw new IllegalArgumentException();
	
	switch(rating) {
	
	case 1:
		return CostRating.$;
	case 2:
		return CostRating.$$;
	case 3:
		return CostRating.$$$;
	case 4:
		return CostRating.$$$$;
	case 5:
		return CostRating.$$$$$;
	
	}
	return CostRating.$; // Not reachable, used to avoid eclipse errors
}
}
