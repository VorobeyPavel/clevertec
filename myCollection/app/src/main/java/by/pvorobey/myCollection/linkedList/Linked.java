package by.pvorobey.myCollection.linkedList;

public interface Linked <T> {
    void addLast(T t);
    void addFirst(T t);
    int size();
    T getElementByIndex(int counter);
    void delete(int index);
    void update(int index, T element);

}
