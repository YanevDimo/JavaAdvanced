package EXAM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class P01SantasPresentFactory {


        public static void main(String[] args) throws IOException {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            ArrayDeque<Integer> materialStack = new ArrayDeque<>();
            ArrayDeque<Integer> magicValuesQueue = new ArrayDeque<>();
            TreeMap<String, Integer> toys = new TreeMap<>();

            String[] b = bf.readLine().split(" ");
            String[] m = bf.readLine().split(" ");

            for (String string : b) {
                materialStack.push(Integer.parseInt(string));
            }

            for (String string : m) {
                magicValuesQueue.offer(Integer.parseInt(string));
            }





            while (magicValuesQueue.size()>0 && materialStack.size()>0) {
                int values = magicValuesQueue.peek();
                int boxes = materialStack.peek();
                int product = values * boxes;

                if (product < 0) {
                    int result = values + boxes;
                    magicValuesQueue.poll();
                    materialStack.pop();
                    materialStack.push(result);

                }
                else if (boxes == 0 || values == 0) {
                    if (boxes == 0) {
                        materialStack.pop();
                    }
                    if (values == 0) {
                        magicValuesQueue.poll();
                    }

                }

                else if (product == 150 || product == 250 || product == 300 || product == 400) {
                    String gift ;
                    if (product == 150) {
                        gift = "Doll";
                        magicValuesQueue.poll();
                        materialStack.pop();
                        toys.putIfAbsent(gift, 0);
                        toys.put(gift, toys.get(gift) + 1);
                    } else if (product == 250) {
                        gift = "Wooden train";
                        magicValuesQueue.poll();
                        materialStack.pop();
                        toys.putIfAbsent(gift, 0);
                        toys.put(gift, toys.get(gift) + 1);
                    } else if (product == 300) {
                        gift = "Teddy bear";
                        magicValuesQueue.poll();
                        materialStack.pop();
                        toys.putIfAbsent(gift, 0);
                        toys.put(gift, toys.get(gift) + 1);
                    } else  {
                        gift = "Bicycle";
                        magicValuesQueue.poll();
                        materialStack.pop();
                        toys.putIfAbsent(gift, 0);
                        toys.put(gift, toys.get(gift) + 1);
                    }
                }
                else if (product>0) {
                    magicValuesQueue.poll();
                    boxes += 15;
                    materialStack.pop();
                    materialStack.push(boxes);
                }
            }

            if (toys.containsKey("Doll") && toys.containsKey("Wooden train")){
                System.out.println("The presents are crafted! Merry Christmas!");
            }
            else if (toys.containsKey("Teddy bear") && toys.containsKey("Bicycle")){
                System.out.println("The presents are crafted! Merry Christmas!");
            }
            else {
                System.out.println("No presents this Christmas!");
            }

            if (materialStack.size() > 0) {
                System.out.print("Materials left: ");

                for (int i = 0; i < materialStack.size(); i++) {
                    if (i == materialStack.size() - 1) {
                        System.out.println(materialStack.pop());
                    } else {
                        System.out.print(materialStack.pop() + ", ");
                        i--;
                    }
                }
            }

            if (magicValuesQueue.size() > 0) {
                System.out.print("Magic left: ");
                for (int i = 0; i < magicValuesQueue.size(); i++) {
                    if (i == magicValuesQueue.size() - 1) {
                        System.out.println(magicValuesQueue.poll());
                    } else {
                        System.out.print(magicValuesQueue.poll() + ", ");
                        i--;
                    }
                }
            }

            for (Map.Entry<String, Integer> entry : toys.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
}
