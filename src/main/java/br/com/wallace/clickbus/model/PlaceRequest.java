package br.com.wallace.clickbus.model;

import jakarta.validation.constraints.NotBlank;

public record PlaceRequest(@NotBlank String name, @NotBlank String slug, @NotBlank String city, @NotBlank String state) {
    public PlaceRequest(Place place){
        this(place.getName(), place.getSlug(), place.getCity(), place.getState());
    }
}
