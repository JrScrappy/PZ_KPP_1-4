package org.example.pz3;

import org.example.pz2.*;

import java.util.Iterator;

public class Demo {

    public static void main(String[] args) {
        MyList<Transport> transports = new MyListImpl<>();
        Transport toRemove = new Truck(2, 160, "White", 16, 120.0, 10000.0);
        transports.add(new AirTransport(54, 300, "Orange", 4, 2, 10.4));
        transports.add(new GroundTransport(5, 200, "Purple", 4, 30.5));
        transports.add(toRemove);
        transports.add(new AirTransport(100, 260, "Yellow", 4, 2, 12.0));
        transports.add(new WaterTransport(100, 50, "White", 30));

        System.out.println("Begin MyList<Transport>");
        System.out.println(transports);
        System.out.println("============================================");
        transports.remove(toRemove);
        System.out.println("MyList<Transport> after remove ("+toRemove+"):" + transports);
        System.out.println("============================================");
        System.out.println("ForEach print:");
        for(Transport elem : transports){
            System.out.println(elem);
        }
        System.out.println("============================================");
        System.out.println("Iterator<Transport> print:");
        Iterator<Transport> iterator = transports.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("============================================");
    }

}