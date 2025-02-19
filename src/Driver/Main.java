//----------------------------------------------------------------------------
// Assignment #1
// Question: Driver Class
// Written by: Ahmad Khanafer (40312768) & Abed-Elmouhsen Cherkawi (40323359)
//----------------------------------------------------------------------------

package Driver;

import vehicles.ElectricTruck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Unilla Car Lease Services, by Khanafer and Cherkawi!");





        }

        public static void getLargestTruck() {

        }

    public ElectricTruck[] copyVehicles(ElectricTruck[] electricTrucks) {
        ElectricTruck[] copiedElec = new ElectricTruck[electricTrucks.length];
        System.arraycopy(electricTrucks, 0, copiedElec, 0, electricTrucks.length);
        return copiedElec;
    }
    }
