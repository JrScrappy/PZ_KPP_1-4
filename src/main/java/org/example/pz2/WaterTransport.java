package org.example.pz2;

public class WaterTransport extends Transport {
    private double displacement;

    public WaterTransport(double displacement) {
        super(TransportType.WATER);
        this.displacement = displacement;
    }

    public WaterTransport(int countSeatPlaces, double maxSpeed, String color, double displacement) {
        super(countSeatPlaces, maxSpeed, TransportType.WATER, color);
        this.displacement = displacement;
    }

    public WaterTransport() {
        super(TransportType.WATER);
    }

    @Override
    public String toString() {
        return "WaterTransport{" +
                "displacement=" + displacement +
                "} " + super.toString();
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }
}
