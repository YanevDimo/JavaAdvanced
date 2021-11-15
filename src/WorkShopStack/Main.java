package WorkShopStack;

public class Main {
    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(13);
        stack.push(43);
        stack.push(53);

        stack.forEach(System.out::println);
    }
}
