package com.citiesmap.util;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * Validate city name.
 * 
 * @author ssondhiya
 *
 */
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {})
@NotBlank(message = "Can not be null or empty.")
@Pattern(regexp = "[a-zA-Z]+(?:[\\s-][a-zA-Z]+)*$", message = "City name is invalid")
@Documented
public @interface CityName {
	String message() default "Invalid value";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
