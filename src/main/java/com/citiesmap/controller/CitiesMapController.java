package com.citiesmap.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.citiesmap.model.ApiRequest;
import com.citiesmap.services.CitiesMapService;

/**
 * REST Controller that provides cities map endpoints to work with.
 * 
 * @author ssondhiya
 *
 */
@RestController
public final class CitiesMapController {
	/**
	 * Service to perform operations on C=cities map
	 */
	private CitiesMapService service;

	/**
	 * Create a new instance of this controller.
	 * 
	 * @param service instance of {@link CitiesMapService}.
	 */
	public CitiesMapController(final CitiesMapService service) {
		this.service = service;
	}

	/**
	 * REST endpoint for checking two cities are connected.
	 * 
	 * @param request See {@link ApiRequest}.
	 * @return yes, if given cities are connected, else no.
	 */
	@GetMapping("/connected")
	public String checkConnection(@Valid final ApiRequest request) {
		return service.isCityConnected(request.getOrigin().toLowerCase(), request.getDestination().toLowerCase())
				? "yes"
				: "no";
	}

	/**
	 * Error handler for handling validation errors. This method will be called by
	 * Spring internally.
	 * 
	 * @param ex exception
	 * @return error response.
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BindException.class)
	public Map<String, String> handleValidationExceptions(BindException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});

		return errors;
	}
}
