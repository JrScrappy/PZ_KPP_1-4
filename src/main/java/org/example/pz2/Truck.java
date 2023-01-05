package org.example.pz2;

public class Truck extends GroundTransport {
    private double loadCapacity;

    public Truck(int countSeatPlaces, double maxSpeed, String color, int countOfWheels, double volumeOfFuelTank, double loadCapacity) {
        super(countSeatPlaces, maxSpeed, color, countOfWheels, volumeOfFuelTank);
        this.loadCapacity = loadCapacity;
    }

    public Truck(int countOfWheels, double volumeOfFuelTank, double loadCapacity) {
        super(countOfWheels, volumeOfFuelTank);
        this.loadCapacity = loadCapacity;
    }

    public Truck() {
    }

    @Override
    public String toString() {
        return "Truck{" +
                "loadCapacity=" + loadCapacity +
                "} " + super.toString();
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }
}
