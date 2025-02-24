//----------------------------------------------------------------------------
// Assignment #1
// Question: Driver Class
// Written by: Ahmad Khanafer (40312768) & Abed-Elmouhsen Cherkawi (40323359)
//----------------------------------------------------------------------------

package Driver;

import clients.Client;
import clients.ClientManager;
import vehicles.DieselTruck;
import vehicles.ElectricTruck;


import java.util.Scanner;

public class Main {
    static Scanner read = new Scanner(System.in);
    static ClientManager cm = new ClientManager();
    public static void main(String[] args) {

        String clientPhone;
        String clientName;
        String clientAddress;
        String clientEmail;



        System.out.println("Welcome to Unilla Car Lease Services, by Khanafer and Cherkawi!");
        boolean quit = false;
        int choice = 0;
        while (!quit) {
            display();

            switch(choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
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
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
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
        System.arraycopy(Trucks, 0, copiedElec, 0, Trucks.length);
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
        String clientEmail = read.nextLine();

        System.out.print("Enter client phone number: ");
        String clientPhone = read.nextLine();

        System.out.print("Enter client address: ");
        String clientAddress = read.nextLine();

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
        System.out.println("\nEnter your choice\n");
        System.out.println("Vehicle Management:");
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
    }

}