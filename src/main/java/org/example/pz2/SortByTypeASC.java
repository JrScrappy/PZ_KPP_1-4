package org.example.pz2;

import java.util.Comparator;

public class SortByTypeASC implements Comparator<Transport> {
    @Override
    public int compare(Transport o1, Transport o2) {
        return o1.getTransportType().compareTo(o2.getTransportType());
    }
}
