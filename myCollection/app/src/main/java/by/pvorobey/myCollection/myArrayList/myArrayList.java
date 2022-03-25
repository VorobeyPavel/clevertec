package by.pvorobey.myCollection.myArrayList;

import java.util.Iterator;

public class myArrayList <T> implements ArrayList<T>{

    public static void main(String[] args) {
        myArrayList<String> list = new myArrayList<>();
        list.add("first");
        list.add("second");
        list.add("three");
        System.out.println(list.get(1));
        System.out.println(list.size());
        list.update(1,"update");
        list.delete(1);
        System.out.println(list.get(1));
    }

    private T [] values;

    myArrayList(){
        values = (T[] )new Object[0];
    }

    @Override
    public boolean add(T t) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values,0, temp.length);
            values[values.length-1] = t;
            return true;
        }catch (ClassCastException e){
            e.printStackTrace();
        }return false;
    }

    @Override
    public void delete(int index) {
        try {
            T[] temp = values;
            values = (T[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values,0, index);
            int amountElementAfterIndex = temp.length - index -1;
            System.arraycopy(temp, index+1, values, index, amountElementAfterIndex);
        }catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public T get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, T t) {
        values[index] = t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(values);
    }
}
