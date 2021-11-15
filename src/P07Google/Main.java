package P07Google;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // name -> data
        Map<String,Person> personData = new HashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")) {


            String[] parameters = input.split("\\s+");
            String name = parameters[0];

            if (!personData.containsKey(name)) {
                personData.put(name,new Person());
            }
            String enterData = parameters[1];// company,pokemon,parents,children,car

            switch (enterData) {
                case "company":
                    // "{Name} company {companyName} {department} {salary}"
                    String companyName = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                    Company company = new Company(companyName, department, salary);
                    personData.get(name).setComapany(company);
                    break;
                case "pokemon":
                    //"{Name} pokemon {pokemonName} {pokemonType}"
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personData.get(name).getPokemon().add(pokemon);
                    break;
                case "parents":
                    //"{Name} parents {parentName} {parentBirthday}"
                    String parentName = parameters[2];
                    String parentsBirthday = parameters[3];
                    Parent parent = new Parent(parentName, parentsBirthday);
                    personData.get(name).getParents().add(parent);
                    break;
                case "children":
                    //"{Name} children {childName} {childBirthday}"
                    String childName = parameters[2];
                    String childBirthday = parameters[3];
                    Children children = new Children(childName, childBirthday);
                    personData.get(name).getChildren().add(children);
                    break;
                case "car":
                    // "{Name} car {carModel} {carSpeed}"
                    String carModel = parameters[0];
                    int carSpeed = Integer.parseInt(parameters[1]);
                    Car car = new Car(carModel, carSpeed);
                    personData.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }
        String searchPerson = scanner.nextLine();
        System.out.println(searchPerson);

        Person personalData = personData.get(searchPerson);

        System.out.println(personalData);
    }
}
