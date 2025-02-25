//----------------------------------------------------------------------------
// Assignment #1
// Question: Driver Class
// Written by: Ahmad Khanafer (40312768) & Abed-Elmouhsen Cherkawi (40323359)
//----------------------------------------------------------------------------

package Driver;

import clients.Client;
import clients.ClientManager;
import vehicles.*;
import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);
    static ClientManager cm = new ClientManager();
    static VehicleManagement vm = new VehicleManagement();
    public static void main(String[] args) {

        cm.setVehicleData(vm);
        String clientPhone;
        String clientName;
        String clientAddress;
        String clientEmail;



        System.out.println("Welcome to Unilla Car Lease Services, by Khanafer and Cherkawi!\n");
        boolean quit = false;
        int choice;
        while (!quit) {
            display();
                choice = read.nextInt();
            switch(choice){
                case 1:
                    addVehicle();
                    break;
                case 2:
                    deleteVehicle();
                    break;
                case 3:
                    editVehicle();
                    break;
                case 4:
                    System.out.println(vm);
                    break;

                case 5:
                    addClient();
                    break;

                case 6:
                    editClient();
                    break;

                case 7:
                    deleteClient();
                    break;

                case 8:
                    leaseVehicle();
                    break;
                case 9:
                    returnVehicle();
                    break;
                case 10:
                    leasedVehicleByClient();
                    break;
                case 11:
                    cm.showAllLeasedVehicles();
                    break;
                case 12:
                    break;
                case 13:
                    break;
                case 0:
                    quit = true;
                    break;
                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        }
        System.out.println("Goodbye!");
    }

    public static DieselTruck getLargestTruck(DieselTruck[] trucks) {
        DieselTruck largest;
        if (trucks == null || trucks.length == 0) {
            largest = new DieselTruck();
        }

        else{ largest = trucks[0];
            for (int i = 1; i < trucks.length; i++) {
                if (trucks[i].getMaxCapacity() > largest.getMaxCapacity()) {
                    largest = trucks[i];
                }
            }
        }
        return largest;
    }

    public ElectricTruck[] copyVehicles(ElectricTruck[] Trucks) {
        ElectricTruck[] copiedElec = new ElectricTruck[Trucks.length];
        for(int i = 0; i < Trucks.length; i++) {
            copiedElec[i] = new ElectricTruck(Trucks[i]);
        }
        return copiedElec;
    }

    private static void addClient(){

        read.nextLine();
            System.out.print("Enter client name: ");
            String clientName = read.nextLine();

            System.out.println("Enter client email: ");
            String clientEmail = read.nextLine();

            System.out.print("Enter client phone number: ");
            String clientPhone = read.nextLine();

            System.out.print("Enter client address: ");
            String clientAddress = read.nextLine();

            Client t = new Client(clientName, clientEmail, clientPhone, clientAddress);
        cm.addClient(t);
    }

    private static void deleteClient(){

        read.nextLine();

        System.out.print("Enter client name: ");
        String clientName = read.nextLine();

        System.out.println("Enter client email: ");
        String clientEmail = read.next();

        System.out.print("Enter client phone number: ");
        String clientPhone = read.next();

        System.out.print("Enter client address: ");
        String clientAddress = read.next();

        Client t = new Client(clientName, clientEmail, clientPhone, clientAddress);
        cm.deleteClient(t);

    }

    private static void editClient(){
        String input ="";
        read.nextLine();
        System.out.print("Enter client name: ");
        String clientName = read.nextLine();
        System.out.print("Enter client email: ");
        String clientEmail = read.nextLine();
        System.out.print("Enter client phone number: ");
        String clientPhone = read.nextLine();
        System.out.print("Enter client address: ");
        String clientAddress = read.nextLine();
        Client t = new Client(clientName, clientEmail, clientPhone, clientAddress);
        System.out.println("\nWhat do you want to edit?");
        System.out.println("1. Client name");
        System.out.println("2. Client email");
        System.out.println("3. Client phone number");
        System.out.println("4. Client address");
       int subchoice = read.nextInt();
read.nextLine();
       switch(subchoice){
           case 1:
               System.out.print("Enter new client name: ");
               input = read.nextLine();
               break;
               case 2:
                   System.out.print("Enter new client email: ");
                   input = read.nextLine();
                   break;
                   case 3:
                       System.out.print("Enter new client phone number: ");
                       input = read.nextLine();
                       break;
                       case 4:
                           System.out.print("Enter new client address: ");
                           input = read.nextLine();
                           break;
                           default:
                               break;
       }



        cm.editClient(t, input, subchoice);
    }

    private static void display(){

        System.out.println("\nVehicle Management:");
        System.out.println("1. Add a vehicle");
        System.out.println("2. Delete a vehicle");
        System.out.println("3. Update vehicle information");
        System.out.println("4. List all vehicles by category (electric trucks, diesel trucks, etc.)");

        System.out.println("\nClient Management:");
        System.out.println("5. Add a client");
        System.out.println("6. Edit a client");
        System.out.println("7. Delete a client");

        System.out.println("\nLeasing Operations:");
        System.out.println("8. Lease a vehicle to a client");
        System.out.println("9. return a vehicle from a client");
        System.out.println("10. Show all vehicles leased by a client");
        System.out.println("11. Show all leased vehicles (by all clients)");

        System.out.println("\nAdditional operations:");
        System.out.println("12. Display the truck with the largest capacity");
        System.out.println("13. Create a copy of the electric trucks array");

        System.out.println("\n0. Exit");
        System.out.print("\nEnter your choice: ");
    }

    private static void editVehicle(){
        System.out.print("\nEnter the type of vehicle (GC , DT, EC or ET): ");
        String vehicleType = read.next().toUpperCase();

        System.out.println("1. Edit vehicle vehicle make: ");
        System.out.println("2. Edit vehicle vehicle model: ");
        System.out.println("3. Edit vehicle year: ");
        System.out.println("4. Edit vehicle plate number: ");

        switch(vehicleType){
            case "GC":

                System.out.println("5. Edit vehicle maximum passengers: ");

                break;

            case "DT":

                System.out.println("5. Edit vehicle maximum capacity: ");
                System.out.println("6. Edit vehicle tank capacity: ");
                break;

            case "EC":

                System.out.println("5. Edit vehicle maximum passengers: ");
                System.out.println("6. Edit vehicle range: ");
                break;
            case "ET":
                System.out.println("5. Edit vehicle maximum capacity: ");
                System.out.println("6. Edit vehicle range: ");
            default :
                System.out.println("Not a valid vehicle type.");
                break;
        }
        System.out.print("\nEnter your choice: ");
        int subchoice = read.nextInt();
        System.out.println("\nEnter plate number: ");
        String plate = read.next();
        System.out.println("\n Enter the new information that you want to edit: ");
        String information = read.next();
        vm.editVehicle(plate, information, subchoice);
    }

    private static void deleteVehicle(){
        System.out.println("\nEnter vehicle plate number to delete: ");
        String plate = read.next();
        vm.deleteVehicle(plate);
    }

    private static void addVehicle(){
        int passengers;
        int range;
        int capacity;
        double tankCapacity;
        System.out.println("\nEnter the type of vehicle: ");
        System.out.println("1. Gas car");
        System.out.println("2. Electric car");
        System.out.println("3. Diesel truck");
        System.out.println("4. Electric truck");
        int subchoice = read.nextInt();

        read.nextLine();
        System.out.println("\nEnter new vehicle make: ");
        String make = read.nextLine();
        System.out.println("Enter new vehicle model: ");
        String model = read.nextLine();
        System.out.println("Enter new vehicle year: ");
        int year = read.nextInt();

        switch (subchoice){
            case 1:
                System.out.println("Enter new vehicle maximum passengers: ");
                passengers = read.nextInt();
                vm.addVehicle(new Car(model, make, year, passengers, true));
                break;
                case 2:
                    System.out.println("Enter new vehicle maximum passengers: ");
                    passengers = read.nextInt();
                    System.out.println("Enter new vehicle range: ");
                    range = read.nextInt();
                    vm.addVehicle(new ElectricCar(model, make, year, passengers, range));
                    break;
                    case 3:
                        System.out.println("Enter new vehicle maximum capacity: ");
                        capacity = read.nextInt();
                        System.out.println("Enter new vehicle tank capacity: ");
                        tankCapacity = read.nextInt();
                        vm.addVehicle(new DieselTruck(model, make, year, capacity, tankCapacity));

                        break;
                        case 4:
                            System.out.println("Enter new vehicle maximum capacity: ");
                            capacity = read.nextInt();
                            System.out.println("Enter new vehicle range: ");
                            range = read.nextInt();

                            vm.addVehicle(new ElectricTruck(model, make, year, capacity, range));
                            break;
                            default:
                                System.out.println("\n Action canceled");
                                break;
        }

    }

    private static void leaseVehicle(){
        System.out.println("\nEnter vehicle plate number to lease: ");
        String plate = read.next();

            System.out.println("\nEnter client name: ");
            String clientName = read.next();
            System.out.println("Enter client address: ");
            String clientAddress = read.next();
            System.out.println("Enter client email: ");
            String clientEmail = read.next();
            System.out.println("Enter client phone: ");
            String clientPhone = read.next();

            cm.addLeasedVehicle(new Client(clientName, clientEmail, clientPhone, clientAddress), plate);

    }

    private static void returnVehicle(){
        System.out.println("\nEnter vehicle plate number to return: ");
        String plate = read.next();


            System.out.println("\nEnter client name: ");
            String clientName = read.next();
            System.out.println("Enter client address: ");
            String clientAddress = read.next();
            System.out.println("Enter client email: ");
            String clientEmail = read.next();
            System.out.println("Enter client phone: ");
            String clientPhone = read.next();

            cm.returnLeasedVehicle(new Client(clientName, clientEmail, clientPhone, clientAddress), plate);

    }

    private static void leasedVehicleByClient(){
        System.out.println("\n Enter client name");
        String clientName = read.next();
        System.out.println("Enter client email: ");
        String clientEmail = read.next();
        System.out.println("Enter client phone: ");
        String clientPhone = read.next();
        System.out.println("Enter client address: ");
        String clientAddress = read.next();

        cm.showAllLeasedVehiclesByAClient(new Client(clientName, clientEmail, clientPhone, clientAddress));
    }

}