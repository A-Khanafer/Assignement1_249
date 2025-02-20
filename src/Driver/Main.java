//----------------------------------------------------------------------------
// Assignment #1
// Question: Driver Class
// Written by: Ahmad Khanafer (40312768) & Abed-Elmouhsen Cherkawi (40323359)
//----------------------------------------------------------------------------

package Driver;

import clients.Client;
import clients.ClientManager;
import vehicles.DieselTruck;
import vehicles.ElectricCar;
import vehicles.ElectricTruck;
import vehicles.VehicleManagement;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        ElectricTruck electricTruck = new ElectricTruck("allooooo" , "jayz" , 2 , 2000 , 25.0);
        ElectricCar electricCar = new ElectricCar("anvwojnev" , "1oakvnr" , 43 , 9032 , 25.0);
        DieselTruck dieselTruck = new DieselTruck("bbbb" , "bang" , 12 , 314 , 100.0);

        VehicleManagement vehicleManagement = new VehicleManagement();

        vehicleManagement.addVehicle(electricTruck);
        vehicleManagement.addVehicle(electricCar);
        vehicleManagement.addVehicle(dieselTruck);
        vehicleManagement.addVehicle(dieselTruck);

        System.out.println(vehicleManagement);

//        System.out.println(vehicleManagement);













//        String clientPhone;
//        String clientName;
//        String clientAddress;
//        String clientEmail;
//
//        ClientManager cm = new ClientManager();
//        Scanner read = new Scanner(System.in);
//        System.out.println("Welcome to Unilla Car Lease Services, by Khanafer and Cherkawi!");
//        boolean quit = false;
//        int choice = 0;
//        int subchoice = 0;
//        while (!quit) {
//            System.out.println("\nEnter your choice\n");
//            System.out.println("Vehicle Management:");
//            System.out.println("1. Add a vehicle");
//            System.out.println("2. Delete a vehicle");
//            System.out.println("3. Update vehicle information");
//            System.out.println("4. List all vehicles by category (electric trucks, diesel trucks, etc.)");
//
//            System.out.println("\nClient Management:");
//            System.out.println("5. Add a client");
//            System.out.println("6. Edit a client");
//            System.out.println("7. Delete a client");
//
//            System.out.println("\nLeasing Operations:");
//            System.out.println("8. Lease a vehicle to a client");
//            System.out.println("9. return a vehicle from a client");
//            System.out.println("10. Show all vehicles leased by a client");
//            System.out.println("11. Show all leased vehicles (by all clients)");
//
//            System.out.println("\nAdditional operations:");
//            System.out.println("12. Display the truck with the largest capacity");
//            System.out.println("13. Create a copy of the electric trucks array");
//
//            System.out.println("\n0. Exit");
//
//            switch(choice){
//                case 1:
//                    break;
//                case 2:
//                    break;
//                case 3:
//                    break;
//                case 4:
//                    break;
//
//                case 5:
//                    System.out.println("\nTo cancel the operation, press 1, to continue, press 5\n");
//                        read.nextLine();
//                        subchoice = read.nextInt();
//
//                        if(subchoice == 1){break;}
//
//                        if(subchoice == 5){
//                    System.out.print("Enter client name: ");
//                         clientName = read.nextLine();
//
//                    System.out.println("Enter client email: ");
//                         clientEmail = read.nextLine();
//
//                    System.out.print("Enter client phone number: ");
//                         clientPhone = read.nextLine();
//
//                    System.out.print("Enter client address: ");
//                         clientAddress = read.nextLine();
//
//                    addClient(cm, clientName, clientEmail, clientPhone, clientAddress);
//                    break;}
//
//                case 6:
//                    System.out.println("\nTo cancel the operation, press 1, to continue, press 6\n");
//                    read.nextLine();
//                            subchoice = read.nextInt();
//                            if(subchoice == 1){break;}
//                            if(subchoice == 6){
//                    System.out.print("Enter client name: ");
//                     clientName = read.nextLine();
//
//                    System.out.println("Enter client email: ");
//                     clientEmail = read.nextLine();
//
//                    System.out.print("Enter client phone number: ");
//                     clientPhone = read.nextLine();
//
//                    System.out.print("Enter client address: ");
//                     clientAddress = read.nextLine();
//
//                    deleteClient(cm, clientName, clientEmail, clientPhone, clientAddress);
//
//                            }
//
//                    break;
//                case 7:
//                    break;
//                case 8:
//                    break;
//                case 9:
//                    break;
//                case 10:
//                    break;
//                case 11:
//                    break;
//                case 12:
//                    break;
//                case 13:
//                    break;
//                case 0:
//                    quit = true;
//                    break;
//                default:
//                    System.out.println("\nInvalid choice");
//                    break;
//
//            }
//        }
//        System.out.println("Goodbye!");
//
//


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
        System.arraycopy(Trucks, 0, copiedElec, 0, Trucks.length);
        return copiedElec;
    }


    private static void addClient(ClientManager cm, String name, String email, String phoneNumber, String address) {
        cm.addClient(name,email,phoneNumber,address);
    }

    private static void deleteClient(ClientManager cm, String name, String email, String phoneNumber, String address) {
        cm.deleteClient(name,email,phoneNumber,address);
    }

}