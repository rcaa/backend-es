package br.edu.ufape.housing.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.housing.dto.LocationDTO;
import br.edu.ufape.housing.model.Location;
import br.edu.ufape.housing.service.LocationService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    
    @GetMapping("/get/{idLocation}")
    public Location getLocationDetails(@PathVariable Long idLocation) {
        return locationService.getLocationDetails(idLocation);
    }

    @PostMapping("/create")
    public ResponseEntity<Location> createLocation(@Valid @RequestBody LocationDTO locationDTO) {
        Location savedLocation = locationService.createLocation(locationDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedLocation);
    }

    @PutMapping("/update/{idLocation}")
    public ResponseEntity<Location> updateLocation(@PathVariable Long idLocation, 
     @Valid @RequestBody LocationDTO locationDTO) {
        Location updatedLocation = locationService.updateLocation(idLocation, locationDTO);
        return ResponseEntity.status(HttpStatus.OK).body(updatedLocation);
    }

    @DeleteMapping("/delete/{idLocation}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long idLocation) {
        locationService.deleteLocation(idLocation);
        return ResponseEntity.status(HttpStatus.OK).body("Localização deletada com sucesso!");
    }

    @GetMapping("/search")
    public List<Location> searchLocation(@RequestParam(required = false) String name, 
        @RequestParam(required = false) String city) {
    
        if (name != null) {
            return locationService.findByName(name);
        } else if (city != null) {
            return locationService.findByCity(city);
        }

        return Collections.emptyList();
    }

    @GetMapping("/search/available-units") 
    public List<Location> searchLocationByAvailableUnits(@RequestParam Integer minUnits, 
        @RequestParam Integer maxUnits) {
        return locationService.findByAvailableUnitsRange(minUnits, maxUnits);
    }
}