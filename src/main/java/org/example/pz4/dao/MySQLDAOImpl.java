package org.example.pz4.dao;

import org.example.pz4.entity.Color;
import org.example.pz4.entity.Transport;
import org.example.pz4.entity.Type;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDAOImpl implements IDAO {
    private final String SQL_GET_ALL_TRANSPORT = "SELECT c.id, col.color, tp.name, c.max_speed, c.count_seat_places, c.load_capacity " +
            " FROM car c" +
            " INNER JOIN car_type tp" +
            " on c.type_id = tp.id" +
            " INNER JOIN car_color col" +
            " on col.id = c.color_id";
    private final String SQL_GET_ALL_COLORS = "SELECT * FROM car_color";
    private final String SQL_GET_ALL_TYPES = "SELECT * FROM car_type";
    private final String SQL_GET_TYPE_BY_TYPE_NAME = "SELECT * FROM car_type WHERE name = ?";
    private final String SQL_GET_COLOR_BY_COLOR_NAME = "SELECT * FROM car_color WHERE color = ?";
    private final String SQL_DELETE_TRANSPORT_BY_ID = "DELETE FROM car WHERE id = ?";
    private final String SQL_DELETE_COLOR_BY_COLOR_NAME = "DELETE FROM car_color WHERE color = ?";
    private final String SQL_DELETE_TYPE_BY_TYPE_NAME = "DELETE FROM car_type WHERE name = ?";
    private final String SQL_GET_TRANSPORT_BY_COLOR = "SELECT c.id, col.color, tp.name, c.max_speed, c.count_seat_places, c.load_capacity " +
            " FROM car c" +
            " INNER JOIN car_type tp" +
            " on c.type_id = tp.id" +
            " INNER JOIN car_color col" +
            " on col.id = c.color_id" +
            " WHERE col.color = ?";
    private final String SQL_GET_TRANSPORT_BY_ID = "SELECT c.id, col.color, tp.name, c.max_speed, c.count_seat_places, c.load_capacity " +
            " FROM car c" +
            " INNER JOIN car_type tp" +
            " on c.type_id = tp.id" +
            " INNER JOIN car_color col" +
            " on col.id = c.color_id" +
            " WHERE c.id = ?";
    private final String SQL_UPDATE_TRANSPORT = "UPDATE car set type_id = ?,max_speed = ?,count_seat_places = ?,load_capacity = ?,color_id = ? WHERE id = ?";
    private final String SQL_INSERT_TRANSPORT = "INSERT INTO car (type_id,max_speed,count_seat_places,load_capacity,color_id) VALUES (?,?,?,?,?)";
    private final String SQL_INSERT_COLOR = "INSERT INTO car_color (color) VALUES (?)";
    private final String SQL_INSERT_TYPE = "INSERT INTO car_type (name) VALUES (?)";

    private String url;
    private String user;
    private String password;

    public MySQLDAOImpl(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Color> getAllColors() {
        List<Color> colors = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_COLORS);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Color color = new Color();
                color.setId(resultSet.getLong("id"));
                color.setColor(resultSet.getString("color"));
                colors.add(color);
            }
            resultSet.close();
            statement.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colors;
    }

    @Override
    public List<Type> getAllTypes() {
        List<Type> types = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_TYPES);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Type type = new Type();
                type.setId(resultSet.getLong("id"));
                type.setName(resultSet.getString("name"));
                types.add(type);
            }

            resultSet.close();
            statement.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return types;
    }

    @Override
    public List<Transport> getAllTransport() {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_GET_ALL_TRANSPORT);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Transport transport = new Transport();
                transport.setId(resultSet.getLong("c.id"));
                transport.setColor(resultSet.getString("col.color"));
                transport.setTransportType(resultSet.getString("tp.name"));
                transport.setMaxSpeed(resultSet.getDouble("c.max_speed"));
                transport.setCountSeatPlaces(resultSet.getInt("c.count_seat_places"));
                transport.setLoadCapacity(resultSet.getDouble("c.load_capacity"));
                transports.add(transport);
            }

            statement.close();
            resultSet.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    @Override
    public Color getColorByName(String name) {
        Color color = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_GET_COLOR_BY_COLOR_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                color = new Color();
                color.setId(resultSet.getLong("id"));
                color.setColor(resultSet.getString("color"));
            }

            statement.close();
            resultSet.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public Type getTypeByName(String name) {
        Type type = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_GET_TYPE_BY_TYPE_NAME);
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                type = new Type();
                type.setId(resultSet.getLong("id"));
                type.setName(resultSet.getString("name"));
            }

            statement.close();
            resultSet.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public Transport getTransport(long id) {
        Transport transport = null;
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_GET_TRANSPORT_BY_ID);
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                transport = new Transport();
                transport.setId(resultSet.getLong("c.id"));
                transport.setColor(resultSet.getString("col.color"));
                transport.setTransportType(resultSet.getString("tp.name"));
                transport.setMaxSpeed(resultSet.getDouble("c.max_speed"));
                transport.setCountSeatPlaces(resultSet.getInt("c.count_seat_places"));
                transport.setLoadCapacity(resultSet.getDouble("c.load_capacity"));
            }

            statement.close();
            resultSet.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transport;
    }

    @Override
    public List<Transport> getTransportByColor(String color) {
        List<Transport> transports = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_GET_TRANSPORT_BY_COLOR);
            statement.setString(1, color);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Transport transport = new Transport();
                transport.setId(resultSet.getLong("c.id"));
                transport.setColor(resultSet.getString("col.color"));
                transport.setTransportType(resultSet.getString("tp.name"));
                transport.setMaxSpeed(resultSet.getDouble("c.max_speed"));
                transport.setCountSeatPlaces(resultSet.getInt("c.count_seat_places"));
                transport.setLoadCapacity(resultSet.getDouble("c.load_capacity"));
                transports.add(transport);
            }

            statement.close();
            resultSet.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return transports;
    }

    @Override
    public void saveTransport(Transport transport) {
        if (transport == null) {
            throw new RuntimeException();
        }
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            PreparedStatement statement = null;
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            if (transport.getId() != 0) {
                statement = connection.prepareStatement(SQL_UPDATE_TRANSPORT);
                statement.setLong(6, transport.getId());
            } else {
                statement = connection.prepareStatement(SQL_INSERT_TRANSPORT);
            }
            Color color = getColorByName(transport.getColor());
            Type type = getTypeByName(transport.getTransportType());
            if(color!=null&&type!=null){
                statement.setLong(1,type.getId());
                statement.setDouble(2, transport.getMaxSpeed());
                statement.setInt(3, transport.getCountSeatPlaces());
                statement.setDouble(4, transport.getLoadCapacity());
                statement.setLong(5,color.getId());
                statement.executeUpdate();
            }
            statement.close();
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTransport(long id) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TRANSPORT_BY_ID);
            statement.setLong(1, id);
            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteColor(String color) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_COLOR_BY_COLOR_NAME);
            statement.setString(1, color);
            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteType(String type) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_DELETE_TYPE_BY_TYPE_NAME);
            statement.setString(1, type);
            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveColor(Color color) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_COLOR);
            statement.setString(1, color.getColor());
            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveType(Type type) {
        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            connection.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(SQL_INSERT_TYPE);
            statement.setString(1, type.getName());
            statement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
