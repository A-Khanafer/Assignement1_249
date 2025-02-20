package vehicles;

import java.util.Objects;

public class Vehicle {

    protected String plateNumber;
    protected String model;
    protected String make;
    protected int year;

    public Vehicle(String model, String make, int year) {
        this.model = model;
        this.make = make;
        this.year = year;
    }

    public Vehicle() {
        model = "";
        make = "";
        year = 0;
    }

    public Vehicle(Vehicle vehicle){
        this.model = vehicle.model;
        this.make = vehicle.make;
        this.year = vehicle.year;
    }

    @Override
    public String toString() {
        return year + " " + model + " " + make + " " + plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return year == vehicle.year
                && plateNumber.equals(vehicle.plateNumber)
                && model.equals(vehicle.model)
                && make.equals(vehicle.make);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getPlateNumber() {
        return plateNumber;
    }
}
