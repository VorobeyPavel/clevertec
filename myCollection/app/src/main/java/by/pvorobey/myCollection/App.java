/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package by.pvorobey.myCollection;

import java.util.LinkedList;

public class App {
    public String getGreeting() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(9);
        System.out.println(linkedList.get(0));
        linkedList.remove(2);
        System.out.println();
        System.out.println();
        System.out.println();

        LinkedList<Object> list = new LinkedList<>();
        list.remove(0);



    }

}
