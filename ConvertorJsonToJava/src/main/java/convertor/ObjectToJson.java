package convertor;

import java.lang.reflect.Field;
import java.util.*;

//https://www.youtube.com/watch?v=awmTV6BuV9U

public class ObjectToJson {

    /*public String convertToJson(Object o){
        try {
            return getJsonToString(o);
        }catch (Exception e){
            throw new RuntimeException("converting has been broken");
        }
    }*/

    public String getJsonToString(Object o) throws IllegalAccessException {
        Class<?> clazz = o.getClass();
        Map<String, String> jsonElement = new HashMap<>();
        //находим все поля класса
        for (Field field : clazz.getDeclaredFields()){
            // получаем значения даже приватных полей
            field.setAccessible(true);
            //проверяем есть ли аннотация над полем
            if (field.isAnnotationPresent(JsonElement.class)){

            StringBuilder value = new StringBuilder("");
            //System.out.println(field.getName());
            //System.out.println(field.get(o).getClass().getSimpleName());

            if (field.get(o) == null){
                continue;
            }

            if (field.get(o) instanceof String || field.get(o) instanceof Character ||
                    field.get(o) instanceof Number || field.get(o) instanceof Boolean) {
                value = new StringBuilder("\""+field.get(o)+"\"");
            }

            else if (field.get(o) instanceof Number || field.get(o) instanceof Boolean) {
                value = new StringBuilder(field.get(o).toString());
            }

            else if (field.get(o).getClass().isArray()){
                value = value.append("[ ");
                for (Object o1 : ((Object[]) field.get(o))) {
                    value = value.append("\"").append(o1).append("\"").append(",").append(" ");
                }
                value.deleteCharAt(value.length()-2);
                value = value.append("]");
            }

            else if (field.get(o) instanceof List<?>){
                value = value.append("[ ");
                for (Object s : (List<Object>) field.get(o)) {
                    value = value.append("\"").append(s).append("\"").append(",").append(" ");
                }
                value.deleteCharAt(value.length()-2);
                value = value.append("]");
            }

            else if (field.get(o) instanceof Map<?, ?>) {
                value = value.append("{ ");
                Map<Object,Object> map = (Map<Object, Object>) field.get(o);
                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    value = value.append("\"").append(entry.getKey()).append("\": ").
                            append("\"").append(entry.getValue()).append("\"").append(",").append(" ");
                }
                value.deleteCharAt(value.length()-2);
                value = value.append("}");
            }

            else  {
                value = value.append(getJsonToString(field.get(o)));
            }

                jsonElement.put(getKey(field), String.valueOf(value));
            }
        }
        //соединяем строки
        StringJoiner joiner = new StringJoiner(",");
        for (Map.Entry<String, String> entry : jsonElement.entrySet()) {
            if (entry.getValue().charAt(0) == '['){
                String s = "\"" + entry.getKey() + "\":" + entry.getValue() +"";
                joiner.add(s);
            }
            else {
                String s = "\"" + entry.getKey() + "\":" + entry.getValue() +"";
                joiner.add(s);
            }
        }
        String jsonString = joiner.toString();
        return "{" + jsonString +"}";
    }

    //устанавливаем значение поля как в аннотации
    private String getKey(Field field){
        JsonElement jsonElement = field.getAnnotation(JsonElement.class);
        String key = jsonElement.key();
        if (key.equals("")){
            return field.getName();
        }else{
            return key;
        }
    }
}
