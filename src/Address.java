public class Address{
    private String city;
    private String street;
    private String doorNumber;

    public Address(){}

    public Address(String city, String street, String doorNumber){
        this.city = city;
        this.street = street;
        this.doorNumber = doorNumber;
    }

    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getDoorNumber() {
        return doorNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setDoorNumber(String doorNumber) {
        this.doorNumber = doorNumber;
    }

    public String toString(){
        return "Address[city=" + city + ", street=" + street + ", doorNumber=" + doorNumber + "]";
    }
}
