package br.com.wallace.clickbus.model;

import java.time.LocalDateTime;

public record PlaceUpdate(Long id, String name, String slug, String city, String state, LocalDateTime updatedAt) {
}
