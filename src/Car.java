public class Car {
    private String brand;
    private String model;
    private int horsePower;

    //конструктор на които се задават данните в класа за да не могат да се модифицират от вън
    public Car(String brand, String model, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    public Car(String brand, String model) {
        this(brand, model, -1);// constructorChaining ->създава под конструктор с по малко параметри
        // тъй като в като в конструктора не може да се създава метод, за да се спести повтарянето на код!!!
    }

    public Car(String brand, int horsePower) {
        this(brand, "unknown", horsePower);
    }

    public Car(String brand) {
        this(brand, "unknown", -1);
    }
    // ГЕТАРИТЕ СА МЕТОДИ КОИТО ВРЪЩАТ СТОЙНОСТИ
    public String getBrand() {return brand;}
    public String getModel() {return model;}
    public int getHorsePower() {return horsePower;}

    //СЕТАРИТЕ(SETTERS) са методи които които променят състоянието на обекта без да имаме директен достъп до
    //полето(field) или да се променя извън класа( в Main class) без да се променят полетата в класа Car

    public void setHorsePower(int horsePower) {this.horsePower = horsePower;}

    @Override
    public String toString() {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }
}
