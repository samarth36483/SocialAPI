package com.example.Sambook.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	Location location_1 = new Location("36", "Beawar");
	Location location_2 = new Location("01", "Delhi");
	
	private List<Location> locations = new ArrayList<>(Arrays.asList(location_1, location_2));
	
	public List<Location> getAllLocations(){
		return locations;
	}
	
	public Location getLocation(String id) {
		Location location = locations.stream()
				.filter(t -> id.equals(t.getId()))
				.findFirst()
				.orElse(null);
		
		return location;
	}
	
	public void addLocation(Location location) {
		locations.add(location);
	}
	
	public void deleteLocation(String id) {
		locations.removeIf(t -> t.getId().equals(id));
	}
	
	public void updateLocation(String id, Location location) {
		for(int i=0; i<locations.size(); i++) {
			Location l = locations.get(i);
			if(l.getId().equals(id)) {
				locations.set(i, location);
			}
		}
	}
}
