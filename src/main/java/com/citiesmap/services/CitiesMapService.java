package com.citiesmap.services;

import lombok.NonNull;

/**
 * Service class to perform operation on Cities Map.
 * 
 * @author ssondhiya
 */
public interface CitiesMapService {
	/**
	 * Check if two cities are connected or not. Two cities are considered connected
	 * if there is a path exist between them.
	 * 
	 * @param origin      Name of the origin city.
	 * @param destination Name of the destination city.
	 * @return true, if given cities are connected else returns no.
	 */
	boolean isCityConnected(@NonNull final String origin, @NonNull final String destination);

}