package by.pvorobey.myCollection.myArrayList;

import java.util.Iterator;

public class ArrayIterator <T> implements Iterator<T> {

    private int index = 0;
    private T[] value;

    ArrayIterator(T[] value){
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return index < value.length;
    }

    @Override
    public T next() {
        return value[index++];
    }
}
