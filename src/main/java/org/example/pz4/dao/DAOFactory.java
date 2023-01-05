package org.example.pz4.dao;

public class DAOFactory {

    public static IDAO getInstance(DAOType type){
        IDAO idao = null;
        switch (type){
            case COLLECTION:
                idao = new CollectionDAOImpl();
                break;
            case MySQL:
                idao = new MySQLDAOImpl("jdbc:mysql://localhost:3306/labs_kpp?serverTimezone=UTC","bestuser","bestuser");
                break;
            default:
                throw new IllegalArgumentException("Wrong type of database type");
        }
        return idao;
    }
}
