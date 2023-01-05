package org.example.pz3;

public interface MyList<T> extends  Iterable<T> {
    void add(T obj);

    void clear();

    boolean remove(T obj);

    Object[] toArray();

    int size();

    boolean contains(T obj);
}
