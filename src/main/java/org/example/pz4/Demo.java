package org.example.pz4;

import org.example.pz4.dao.DAOFactory;
import org.example.pz4.dao.DAOType;
import org.example.pz4.dao.IDAO;
import org.example.pz4.entity.Color;
import org.example.pz4.entity.Transport;
import org.example.pz4.entity.Type;

public class Demo {
    public static void main(String[] args) {
        IDAO dao = DAOFactory.getInstance(DAOType.COLLECTION);

        System.out.println("All transport in database:");
        for (Transport elem : dao.getAllTransport()) {
            System.out.println(elem);
        }

        System.out.println("All color in database:");
        for(Color elem : dao.getAllColors()){
            System.out.println(elem);
        }

        System.out.println("All types in database:");
        for(Type elem : dao.getAllTypes()){
            System.out.println(elem);
        }
        System.out.println("All transport after delete transport where id = 1");
        dao.deleteTransport(1);
        for (Transport elem : dao.getAllTransport()) {
            System.out.println(elem);
        }
        System.out.println("Get color by name where name = \"Purple\": "+ dao.getColorByName("Purple"));

    }
}
