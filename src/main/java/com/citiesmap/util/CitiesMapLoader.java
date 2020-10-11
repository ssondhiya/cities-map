/**
 * 
 */
package com.citiesmap.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.NonNull;

/**
 * Custom File loader utility class for cities map.
 * 
 * @author ssondhiya
 *
 */
public final class CitiesMapLoader {

	private CitiesMapLoader() {
	}

	/**
	 * Load Cities map file from classpath.
	 * 
	 * @param fileName Name of the file. File must be in classpath.
	 * @return List of String[], where each entry represents one line in a file.
	 * @throws IOException
	 */
	public static List<String[]> loadCitiesMap(@NonNull final String fileName) throws IOException {
		CsvMapper mapper = new CsvMapper();
		CsvSchema bootstrapSchema = CsvSchema.emptySchema().withoutHeader();
		mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
		mapper.enable(CsvParser.Feature.TRIM_SPACES);
		File file = new ClassPathResource(fileName).getFile();
		MappingIterator<String[]> readValues = mapper.readerFor(String[].class).with(bootstrapSchema).readValues(file);
		return readValues.readAll();
	}
}
