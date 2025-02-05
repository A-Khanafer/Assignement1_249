package vehicles;

public class ElectricCar extends Car {

    private double range;
    private static int numberOfElectricCars = 1000;

    public ElectricCar(String model, String make, int year, int maxPassengers, double range) {
        super(model, make, year, maxPassengers);
        this.range = range;
        generatePlate();
    }

    public ElectricCar(){
        super();
        range = 0;
        generatePlate();
    }

    public ElectricCar(ElectricCar electricCar){
        super(electricCar);
        range = electricCar.range;
        generatePlate();
    }

    private void generatePlate(){
        plateNumber = "EC" + ++numberOfElectricCars;
    }

}
