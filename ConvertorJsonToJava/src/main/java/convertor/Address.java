package convertor;

public class Address {

    @JsonElement
    private String city;

    @JsonElement
    private String street;

    @JsonElement
    private String house;

    @JsonElement
    private String [] phone;


    public Address(String city, String street, String house, String[] phone) {
        this.city = city;
        this.street = street;
        this.house = house;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", house='" + house + '\'' +
                '}';
    }
}
