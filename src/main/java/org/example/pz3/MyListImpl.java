package org.example.pz3;

import java.util.Iterator;

public class MyListImpl<T> implements MyList<T>{
    private int listSize;
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;
    }

    private class IteratorImpl implements Iterator<T> {

        private Node<T> pointer;

        public IteratorImpl(){
            pointer = head;
        }

        @Override
        public boolean hasNext() {
            if(pointer==null)
                return false;
            return pointer.next!=null;
        }

        @Override
        public T next() {
            T val = pointer.value;
            pointer = pointer.next;
            return val;
        }

        @Override
        public void remove(){
            if(pointer.prev==null){
                throw new IllegalStateException();
            }
            else if(pointer.prev.prev==null){
                head = pointer;
                head.prev = null;
            }
            else{
                Node<T> prev = pointer.prev.prev;
                Node<T> next = pointer;
                prev.next = next;
                next.prev = prev;
            }
            --listSize;
        }
    }

    public MyListImpl() {
        listSize = 0;
        head = new Node<>();
        tail = head;
    }

    @Override
    public void add(T obj) {
        tail.value = obj;
        Node<T> next = new Node<>();
        tail.next = next;
        next.prev = tail;
        tail = next;
        ++listSize;

    }

    @Override
    public void clear() {
        listSize = 0;
        head = new Node<>();
        tail = head;
    }

    @Override
    public boolean remove(T obj){
        if (listSize <= 0) {
            throw new IllegalStateException("Удаление из пустого списка");
        }
        Iterator<T> iterator = iterator();
        while(iterator.hasNext()){
            if(iterator.next().equals(obj)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[listSize];
        Iterator<T> it = iterator();
        int i = 0;
        while (it.hasNext()) {
            arr[i++] = it.next();
        }
        return arr;
    }

    @Override
    public int size() {
        return listSize;
    }

    @Override
    public boolean contains(T obj) {
        Iterator<T> it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        Iterator<T> it = iterator();
        while(it.hasNext()){
            builder.append("[").append(it.next()).append("]")  ;
            if(it.hasNext()){
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new IteratorImpl();
    }
}
