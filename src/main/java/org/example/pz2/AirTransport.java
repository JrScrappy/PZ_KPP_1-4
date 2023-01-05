package org.example.pz2;

public class AirTransport extends Transport{
    private int countOfEngines;
    private int countOfPilots;
    private double overload;

    public AirTransport() {
        super(TransportType.AIR);
    }

    public AirTransport(int countOfEngines, int countOfPilots, double overload) {
        super(TransportType.AIR);
        this.countOfEngines = countOfEngines;
        this.countOfPilots = countOfPilots;
        this.overload = overload;
    }

    public AirTransport(int countSeatPlaces, double maxSpeed, String color, int countOfEngines, int countOfPilots, double overload) {
        super(countSeatPlaces, maxSpeed, TransportType.AIR, color);
        this.countOfEngines = countOfEngines;
        this.countOfPilots = countOfPilots;
        this.overload = overload;
    }

    public int getCountOfEngines() {
        return countOfEngines;
    }

    public void setCountOfEngines(int countOfEngines) {
        this.countOfEngines = countOfEngines;
    }

    public int getCountOfPilots() {
        return countOfPilots;
    }

    public void setCountOfPilots(int countOfPilots) {
        this.countOfPilots = countOfPilots;
    }

    public double getOverload() {
        return overload;
    }

    public void setOverload(double overload) {
        this.overload = overload;
    }

    @Override
    public String toString() {
        return "AirTransport{" +
                "countOfEngines=" + countOfEngines +
                ", countOfPilots=" + countOfPilots +
                ", overload=" + overload +
                "} " + super.toString();
    }
}
