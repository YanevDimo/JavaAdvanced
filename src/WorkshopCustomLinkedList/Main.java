package WorkshopCustomLinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        doublyLinkedList.addFirst(5);
        doublyLinkedList.addFirst(4);
        doublyLinkedList.addLast(6);
        doublyLinkedList.addLast(7);
        doublyLinkedList.addLast(8);
        doublyLinkedList.addLast(9);


    }
}
