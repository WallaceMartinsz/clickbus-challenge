package br.com.wallace.clickbus.model;

import java.time.LocalDateTime;

public record PlaceResponse(Long id, String name, String slug, String city, String state, LocalDateTime createdAt,LocalDateTime updatedAt) {
    public PlaceResponse(Place place){
        this(place.getId(), place.getName(), place.getSlug(), place.getCity(), place.getState(), place.getCreatedAt(), place.getUpdatedAt());
    }
}
