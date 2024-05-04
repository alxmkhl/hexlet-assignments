package exercise;

class Address {
    // BEGIN
    
    // END
    @NotNull
    @MinLength(minLength = 4)
    private String country;

    // BEGIN
    
    // END
    @NotNull
    private String city;

    // BEGIN
    
    // END
    @NotNull
    private String street;

    // BEGIN
    
    // END
    @NotNull
    private String houseNumber;

    private String flatNumber;

    Address(String country, String city, String street, String houseNumber, String flatNumber) {
        this.country = country;
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.flatNumber = flatNumber;
    }
}
