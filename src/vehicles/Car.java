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

    private void generatePlate(){
        plateNumber = "GC" + ++numberOfGasolineCars;
    }

}
