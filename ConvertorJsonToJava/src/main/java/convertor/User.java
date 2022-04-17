package convertor;

import java.util.List;
import java.util.Map;

public class User {

    @JsonElement
    private String name;

    @JsonElement(key = "personAge")
    private Integer age;

    @JsonElement
    private String country;

    @JsonElement
    private String [] stringMass;

    @JsonElement
    private List<String> stringList;

    @JsonElement
    private Map<Object, Object> map;

    @JsonElement
    private Address address;


    public User(String name, Integer age, String country, String[] stringMass, List<String> stringList, Map<Object, Object> map, Address address) {
        this.name = name;
        this.age = age;
        this.country = country;
        this.stringMass = stringMass;
        this.stringList = stringList;
        this.map = map;
        this.address = address;
    }
}
