package Generics.ListUtilities;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> integers = List.of(13, 23, 45, 67);
        List<String> strings = List.of("13", "23", "45", "67");

        System.out.println(ListUtils.getMin(integers));
        System.out.println(ListUtils.getMax(strings));
    }
}
