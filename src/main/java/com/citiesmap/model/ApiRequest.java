package com.citiesmap.model;

import com.citiesmap.util.CityName;

import lombok.Data;

/**
 * Model class for HTTP GET request.
 * 
 * @author ssondhiya
 *
 */
@Data
public class ApiRequest {
	@CityName
	private String origin;
	@CityName
	private String destination;
}
