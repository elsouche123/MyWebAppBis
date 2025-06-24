package dao;

import models.Annonce;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {

    protected Connection connect = null;

    public DAO(Connection connect) {
        this.connect = connect;
    }

    public abstract boolean create(T obj);

    public abstract boolean delete(T obj);

    public abstract boolean update(T obj);

    public abstract T find(int id);

    public abstract List<T> list();
}
