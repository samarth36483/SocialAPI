package com.example.Sambook.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@RequestMapping(value = "/locations")
	public List<Location> getAllLocations(){
		
		return locationService.getAllLocations();
	}
	
	@RequestMapping(value = "/locations/{id}")
	public Location getLocation(@PathVariable String id) {
		return locationService.getLocation(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value = "/locations")
	public void addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = "/locations/{id}")
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/locations/{id}")
	public void updateLocation(@RequestBody Location location, @PathVariable String id) {
		locationService.updateLocation(id, location);
	}
}
