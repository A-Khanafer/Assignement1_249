package vehicles;

import java.util.Objects;

public class Vehicle {

    protected String plateNumber;
    protected String model;
    protected String make;
    protected int year;
    protected boolean leased = false;

    public Vehicle(String model, String make, int year, boolean leased) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.leased = leased;
    }

    public Vehicle(String model, String make, int year) {
        this.model = model;
        this.make = make;
        this.year = year;
        this.leased = false;
    }

    public Vehicle() {
        model = "";
        make = "";
        year = 0;
        leased = false;
    }

    public Vehicle(Vehicle vehicle){
        this.model = vehicle.model;
        this.make = vehicle.make;
        this.year = vehicle.year;
        this.leased = vehicle.leased;
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

    public boolean isLeased() {
        return leased;
    }

    public void setLeased(boolean leased) {
        this.leased = leased;
    }
}
