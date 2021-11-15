package Generics.Jar;

public class Main {
    public static void main(String[] args) {

        Jar<Integer> integerJar = new Jar<Integer>();
        Jar<String> stringJar = new Jar<String>();

        integerJar.add(23);
        stringJar.add("Max");

    }
}
