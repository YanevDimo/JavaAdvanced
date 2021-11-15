package DefiningClasses;

public class Person {
    //полета
    private String name ;
    private int age;

    //конструктор

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }

    public Person() {

    }
    // getters and setters

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
