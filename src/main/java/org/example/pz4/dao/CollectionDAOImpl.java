package org.example.pz4.dao;

import org.example.pz4.entity.Color;
import org.example.pz4.entity.Transport;
import org.example.pz4.entity.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionDAOImpl implements IDAO{
    private static List<Transport> transports = new ArrayList<>();
    private static List<Color> colors = new ArrayList<>();
    private static List<Type> types  = new ArrayList<>();

    private static long transportInc = 1;
    private static long colorInc = 1;
    private static long typeInc = 1;

    static{
        colors.add(new Color(colorInc++,"Red"));
        colors.add(new Color(colorInc++,"Orange"));
        colors.add(new Color(colorInc++,"Purple"));

        types.add(new Type(typeInc++,"Car"));
        types.add(new Type(typeInc++,"Plane"));
        types.add(new Type(typeInc++,"Truck"));

        transports.add(new Transport(transportInc++,5,240.0,"Car","Red",3500));
        transports.add(new Transport(transportInc++,54,360.0,"Plane","Purple",40000));
        transports.add(new Transport(transportInc++,3,180.0,"Truck","Orange",15000));
    }

    @Override
    public List<Color> getAllColors() {
        return colors;
    }

    @Override
    public List<Type> getAllTypes() {
        return types;
    }

    @Override
    public List<Transport> getAllTransport() {
        return transports;
    }

    @Override
    public Color getColorByName(String name) {
        return colors.stream().filter(c->c.getColor().equals(name)).findAny().orElse(null);
    }

    @Override
    public Type getTypeByName(String name) {
        return types.stream().filter(t->t.getName().equals(name)).findAny().orElse(null);
    }

    @Override
    public Transport getTransport(long id) {
        return transports.stream().filter(tr->tr.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<Transport> getTransportByColor(String color) {
        return transports.stream().filter(tr->tr.getColor().equals(color)).collect(Collectors.toList());
    }

    @Override
    public void saveTransport(Transport transport) {
        transport.setId(transportInc++);
        transports.add(transport);
    }

    @Override
    public void deleteTransport(long id) {
        transports.removeIf(tr->tr.getId()==id);
    }

    @Override
    public void deleteColor(String color) {
        colors.removeIf(c->c.getColor().equals(color));
    }

    @Override
    public void deleteType(String type) {
        types.removeIf(t->t.getName().equals(type));
    }

    @Override
    public void saveColor(Color color) {
        color.setId(colorInc++);
        colors.add(color);
    }

    @Override
    public void saveType(Type type) {
        type.setId(typeInc++);
        types.add(type);
    }
}
