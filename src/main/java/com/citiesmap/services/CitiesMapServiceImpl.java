package com.citiesmap.services;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.citiesmap.config.AppProperties;
import com.citiesmap.domain.Graph;
import com.citiesmap.util.CitiesMapLoader;

import lombok.NonNull;

@Service
public final class CitiesMapServiceImpl implements CitiesMapService {
	private Graph<String> citiesGraph;

	private AppProperties appProps;

	public CitiesMapServiceImpl(AppProperties appProps) {
		this.appProps = appProps;
	}

	@PostConstruct
	public void init() throws IOException {
		List<String[]> adjCities = CitiesMapLoader.loadCitiesMap(appProps.getCitiesMapFileName());
		citiesGraph = new Graph<>();
		adjCities.forEach(edge->{
			if (edge.length == 2) {
				String city1 = edge[0].toLowerCase();
				String city2 = edge[1].toLowerCase();
				citiesGraph.addIfAbsent(city1);
				citiesGraph.addIfAbsent(city2);
				citiesGraph.addUndirectedEdge(city1, city2);
			}
		});
		
		System.out.println(citiesGraph);
	}

	@Override
	public boolean isCityConnected(@NonNull final String origin, @NonNull final String destination) {
		return citiesGraph.isConnected(origin, destination);
	}

}

