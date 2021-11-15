package EXAM.parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufactured, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufactured) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car result = null;
        for (Car car : data) {
            if (result == null || result.getYear() < car.getYear()) {
                result = car;
            }
        }
        return result;
    }

    public Car getCar(String manufactured, String model) {
        for (Car car : data) {
            if (car.getManufacturer().equals(manufactured) && car.getModel().equals(model)) {
                this.data.remove(car);
                return car;
            }
        }
        return null;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder out = new StringBuilder();
        out.append(String.format("The cars are parked in %s:%n", this.type))
                .append(System.lineSeparator());

        for (Car car : data) {
            out.append(car.toString()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
