package br.edu.ufape.housing.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @SequenceGenerator(name="location_id_seq", sequenceName="location_id_seq", allocationSize=1)
    @GeneratedValue(generator="location_id_seq", strategy=GenerationType.SEQUENCE)
    @Column(name="id", updatable=false)
    private Long idBooking;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    @NotNull(message = "A localização é obrigatória")
    private Location location;

    @Column(nullable = false)
    @NotNull(message = "A data de check-in é obrigatória")
    private LocalDate checkInDate;

    @Column(nullable = false)
    @NotNull(message = "A data de check-out é obrigatória")
    private LocalDate checkOutDate;

    public Booking() {
    }

    public Booking(Long idBooking, LocalDate checkInDate, LocalDate checkOutDate, Location location) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.idBooking = idBooking;
        this.location = location;
    }

    public Long getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(Long idBooking) {
        this.idBooking = idBooking;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    @Override
    public String toString() {
        return "Booking [idBooking=" + idBooking + ", location=" + location + ", checkInDate=" + checkInDate
                + ", checkOutDate=" + checkOutDate + "]";
    }
}
