package exercise.model;

import exercise.annotation.Inspect;

public class Address {
    private String city;
    private int postalCode;

    public Address(String city, int postalCode) {
        this.city = city;
        this.postalCode = postalCode;
    }

    // BEGIN
    
    // END
    @Inspect
    public String getCity() {
        return city;
    }

    // BEGIN
    
    // END
    @Inspect
    public int getPostalCode() {
        return postalCode;
    }

    public String getFullAddress() {
        return city + " " + postalCode;
    }
}
