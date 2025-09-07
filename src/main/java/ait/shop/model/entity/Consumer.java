package ait.shop.model.entity;

import java.util.Objects;

public class Consumer {

    private Long id;
    private String name;
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
        if (!(o instanceof Consumer consumer)) return false;
        return active == consumer.active && Objects.equals(id, consumer.id) && Objects.equals(name, consumer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, active);
    }
}
