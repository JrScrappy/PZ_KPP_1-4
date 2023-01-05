package org.example.pz4.entity;



public class Transport{
    private long id;
    private int countSeatPlaces;
    private double maxSpeed;
    private double loadCapacity;
    private String transportType;
    private String color;

    public Transport() {
    }

    public Transport(long id, int countSeatPlaces, double maxSpeed, String transportType, String color, double loadCapacity) {
        this.id = id;
        this.countSeatPlaces = countSeatPlaces;
        this.maxSpeed = maxSpeed;
        this.transportType = transportType;
        this.color = color;
        this.loadCapacity = loadCapacity;
    }

    public Transport(int countSeatPlaces, double maxSpeed, String transportType, String color ,double loadCapacity) {
        this.countSeatPlaces = countSeatPlaces;
        this.maxSpeed = maxSpeed;
        this.transportType = transportType;
        this.color = color;
        this.loadCapacity = loadCapacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCountSeatPlaces() {
        return countSeatPlaces;
    }

    public void setCountSeatPlaces(int countSeatPlaces) {
        this.countSeatPlaces = countSeatPlaces;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getTransportType() {
        return transportType;
    }

    public void setTransportType(String transportType) {
        this.transportType = transportType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "id=" + id +
                ", countSeatPlaces=" + countSeatPlaces +
                ", maxSpeed=" + maxSpeed +
                ", loadCapacity=" + loadCapacity +
                ", transportType='" + transportType + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
