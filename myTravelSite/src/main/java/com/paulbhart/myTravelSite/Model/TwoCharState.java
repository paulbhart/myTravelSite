package com.paulbhart.myTravelSite.Model;

public enum TwoCharState { CA, TX, WA, NJ, NY, MI, MN;

	
	public static TwoCharState toEnum(String st) throws Exception {
	
		for (TwoCharState state : TwoCharState.values())
		{			
			if (state.toString().equals(st) )
					return state;
		}
		// didn't find a match, must be an illegal argument (i.e. not represented by the enum type)
		throw new IllegalArgumentException();
	}
}
