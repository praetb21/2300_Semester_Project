
package com.mycompany.militaryvehicledatabase;


public class Manufacturer {
    private String company;
    private String location;
    private String product; // Product or service (ie consulting)
    private int yearFounded;

    public Manufacturer() {
    this.company = "";
    this.location = "";
    this.product = "";
    this.yearFounded = 0;
    }

    public Manufacturer(String companyName, String location, String product, int yearFounded) {
        this.company = companyName;
        this.location = location;
        this.product = product;
        this.yearFounded = yearFounded;
    }

    public String getCompany() {
        return company;
    }

    public String getLocation() {
        return location;
    }
    
    public String getProduct() {
        return product;
    }
    
    public int getYearFounded() {
        return yearFounded;
    }
    
    public void setCompany(String companyName) {
        this.company = companyName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setYearFounded(int yearFounded) {
        this.yearFounded = yearFounded;
    }
}
