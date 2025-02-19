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
