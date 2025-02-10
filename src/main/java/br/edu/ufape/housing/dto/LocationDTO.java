package br.edu.ufape.housing.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LocationDTO {
    
    @NotBlank(message = "O nome é obrigatório")
    private String name;

    @NotBlank(message = "A cidade é obrigatória")
    private String city;

    @NotBlank(message = "O estado é obrigatório")
    private String state;

    private String photo;

    @NotNull
    @Min(value = 0, message = "O número de unidades disponíveis deve ser maior que 0")
    private Integer availableUnits;

    @NotNull(message = "O campo wifi é obrigatório")
    private Boolean wifi;

    @NotNull(message = "O campo laundry é obrigatório")
    private Boolean laundry;

    public LocationDTO(@NotBlank String name, @NotBlank String city, @NotBlank String state, String photo,
            @NotNull Integer availableUnits, @NotNull Boolean wifi, @NotNull Boolean laundry) {
        this.name = name;
        this.city = city;
        this.state = state;
        this.photo = photo;
        this.availableUnits = availableUnits;
        this.wifi = wifi;
        this.laundry = laundry;
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
}