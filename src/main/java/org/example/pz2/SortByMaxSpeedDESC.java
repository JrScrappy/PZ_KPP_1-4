package org.example.pz2;

import java.util.Comparator;

public class SortByMaxSpeedDESC implements Comparator<Transport> {
    @Override
    public int compare(Transport o1, Transport o2) {
        return (int)Math.floor(o2.getMaxSpeed() - o1.getMaxSpeed());
    }
}
