package org.example.pz2;

public class GroundTransport extends Transport {
    private int countOfWheels;
    private double volumeOfFuelTank;


    public GroundTransport(int countOfWheels, double volumeOfFuelTank) {
        super(TransportType.GROUND);
        this.countOfWheels = countOfWheels;
        this.volumeOfFuelTank = volumeOfFuelTank;
    }

    public GroundTransport(int countSeatPlaces, double maxSpeed, String color, int countOfWheels, double volumeOfFuelTank) {
        super(countSeatPlaces, maxSpeed, TransportType.GROUND, color);
        this.countOfWheels = countOfWheels;
        this.volumeOfFuelTank = volumeOfFuelTank;
    }

    public GroundTransport() {
        super(TransportType.GROUND);
    }

    public int getCountOfWheels() {
        return countOfWheels;
    }

    public void setCountOfWheels(int countOfWheels) {
        this.countOfWheels = countOfWheels;
    }

    public double getVolumeOfFuelTank() {
        return volumeOfFuelTank;
    }

    public void setVolumeOfFuelTank(double volumeOfFuelTank) {
        this.volumeOfFuelTank = volumeOfFuelTank;
    }

    @Override
    public String toString() {
        return "GroundTransport{" +
                "countOfWheels=" + countOfWheels +
                ", volumeOfFuelTank=" + volumeOfFuelTank +
                "} " + super.toString();
    }
}
