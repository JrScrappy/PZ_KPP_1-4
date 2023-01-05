package org.example.pz2;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        final int SIZE = 5;
        Transport [] arr = new Transport[SIZE];
        arr[0] = new AirTransport(54,300,"Orange",4,2,10.4);
        arr[1] = new GroundTransport(5,200,"Purple",4,30.5);
        arr[2] = new Truck(2,160,"White",16,120.0,10000.0);
        arr[3] = new AirTransport(100,260,"Yellow",4,2,12.0);
        arr[4] = new WaterTransport(100,50,"White",30);

        System.out.println("Begin array:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Array after Arrays.sort(arr):");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("Array after sort by max speed DESC:");
        Arrays.sort(arr,new SortByMaxSpeedDESC());
        System.out.println(Arrays.toString(arr));
        System.out.println("Array after sort by type name ASC:");
        Arrays.sort(arr,new SortByTypeASC());
        System.out.println(Arrays.toString(arr));
    }
}
