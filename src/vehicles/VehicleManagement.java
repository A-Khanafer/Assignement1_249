package vehicles;

public class VehicleManagement {

    private Vehicle[] vehiclesManager;

    public VehicleManagement() {
        vehiclesManager = new Vehicle[0];
    }


    public VehicleManagement(Vehicle[] vehiclesManager) {
        this.vehiclesManager = new Vehicle[vehiclesManager.length];
        for (int i = 0; i < vehiclesManager.length; i++) {
            this.vehiclesManager[i] = vehicleTypeCreator(vehiclesManager[i]);
        }
    }

    public VehicleManagement(VehicleManagement vehicleManagement) {
        this.vehiclesManager = new Vehicle[vehicleManagement.vehiclesManager.length];
        for (int i = 0; i < vehicleManagement.vehiclesManager.length; i++) {
            this.vehiclesManager[i] = vehicleTypeCreator(vehicleManagement.vehiclesManager[i]);
        }
    }

    public void addVehicle(Vehicle vehicle) {
        boolean found = false;
        for (Vehicle value : vehiclesManager) {
            if (value != null && value.equals(vehicle)) {
                found = true;
                System.out.println("Vehicle already in Database.");
                break;
            }
        }
        if (!found) {
            Vehicle[] temp = new Vehicle[vehiclesManager.length + 1];
            for(int i = 0; i < vehiclesManager.length; i++) {
                if(vehiclesManager[i]!=null)
                    temp[i] = vehicleTypeCreator(vehiclesManager[i]);

            }
            temp[vehiclesManager.length] = vehicleTypeCreator(vehicle);
            vehiclesManager = temp;
            System.out.println("Vehicle added..." + vehiclesManager[vehiclesManager.length -1]);
        }
    }

    public void deleteVehicle(String plateNumber) {
        int index = -1;
        for (int i = 0; i < vehiclesManager.length; i++) {

            if (vehiclesManager[i]!=null && vehiclesManager[i].getPlateNumber().equals(plateNumber)) {
                index = i;
                break;
            }
        }
        if (index>-1){

            Vehicle[] temp = new Vehicle[vehiclesManager.length - 1];

            for (int i = 0; i < index; i++) {
                temp[i] = vehiclesManager[i];
            }

            for (int i = index ; i < vehiclesManager.length -1 ; i++) {
                temp[i] = vehiclesManager[i+1];
            }
            vehiclesManager = temp;

            System.out.println("Vehicle has been deleted.");
        }
        else {
            System.out.println("Vehicle does not exist.");
        }
    }

    public void editVehicle(String plateNumber, String input, int choice) {
        int index = -1;
        for (int i = 0; i < vehiclesManager.length; i++) {
            if (vehiclesManager[i] != null && vehiclesManager[i].getPlateNumber().equals(plateNumber)) {
                index = i;
                break;
            }
        }
        editVehicleInputs(input, choice, index);
    }

    public Vehicle[] getVehiclesManager() {
        return vehiclesManager;
    }

    public void setVehiclesManager(Vehicle[] vehiclesManager) {
        this.vehiclesManager = new VehicleManagement(this).vehiclesManager;
    }

    @Override
    public String toString() {
        String electricCars = "ElectricCar:\n";
        String electricTruck = "Electric Trucks:\n";
        String dieselTruck = "Diesel Trucks:\n";
        String car = "Gasoline Car:\n";

        for (Vehicle vehicle : vehiclesManager) {
            if (vehicle instanceof ElectricCar) {
                electricCars += "    " + vehicle + "\n";
            } else if (vehicle instanceof ElectricTruck) {
                electricTruck += "   " + vehicle + "\n";
            } else if (vehicle instanceof DieselTruck) {
                dieselTruck += "     " + vehicle + "\n";
            } else if(vehicle instanceof Car){
                car += "     " + vehicle + "\n";
            }
        }
        return electricCars + "\n" + electricTruck + "\n" + dieselTruck + "\n" + car;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        VehicleManagement that = (VehicleManagement) o;
        boolean equals = true;

        if(vehiclesManager.length != that.vehiclesManager.length) return false;

        for (int i = 0; i < vehiclesManager.length; i++) {
            equals = vehiclesManager[i].equals(that.vehiclesManager[i]);
            if (!equals) {
                return false;
            }
        }
        return equals;
    }

    private void editVehicleInputs( String input, Integer choice , int index) {
        if (index > -1) {
            if(vehiclesManager[index] instanceof ElectricTruck) {
                editInputElectricTruck((ElectricTruck) vehiclesManager[index], input, choice);
            }else if(vehiclesManager[index] instanceof Car) {
                editInputCar((Car) vehiclesManager[index], input, choice);
            }else if(vehiclesManager[index] instanceof DieselTruck) {
                editInputDieselTruck((DieselTruck) vehiclesManager[index], input, choice);
            } else if(vehiclesManager[index] instanceof ElectricCar){
                editInputElectricCar((ElectricCar) vehiclesManager[index], input, choice);
            }
        }else{
            System.out.println("Vehicle does not exist.");
        }
    }

    private void editInputElectricTruck(ElectricTruck electricTruck, String input, int choice) {
        switch (choice) {
            case 1:
                electricTruck.setMake(input);
                System.out.println("Vehicle make updated");
                break;
            case 2:
                electricTruck.setModel(input);
                System.out.println("Vehicle model updated");
                break;
            case 3:
                electricTruck.setYear(Integer.parseInt(input));
                System.out.println("vehicle year updated");
                break;
            case 4:
                electricTruck.setPlateNumber(input);
                System.out.println("Vehicle plate number updated");
                break;
            case 5:
                electricTruck.setMaxCapacity(Double.parseDouble(input));
                System.out.println("Vehicle capacity updated");
                break;
            case 6:
                electricTruck.setRange(Double.parseDouble(input));
                System.out.println("Vehicle range updated");
                break;
            default:
                break;
        }
    }

    private void editInputDieselTruck(DieselTruck dieselTruck, String input, int choice){
        switch (choice) {
            case 1:
                dieselTruck.setMake(input);
                System.out.println("Vehicle make updated");
                break;
            case 2:
                dieselTruck.setModel(input);
                System.out.println("Vehicle model updated");
                break;
            case 3:
                dieselTruck.setYear(Integer.parseInt(input));
                System.out.println("vehicle year updated");
                break;
            case 4:
                dieselTruck.setPlateNumber(input);
                System.out.println("Vehicle plate number updated");
                break;
            case 5:
                dieselTruck.setMaxCapacity(Double.parseDouble(input));
                System.out.println("Vehicle max capacity updated");
                break;
            case 6:
                dieselTruck.setTankCapacity(Double.parseDouble(input));
                System.out.println("Vehicle tank capacity updated");
                break;
            default:
                System.out.println("No modification made");
                break;
        }
    }

    private void editInputCar(Car car, String input, int choice){
        switch (choice) {
            case 1:
                car.setMake(input);
                System.out.println("Vehicle make updated");
                break;
            case 2:
                car.setModel(input);
                System.out.println("Vehicle model updated");
                break;
            case 3:
                car.setYear(Integer.parseInt(input));
                System.out.println("vehicle year updated");
                break;
            case 4:
                car.setPlateNumber(input);
                System.out.println("Vehicle plate Number updated");
                break;
            case 5:
                car.setMaxPassengers(Integer.parseInt(input));
                System.out.println("Vehicle max passengers updated");
                break;
            default:
                System.out.println("No modification made");
                break;
        }
    }

    private void editInputElectricCar(ElectricCar electricCar, String input, int choice){
        switch (choice) {
            case 1:
                electricCar.setMake(input);
                System.out.println("Vehicle make updated");
                break;
            case 2:
                electricCar.setModel(input);
                System.out.println("Vehicle model updated");
                break;
            case 3:
                electricCar.setYear(Integer.parseInt(input));
                System.out.println("vehicle year updated");
                break;
            case 4:
                electricCar.setPlateNumber(input);
                System.out.println("Vehicle plate Number updated");
                break;
            case 5:
                electricCar.setMaxPassengers(Integer.parseInt(input));
                System.out.println("Vehicle max passengers updated");
                break;
            case 6:
                electricCar.setRange(Double.parseDouble(input));
                System.out.println("Vehicle range updated");
                break;
            default:
                System.out.println("No modification made");
                break;
        }
    }

    private Vehicle vehicleTypeCreator(Vehicle vehicle) {
        return switch (vehicle) {
            case ElectricCar electricCar -> new ElectricCar(electricCar);
            case DieselTruck dieselTruck -> new DieselTruck(dieselTruck);
            case ElectricTruck electricTruck -> new ElectricTruck(electricTruck);
            case Car car -> new Car(car);
            case null -> null;
            default -> throw new IllegalStateException("Unexpected value: " + vehicle);
        };
    }





}
