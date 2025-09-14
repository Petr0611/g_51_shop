package ait.shop.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Objects;


@Schema(description = "DTO for Consumer")
public class ConsumerDTO {

    @Schema(description = "Consumer unique identifier", example = "777", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Schema(description = "Consumer name", example = "User")
    private String name;

    @Schema(description = "Id consumer available", accessMode = Schema.AccessMode.READ_ONLY)
    private boolean active;

    @Override
    public String toString() {
        return String.format("Consumer: id - %d, name - %s, active - %s",
                id, name, active ? "yes" : "no");
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

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ConsumerDTO consumer)) return false;
        return active == consumer.active && Objects.equals(id, consumer.id) && Objects.equals(name, consumer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }
}
