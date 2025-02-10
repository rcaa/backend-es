package br.edu.ufape.housing.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;

public class BookingDTO {
    
    @NotNull(message = "A localização é obrigatória")
    private Long idLocation;

    @NotNull(message = "A data de check-in é obrigatória")
    private LocalDate checkInDate;

    @NotNull(message = "A data de check-out é obrigatória")
    private LocalDate checkOutDate;

    public BookingDTO() {
    }

    public BookingDTO(@NotNull Long idLocation, @NotNull LocalDate checkInDate, 
     @NotNull LocalDate checkOutDate) {
        this.idLocation = idLocation;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public Long getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Long idLocation) {
        this.idLocation = idLocation;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }
}
