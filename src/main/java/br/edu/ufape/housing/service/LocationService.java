package br.edu.ufape.housing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.edu.ufape.housing.dto.LocationDTO;
import br.edu.ufape.housing.model.Location;
import br.edu.ufape.housing.repository.LocationRepository;

@Service
public class LocationService {
    
    @Autowired
    private LocationRepository locationRepository;

    public Location createLocation(LocationDTO locationDTO) {
        Location entity = new Location();
        this.updateLocationProperties(locationDTO, entity); 
        this.locationRepository.save(entity);
        return entity;
    }
    
    public Location updateLocation(Long idLocation, LocationDTO locationDTO) {
        Location entity = locationRepository.findById(idLocation)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
           "Localização não encontrada!"));

        this.updateLocationProperties(locationDTO, entity);
        locationRepository.save(entity);
        return entity;
    }

    public Location getLocationDetails(Long idLocation) {
        return this.locationRepository.findById(idLocation)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, 
        "Localização não encontrada!"));
    }

    public void deleteLocation(Long idLocation) {
        if (idLocation == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O id da localização é obrigatório!");
        }
        Location entity = locationRepository.findById(idLocation)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Localização não encontrada!"));

        locationRepository.delete(entity);
    }

    public List<Location> findByName(String name) {
        return locationRepository.findByNameIgnoreCase(name);
    }

    public List<Location> findByCity(String city) {
        return locationRepository.findByCityIgnoreCase(city);
    }

    public List<Location> findByAvailableUnitsRange(Integer minUnits, Integer maxUnits) {
        return locationRepository.findByAvailableUnitsRange(minUnits, maxUnits);
    }

    public Location findByID(Long idLocation) {
        return locationRepository.findById(idLocation)
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Localização não encontrada!"));
    }

    public Location toEntity(LocationDTO locationDTO) {
        Location location = new Location();
        updateLocationProperties(locationDTO, location);
        return location;
    }

    private void updateLocationProperties(LocationDTO locationDTO, Location entity) {
        entity.setName(locationDTO.getName());
        entity.setCity(locationDTO.getCity());
        entity.setState(locationDTO.getState());
        entity.setPhoto(locationDTO.getPhoto());
        entity.setAvailableUnits(locationDTO.getAvailableUnits());
        entity.setWifi(locationDTO.getWifi());
        entity.setLaundry(locationDTO.getLaundry());
    }
}
