package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address address) {
        try {
            List<String> fieldList = new ArrayList<>();
            var fields = address.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String value = (String) field.get(address);
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    fieldList.add(field.getName());
                }
            }
            return fieldList;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        var result = new HashMap<String, List<String>>();
        try {
            var fields = address.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String value = (String) field.get(address);
                if (field.isAnnotationPresent(NotNull.class) && value == null) {
                    if (result.get(field.getName()) == null) {
                        result.put(field.getName(), new ArrayList<>());
                    }
                    var listOfMessages = result.get(field.getName());
                    listOfMessages.add("can not be null");
                    result.put(field.getName(), listOfMessages);
                }
            }

            for (Field field : fields) {
                field.setAccessible(true);
                String value = (String) field.get(address);

                if (field.isAnnotationPresent(MinLength.class)
                ) {
                    MinLength minLengthAnnotation = field.getAnnotation(MinLength.class);
                    if (value!= null && value.length() < minLengthAnnotation.minLength()) {
                        System.out.println(minLengthAnnotation.minLength());
                        result.put(field.getName(), new ArrayList<>());

                        if (result.get(field.getName()) == null) {
                            result.put(field.getName(), new ArrayList<>());
                        }
                        var listOfMessages = result.get(field.getName());
                        listOfMessages.add("length less than 4");
                        result.put(field.getName(), listOfMessages);

                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
// END
