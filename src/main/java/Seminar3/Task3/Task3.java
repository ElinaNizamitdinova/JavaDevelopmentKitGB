package Seminar3.Task3;

import java.util.Iterator;
import java.util.List;

public class Task3 <T> implements Iterator<T> {
    private List<T> list;
    private int index;

    public Task3(List<T> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }
    @Override
    public void remove(){
        list.remove(--index);
    }
}
