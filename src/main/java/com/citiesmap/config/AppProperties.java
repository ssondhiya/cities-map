package com.citiesmap.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * This class holds all the properties that start with app.props. See
 * application.properties file.
 * 
 * @author ssondhiya
 *
 */
@EnableConfigurationProperties
@ConfigurationProperties(ignoreUnknownFields = false, prefix = "app.props")
@Component
@Getter
@Setter
public class AppProperties {
	/**
	 * Source file name for loading Cities Map.
	 */
	private String citiesMapFileName;
}
