package SetAndMapsAdvancedExercises;

import java.util.*;

public class P03PeriodicTable {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Set<String> periodicTable = new TreeSet<>();
        for (int compound = 0; compound < num; compound++) {
            String elements = scanner.nextLine();
            String[] chemicalCompounds = elements.split("\\s+");

            //първи начин за добавяне на елементи
            Collections.addAll(periodicTable, chemicalCompounds);

            //втори начин
//            periodicTable.addAll(Arrays.asList(chemicalCompounds));

            //треи наачин
//            for (String chemicalCompound : chemicalCompounds) {
//                periodicTable.add(chemicalCompound);
//            }
        }
        for (String element : periodicTable) {
            System.out.print(element + " ");
        }
    }
}
