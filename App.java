package com.mycompany.militaryvehicledatabase;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) {
       
        // TableView tutorial: https://www.youtube.com/watch?v=vego72w5kPU
        TableView<Vehicle> vehicleTable = Tables.createVehicleTable();                  // Calls Tables class to create vehicleTable
        TableView<Manufacturer> manufacturerTable = Tables.createManufacturerTable();   // Calls Tables class to create manufacturerTable

        FileHandler.ScanVehicleFile(vehicleTable);              // Calls FileHandler class to read in VehicleInfo.txt into the vehicle table
        FileHandler.ScanManufacturerFile(manufacturerTable);    // Calls FileHandler class to read in ManufacturerInfo.txt into the manufacturer table

        
        // Vehicle Labels and Text Fields:
        Label lbl_Vehicle = new Label("Vehicle Table:");    // Label to indicate Vehicle Table
        HBox vehicleFields = new HBox(10);                  // Horizontal group for vehicle fields (labels and text fields)
        lbl_Vehicle.setFont(Font.font("System", 16)); // Make "Vehicle Table" large

        Label lbl_name = new Label("Name: ");               // Name label
        TextField txt_name = new TextField();               // Name text field
        txt_name.setPrefWidth(120);                         // and width

        Label lbl_manufacturer = new Label("Manufacturer: ");   // Manufacturer label
        TextField txt_manufacturer = new TextField();           // Manufacturer text field
        txt_manufacturer.setPrefWidth(120);                     // and width

        Label lbl_cost = new Label("Cost: ");               // Cost label
        TextField txt_cost = new TextField();               // Cost text field
        txt_cost.setPrefWidth(40);                          // and width

        Label lbl_year = new Label("Year: ");               // Year label
        TextField txt_year = new TextField();               // Year text field
        txt_year.setPrefWidth(60);                          // and width
        
        Label lbl_description = new Label("Description");
        TextField txt_description = new TextField();
        txt_description.setPrefWidth(190);
        


        vehicleFields.getChildren().addAll(lbl_name, txt_name, 
                                           lbl_manufacturer, txt_manufacturer, 
                                           lbl_cost, txt_cost,
                                           lbl_year, txt_year,
                                           lbl_description, txt_description);  //add labels and text fields to vehicleFields group

        // Companies Labels and Text Fields:
        Label lbl_Companies = new Label("Company Table:");       // Label to indicate Companies Table
        HBox companyFields = new HBox(10);                        // Horizontal group for companies fields (labels and text fields)
        lbl_Companies.setFont(Font.font("System", 16));           // Make "Companies Table" larger


        Label lbl_company = new Label("Company: ");              // Company name label
        TextField txt_company = new TextField();                 // Company name text field
        txt_company.setPrefWidth(140);                           // and width
        
        Label lbl_location = new Label("Location: ");            // Company location label
        TextField txt_location = new TextField();                // Company location text field
        txt_location.setPrefWidth(140);                          // and width

        Label lbl_product = new Label("Product/Service: ");      // Company product/services label
        TextField txt_product = new TextField();                 // Company product/services text field
        txt_product.setPrefWidth(200);                           // and width

        Label lbl_yearFounded = new Label("Founded: ");          // Year founded label
        TextField txt_yearFounded = new TextField();             // Year founded text field
        txt_yearFounded.setPrefWidth(60);                        // and width


        companyFields.getChildren().addAll(lbl_company, txt_company, 
                                           lbl_location, txt_location, 
                                           lbl_product, txt_product,
                                           lbl_yearFounded, txt_yearFounded); //add labels and fields to companyFields group

        
        
        // Create a horizontal vehicle_Buttons group
        HBox vehicle_Buttons = new HBox(10);

        // Vehicle Table: "Add Vehicle" Button
        Button btn_addVehicle = new Button("Add Vehicle"); // Create button labeled "Add Vehicle"

        btn_addVehicle.setOnAction(e -> {                           // when this button is clicked,
            String name = txt_name.getText();                       // it gets the text from textfield txt_name,
            String manufacturer = txt_manufacturer.getText();       // txt_manufacturer, txt_cost, txt_year, and 
            String cost_text = txt_cost.getText();                  // assigns them to name, manufacturer, cost, and year variables..
            int year = Integer.parseInt(txt_year.getText());
            String description = txt_description.getText();

            double cost = Double.parseDouble(cost_text);  // (need to convert string to double)
            Vehicle vehicle = new Vehicle(name, manufacturer, cost, year, description);    //  ..which are used to initialize a new vehicle object
            vehicleTable.getItems().add(vehicle);                       // which is then added to the vehicle table

            txt_name.clear();                                       // then it clears the text fields that were just used
            txt_manufacturer.clear();                               // so that additional entries can be made
            txt_cost.clear();
            txt_year.clear();
            txt_description.clear();
        });

        // Vehicle Table: "Save" Button
        Button btn_save = new Button("Save");           // Create button labeled "Save"
        btn_save.setOnAction(e -> {                     // when this button is clicked
            FileHandler.SaveVehicleFile(vehicleTable);  // call the FileHandler class to run the SaveVehicleFile method

        });

        // Vehicle Table: "Remove Vehicle" Button
        Button btn_remove = new Button("Remove Vehicle");   // Create a button labeled "Remove Vehicle"
        btn_remove.setOnAction(e -> {                       // when this button is clicked
            FileHandler.RemoveVehicle(vehicleTable);        // call the FileHandler class to run the RemoveVehicle method
        });
        
        // Vehicle Table: Add all buttons to vehicle_Buttons group
        vehicle_Buttons.getChildren().addAll(btn_addVehicle, btn_save, btn_remove);

        
        // Company Table: Creating the "Add Company" Button 
        Button btn_addCompany = new Button("Add Company");      // new button with the label "Add Company"

        btn_addCompany.setOnAction(e -> {                       // When this button is clicked
            String company = txt_company.getText();             // get the text from the text fields txt_company, 
            String location = txt_location.getText();           // txt_location, txt_product, txt_yearFounded  and assign them to 
            String product = txt_product.getText();             // variables company, location, product, yearFounded
            int yearFounded = Integer.parseInt(txt_yearFounded.getText());

            Manufacturer manufacturer = new Manufacturer(company, location, product, yearFounded);   // variable used to initialize a new manufacturer
            manufacturerTable.getItems().add(manufacturer);                             // which is then added to the table

            txt_company.clear();                                // The text fields are then cleared to allow for 
            txt_location.clear();                               // more entries
            txt_product.clear();
            txt_yearFounded.clear();
        });

        // Company Table: "Save" button
        Button btn_saveManufacturer = new Button("Save");       // Creates a new button labeled "Save"
        btn_saveManufacturer.setOnAction(e -> {                 // When this button is clicked
            FileHandler.SaveManufacturerFile(manufacturerTable);    // call the FileHandler class to save the manufacturerTable
        });
        //Company Table: "Remove Company" button
        Button btn_removeManufacturer = new Button("Remove Company");   // Create a "Remove Company" button 
        btn_removeManufacturer.setOnAction(e -> {                       // when clicked calls the FileHandler class
            FileHandler.RemoveManufacturer(manufacturerTable);          // to run a RemoveManufacturer method
        });

        // Company Table: companyButtons Group
        HBox companyButtons = new HBox(10);                             // create a horizontal group for the company buttons
        companyButtons.getChildren().addAll(btn_addCompany, btn_saveManufacturer, btn_removeManufacturer);  // add each button to group



        // Formatting the whole GUI:
        VBox layout = new VBox(5);
        layout.setPadding(new Insets(10,15,10,15)); // top, right, bottom, left

        layout.getChildren().addAll(lbl_Vehicle,        // Title - "Vehicle Table"
                                    vehicleTable,       // Table - VehicleInfo.txt
                                    vehicleFields,      // Labels and text fields
                                    vehicle_Buttons);   // Buttons - (add, save, remove)

        layout.getChildren().addAll(lbl_Companies,      // Title - "Company Table"
                                    manufacturerTable,  // Table - ManufacturerInfo.txt
                                    companyFields,      // Labels and text fields
                                    companyButtons);    // Buttons - (add, save, remove)

        // Create the scene
        Scene scene = new Scene(layout, 900, 600);      // Initial size
        stage.setTitle("Military Vehicle Database");    // Window title
        stage.setScene(scene);                          
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
