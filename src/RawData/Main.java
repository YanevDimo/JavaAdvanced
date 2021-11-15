package RawData;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

          int countCar = Integer.parseInt(scanner.nextLine());
       // "{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType}
        // {Tire1Pressure} {Tire1Age} {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age}
        // {Tire4Pressure} {Tire4Age}", where the speed, power, weight and tire age are integers,
        // tire pressure is a double.

        while (countCar-- > 0) {
            String[]tokens = scanner.nextLine().split(" ");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight =Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age= Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age= Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age= Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age= Integer.parseInt(tokens[11]);
            Car car = new Car(model,enginePower,engineSpeed,cargoWeight);
        }
        System.out.println();
    }
}
