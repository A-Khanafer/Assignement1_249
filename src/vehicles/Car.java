package vehicles;

public class Car extends Vehicle {

    protected int maxPassengers;
    private static int numberOfGasolineCars = 1000;

    public Car(String model, String make, int year, int maxPassengers) {
        super(model, make, year);
        this.maxPassengers = maxPassengers;
    }

    public Car(){
        super();
    }

    public Car(Car car){
        super(car);
        maxPassengers= car.maxPassengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    private void generatePlate(){
        plateNumber = "GC" + ++numberOfGasolineCars;
    }

    @Override
    public String toString() {
        return super.toString() + " " + maxPassengers;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return super.equals(car) && maxPassengers == car.maxPassengers;
    }

}
