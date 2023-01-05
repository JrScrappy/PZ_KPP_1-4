package org.example.pz4.entity;

public class Color {
    private long id;
    private String color;

    public Color(long id, String color) {
        this.id = id;
        this.color = color;
    }

    public Color() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Color{" +
                "id=" + id +
                ", color='" + color + '\'' +
                '}';
    }
}
