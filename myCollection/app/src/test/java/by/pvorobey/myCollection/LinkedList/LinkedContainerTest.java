package by.pvorobey.myCollection.LinkedList;

import by.pvorobey.myCollection.linkedList.LinkedContainer;
import org.junit.Assert;
import org.junit.Test;

public class LinkedContainerTest {

    @Test
    public void updateTest(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        String updateElement = "world";

        linkedContainer.addLast("Hello");
        linkedContainer.addLast("Hello");

        linkedContainer.update(1, updateElement);
        Assert.assertEquals(updateElement, linkedContainer.getElementByIndex(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void deleteTest(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        linkedContainer.addFirst("Hello");
        linkedContainer.addLast("world");

        linkedContainer.delete(3);
        linkedContainer.delete(-2);
    }

    @Test
    public void deleteTestTwo(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        linkedContainer.addFirst("Hello");
        linkedContainer.addLast("world");

        linkedContainer.delete(1);
        Assert.assertEquals(1, linkedContainer.size());
    }

    @Test
    public void addFirstTest(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        linkedContainer.addLast("world");
        linkedContainer.addLast("!!!");
        linkedContainer.addFirst("Hello");

        Assert.assertEquals("Hello", linkedContainer.getElementByIndex(0));
    }

    @Test
    public void addLastTest(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        linkedContainer.addLast("two");
        linkedContainer.addFirst("one");
        linkedContainer.addFirst("zero");

        Assert.assertEquals("two", linkedContainer.getElementByIndex(linkedContainer.size()-1));
    }

    @Test
    public void getElementByIndexTestOne(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        String oneElement = "one";
        String twoElement = "two";

        linkedContainer.addFirst("one");
        linkedContainer.addFirst("zero");
        linkedContainer.addLast("two");
        linkedContainer.addLast("three");

        Assert.assertEquals(oneElement, linkedContainer.getElementByIndex(1));
        Assert.assertEquals(twoElement, linkedContainer.getElementByIndex(2));
    }


    //NullPointerException
    //IndexOutOfBoundsException
    @Test (expected = Exception.class)
    public void getElementByIndexTestTwo(){
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();

        int getElement = linkedContainer.size();
        linkedContainer.getElementByIndex(getElement++);
    }


    @Test(expected = IndexOutOfBoundsException.class)
    public void getElementByIndexTestThree() {
        LinkedContainer<Object> linkedContainer = new LinkedContainer<>();
        linkedContainer.addFirst("one");
        linkedContainer.addFirst("zero");

        linkedContainer.getElementByIndex(-1);
    }

}
