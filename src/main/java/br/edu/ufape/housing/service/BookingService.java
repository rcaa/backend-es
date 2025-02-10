package br.edu.ufape.housing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.housing.dto.BookingDTO;
import br.edu.ufape.housing.model.Booking;
import br.edu.ufape.housing.repository.BookingRepository;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired 
    private LocationService locationService;

    public Booking createBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking();
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setLocation(locationService.findByID(bookingDTO.getIdLocation())); 
        return bookingRepository.save(booking);
    }
}
