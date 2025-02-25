package vehicles;

public class ElectricCar extends Car {

    private double range;
    private static int numberOfElectricCars = 1000;

    public ElectricCar(String model, String make, int year, int maxPassengers, double range) {
        super(model, make, year, maxPassengers, false);
        this.range = range;
        generatePlate();
    }

    public ElectricCar(){
        super();
        range = 0;
    }

    public ElectricCar(ElectricCar electricCar){
        super(electricCar);
        range = electricCar.range;
        this.plateNumber = electricCar.plateNumber;
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }

    private void generatePlate(){
        plateNumber = "EC" + ++numberOfElectricCars;
    }

    @Override
    public String toString() {
        return super.toString() + " " + range ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ElectricCar electricCar = (ElectricCar) o;
        return super.equals(electricCar) && range == electricCar.range;
    }
}
