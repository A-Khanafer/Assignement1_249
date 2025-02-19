//----------------------------------------------------------------------------
// Assignment #1
// Question: Driver Class
// Written by: Ahmad Khanafer (40312768) & Abed-Elmouhsen Cherkawi (40323359)
//----------------------------------------------------------------------------

package Driver;

import vehicles.DieselTruck;
import vehicles.ElectricTruck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Unilla Car Lease Services, by Khanafer and Cherkawi!");
        boolean quit = false;
        int choice = 0;
        while (!quit) {
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
        }





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
    }
