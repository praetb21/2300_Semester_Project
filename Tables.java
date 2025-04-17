
package com.mycompany.militaryvehicledatabase;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class Tables {
    
    public static TableView<Vehicle> createVehicleTable(){
        
        // Create a TableView
        TableView<Vehicle> table = new TableView<>();
        
        // Create columns and cell factory for each
        TableColumn nameColumn = new TableColumn<Vehicle,String>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("name"));
        
        TableColumn manufacturerColumn = new TableColumn<Vehicle,String>("Manufacturer");
        manufacturerColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("manufacturer"));
        
        TableColumn costColumn = new TableColumn<Vehicle,String>("Cost");
        costColumn.setCellValueFactory(new PropertyValueFactory<Vehicle,String>("cost"));
        
        TableColumn<Vehicle, Integer> yearColumn = new TableColumn<>("Year Introduced");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("yearIntroduced"));
        
        TableColumn<Vehicle, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
                
        // Add columns to table
        table.getColumns().addAll(nameColumn, manufacturerColumn, costColumn, yearColumn, descriptionColumn);
  
        return table;
        
    }

    static TableView<Manufacturer> createManufacturerTable() {
        
        TableView<Manufacturer> table = new TableView<>();
    
        TableColumn companyColumn = new TableColumn<Manufacturer,String>("Company");
        companyColumn.setCellValueFactory(new PropertyValueFactory<Manufacturer,String>("company"));
        
        TableColumn locationColumn = new TableColumn<Manufacturer,String>("Location");
        locationColumn.setCellValueFactory(new PropertyValueFactory<Manufacturer,String>("location"));

        TableColumn productColumn = new TableColumn<Manufacturer,String>("Product/Service");
        productColumn.setCellValueFactory(new PropertyValueFactory<Manufacturer,String>("product"));
        
        TableColumn<Manufacturer, Integer> yearFoundedColumn = new TableColumn<>("Year Founded");
        yearFoundedColumn.setCellValueFactory(new PropertyValueFactory<>("yearFounded"));
    
        table.getColumns().addAll(companyColumn, locationColumn, productColumn, yearFoundedColumn);
        
        return table;

    }
    
    
}
