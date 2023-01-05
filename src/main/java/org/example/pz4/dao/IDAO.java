package org.example.pz4.dao;

import org.example.pz4.entity.Color;
import org.example.pz4.entity.Transport;
import org.example.pz4.entity.Type;

import java.util.List;

public interface IDAO {
    List<Color> getAllColors();
    List<Type> getAllTypes();
    List<Transport> getAllTransport();

    Color getColorByName(String name);
    Type getTypeByName(String name);
    Transport getTransport(long id);
    List<Transport> getTransportByColor(String color);

    void saveTransport(Transport transport);

    void deleteTransport(long id);
    void deleteColor(String color);
    void deleteType(String type);

    void saveColor(Color color);
    void saveType(Type type);
}
