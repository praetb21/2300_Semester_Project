
package com.mycompany.militaryvehicledatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javafx.scene.control.TableView;


public class FileHandler {
    //*******************************************************************************************
    //*//////////////////////////////// VEHICLES ///////////////////////////////////////////////*
    //*******************************************************************************************

    // Scanner method to populate the table with info from the VehicleInfo.txt file
    public static void ScanVehicleFile( TableView<Vehicle> table) {
        File infoFile = new File("VehicleInfo.txt");    // Create a file object for the text file holding the vehicle information
        try {
            Scanner scanner = new Scanner(infoFile);        // Scan from that file
            while (scanner.hasNextLine()) {                 // While there is info in the file...
               
                String line = scanner.nextLine();           // Scan line by line
                String[] vehicleEntry = line.split(",");    // Create vehicleEntry array by splitting up the file line by CSV (comma-separated values)
                String name = vehicleEntry[0];              // Takes the 0th index of array vehicleEntry and assigns it as the company name
                String manufacturer = vehicleEntry[1];              // Takes the 1st index and assigns it as the manufacturer
                double cost = Double.parseDouble(vehicleEntry[2]);  // Takes the 2nd index and assigns it as the cost
                int year = Integer.parseInt(vehicleEntry[3]);       // Takes the 3rd index and assigns it as the year introduced
                String description = vehicleEntry[4];               // Takes the 4th index and assigns it as the descripton
                //***************************************** Can add more entries here later

                Vehicle vehicle = new Vehicle(name, manufacturer, cost, year, description); // Creates a vehicle object with the scanned in values
                table.getItems().add(vehicle);                           // and adds it to the table
            }
            scanner.close();                                // Close the scanner to prevent data leak

        } catch (FileNotFoundException ex) {                // Catch portion of our try-catch to catch file not found errors
            ex.printStackTrace();
        }
    }
    
    
    // SaveVehicleFile method so that changes made to the table can be wrote to the 
    //  .txt file and be saved for next time the program is run
    public static void SaveVehicleFile(TableView<Vehicle> table){

        try { 
            FileWriter saveFile = new FileWriter("VehicleInfo.txt");   // Create a saveFile "VehicleInfo.txt" object of type FileWriter 
            for (Vehicle vehicle : table.getItems()){                  // Reads through every vehicle in the table
                saveFile.write(vehicle.getName() + "," 
                        + vehicle.getManufacturer() + "," 
                        + vehicle.getCost()+ ","
                        + vehicle.getYearIntroduced() + ","
                        + vehicle.getDescription() + "\n"); //and writes their information (name, manufacturer,cost, yearIntroduced, description) to the saveFile
            }
            saveFile.close();   //Prevent data leak
            
        } catch (IOException ex) { // Potentially Catch IO errors
            ex.printStackTrace();
        }
    }
    
    // Method to remove a vehicle from the table
    public static void RemoveVehicle(TableView<Vehicle> table){
        Vehicle selectedVehicle = table.getSelectionModel().getSelectedItem();      // Highlighting a vehicle on the table is deemed the "selectedVehicle"
        table.getItems().remove(selectedVehicle);                                   // Removes the selectedVehicle
    }
    
    
    
    //*******************************************************************************************
    //*//////////////////////////////// COMPANIES //////////////////////////////////////////////*
    //*******************************************************************************************
    
    // Scanner method to populate the table with info from the VehicleInfo.txt file
    public static void ScanManufacturerFile( TableView<Manufacturer> table) {
        File infoFile = new File("ManufacturerInfo.txt");
        try {
            Scanner scanner = new Scanner(infoFile);
            while (scanner.hasNextLine()) {
               
                String line = scanner.nextLine();           // Scan line by line
                String[] manufacturerEntry = line.split(",");    // Create String array by splitting up the line by CSV
                String company = manufacturerEntry[0];              // Assign 0th index to manufacturer
                String location = manufacturerEntry[1];              //1st index to location
                String product = manufacturerEntry[2];              //2nd index to product
                int yearFounded = Integer.parseInt(manufacturerEntry[3]);
                //***************************************** Can add more entries here later

                Manufacturer manufacturer = new Manufacturer(company, location, product, yearFounded); // Creates a manufacturer entry with given company, location, product info
                table.getItems().add(manufacturer);                                       // adds manufactuer to the table
            }
            scanner.close();    // Prevent data leak

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
    // Writes table data to a text file to save it for future use
    public static void SaveManufacturerFile(TableView<Manufacturer> table){

        try { 
            FileWriter saveFile = new FileWriter("ManufacturerInfo.txt");     // Create a FileWriter object saveFile named "ManufacturerInfo.txt"
            for (Manufacturer manufacturer : table.getItems()){
                saveFile.write(manufacturer.getCompany() + "," 
                        + manufacturer.getLocation() + "," 
                        + manufacturer.getProduct()+ ","
                        + manufacturer.getYearFounded() +"\n");
            }
            saveFile.close();       //Prevent data leak
            
        } catch (IOException ex) {  // Catch IO errors
            ex.printStackTrace();
        }
    }
    
    // Method to remove a manufacturer from the company table
    public static void RemoveManufacturer(TableView<Manufacturer> table){
        Manufacturer selectedManufacturer = table.getSelectionModel().getSelectedItem();    // Highlighting a company on the table 
        table.getItems().remove(selectedManufacturer);                                      // removes the highlighted company from the table
    }
}
