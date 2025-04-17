

package com.mycompany.militaryvehicledatabase;


public class Vehicle {
    
    private String name;
    private String manufacturer;
    private double cost;
    private int yearIntroduced;
    private String description;

    
    public Vehicle() {
        this.name = "";
        this.manufacturer = "";
        this.cost = 0;
        this.yearIntroduced = 0;
        this.description = "";
    }
    
    public Vehicle(String name, String manufacturer, double cost, int yearIntroduced,String description) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.cost = cost;
        this.yearIntroduced = yearIntroduced;
        this.description = description;
    }

    
    
    //****************************************************//
    //Getters and setters for name, manufacturer, and cost
    //****************************************************//
    public String getName() {
        return name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getCost() {
        return cost;
    }
    
    public int getYearIntroduced() {
        return yearIntroduced;
    }
    
    public String getDescription(){
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setYearIntroduced(int yearIntroduced) {
        this.yearIntroduced = yearIntroduced;
    }
    
    public void setDescription(String description){
        this.description = description;
    }
     
}
