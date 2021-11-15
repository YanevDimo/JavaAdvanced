package P07Google;

public class Car {
    private final String carModel;
    private final int carSpeed;

    public Car(String model, int speed) {
        this.carModel= model;
        this.carSpeed = speed;

    }

    @Override
    public String toString() {
        return carModel + " " + carSpeed;
    }
}
