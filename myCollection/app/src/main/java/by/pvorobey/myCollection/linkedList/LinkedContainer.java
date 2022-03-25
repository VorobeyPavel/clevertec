package by.pvorobey.myCollection.linkedList;

import java.util.Iterator;

public class LinkedContainer <T> implements Linked<T>, Iterable<T> {

    public static void main(String[] args) {
        LinkedContainer<String> linked = new LinkedContainer<>();
        linked.addLast("abc");
        linked.addLast("dg");
        linked.addLast("one");

        for (String s : linked) {
            System.out.println(s);
        }
        System.out.println(linked.size());
    }

    private Node<T> firstNode;
    private Node<T> lastNode;
    private int size = 0;

    public LinkedContainer(){
        lastNode = new Node<>(null, firstNode, null);
        firstNode = new Node<>(null, null, lastNode);
    }

    @Override
    public void addLast(T t) {
        Node<T> prev = lastNode;
        prev.setCurrentElement(t);
        lastNode = new Node<T>(null, prev, null);
        prev.setNextElement(lastNode);
        size++;
    }

    @Override
    public void addFirst(T t) {
        Node<T> next = firstNode;
        next.setCurrentElement(t);
        firstNode = new Node<>(null, null, next);
        next.setPrevElement(firstNode);
        size++;
    }

    @Override
    public void delete(int index){
        if (!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException();
        }
        Node<T> preDeleteNode;
        if (index==0){
            preDeleteNode = firstNode;
        }else {
            preDeleteNode = getNodeByIndex(index-1);
        }
        Node<T> nextDeleteNode;
        if (index==size-1){
            nextDeleteNode = lastNode;
        }else {
            nextDeleteNode = getNodeByIndex(index+1);
        }
        preDeleteNode.setNextElement(nextDeleteNode );
        nextDeleteNode.setPrevElement(preDeleteNode);
        size--;
    }

    @Override
    public void update(int index, T element){
        Node <T> updateElement = getNodeByIndex(index);
        updateElement.setCurrentElement(element);

    }

    @Override
    public T getElementByIndex(int counter) {
        if (!(counter >= 0 && counter < size))
            throw new IndexOutOfBoundsException();
        Node<T> target = firstNode.getNextElement();
        for (int i = 0; i < counter; i++){
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<T> getNextElement(Node<T> current){
        return current.getNextElement();
    }

    public Node<T> getNodeByIndex(int index){
        Node<T> target = firstNode.getNextElement();
        for (int i = 0; i < index; i++){
            target = getNextElement(target);
        }
        return target;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    //реализация анонимным классом
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int counter = 0;

            @Override
            public boolean hasNext() {
                return counter < size;
            }

            @Override
            public T next() {
                return getElementByIndex(counter++);
            }
        };
    }


    private class Node<T>{
        private T currentElement;
        private Node<T> nextElement;
        private Node<T> prevElement;

        public Node(T currentElement, Node<T> prevElement, Node<T> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.prevElement = prevElement;
        }

        public T getCurrentElement() {
            return currentElement;
        }

        public void setCurrentElement(T currentElement) {
            this.currentElement = currentElement;
        }

        public Node<T> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<T> nextElement) {
            this.nextElement = nextElement;
        }

        public Node<T> getPrevElement() {
            return prevElement;
        }

        public void setPrevElement(Node<T> prevElement) {
            this.prevElement = prevElement;
        }


    }
}