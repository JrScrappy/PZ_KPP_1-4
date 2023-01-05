package org.example.pz2;

public class Transport implements Comparable<Transport>{
    private int countSeatPlaces;
    private double maxSpeed;
    private TransportType transportType;
    private String color;

    @Override
    public int compareTo(Transport o) {
        return countSeatPlaces - o.countSeatPlaces;
    }

    public Transport() {
    }

    public Transport(TransportType transportType) {
        this.transportType = transportType;
    }

    public Transport(int countSeatPlaces, double maxSpeed, TransportType transportType, String color) {
        this.countSeatPlaces = countSeatPlaces;
        this.maxSpeed = maxSpeed;
        this.transportType = transportType;
        this.color = color;
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

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "countSeatPlaces=" + countSeatPlaces +
                ", maxSpeed=" + maxSpeed +
                ", transportType=" + transportType +
                ", color='" + color + '\'' +
                '}';
    }
}
