package convertor;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Main {
    public static void main(String[] args) throws IOException, IllegalAccessException {

        String [] massString = new String[]{"16", "47", "76"};

        List<String> stringList = new ArrayList<>();
        stringList.add("123");
        stringList.add("456");
        stringList.add("789");

        Map<Object, Object> map = new HashMap<>();
        map.put("as1","qwe");
        map.put("as2","qwe");
        map.put("as3","qwe");

        String [] phone = new String[]{"164-23-24", "474-12-24", "762-53-53"};

        Address address = new Address("Minsk", "plekhanova", "103", phone);


        User user = new User("Ivan", 31, "Spb", massString, stringList, map, address);


        ObjectToJsonOld objectToJson = new ObjectToJsonOld();
        String jsonString = objectToJson.getJsonToString(user);
        System.out.println(jsonString);

        FileWriter fileWriter = new FileWriter("test-convert.json");
        fileWriter.write(jsonString);
        fileWriter.close();

    }
}
