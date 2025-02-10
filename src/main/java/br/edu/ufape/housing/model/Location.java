package br.edu.ufape.housing.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "location")
public class Location {
    
    @Id
    @SequenceGenerator(name="location_id_seq", sequenceName="location_id_seq", allocationSize=1)
    @GeneratedValue(generator="location_id_seq", strategy=GenerationType.SEQUENCE)
    @Column(name="id", updatable=false)
    private Long id;

    @Column(name="name", nullable=false, columnDefinition="TEXT")
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @Column(name="city", nullable=false, columnDefinition="TEXT")
    @NotBlank(message = "A cidade é obrigatória")
    private String city;

    @Column(name="state", nullable=false, columnDefinition="TEXT")
    @NotBlank(message = "O estado é obrigatório")
    private String state;

    @Column(name="photo", nullable=false, columnDefinition="TEXT")
    private String photo;

    @Column(name="available_units", nullable=false)
    @NotNull(message = "O número de unidades disponíveis é obrigatório")
    @Min(value = 0, message = "O número de unidades disponíveis deve ser maior que 0")
    private Integer availableUnits;

    @Column(name="wifi", nullable=false)
    @NotNull(message = "O campo wifi é obrigatório")
    private Boolean wifi;

    @Column(name="laundry", nullable=false)
    @NotNull(message = "O campo laundry é obrigatório")
    private Boolean laundry;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Location() {
    }

    public Location(Long id, String name, String city, String state, String photo, Integer availableUnits, Boolean wifi,
            Boolean laudry) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.state = state;
        this.photo = photo;
        this.availableUnits = availableUnits;
        this.wifi = wifi;
        this.laundry = laudry;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(Integer availableUnits) {
        this.availableUnits = availableUnits;
    }

    public Boolean getWifi() {
        return wifi;
    }

    public void setWifi(Boolean wifi) {
        this.wifi = wifi;
    }

    public Boolean getLaundry() {
        return laundry;
    }

    public void setLaundry(Boolean laundry) {
        this.laundry = laundry;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Location{");
        sb.append("id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", city=").append(city);
        sb.append(", state=").append(state);
        sb.append(", photo=").append(photo);
        sb.append(", availableUnits=").append(availableUnits);
        sb.append(", wifi=").append(wifi);
        sb.append(", laundry=").append(laundry);
        sb.append('}');
        return sb.toString();
    }


}