package IteratorsAndComarators.Book.Main;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal farm", 2003,"George Owel");
        Book bookTwo = new Book("The documents in the case", 1930,"Dorothy Sayers","Robert Eustace");
        Book bookThree = new Book("The documents in the case", 2002);

        List<Book> books = new ArrayList<>();
        books.add(bookOne);
        books.add(bookTwo);
        books.add(bookThree);

    }
}
