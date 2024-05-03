package exercise;

import java.util.*;
import java.util.Map.Entry;

// BEGIN
public class App {
    public static void main(String[] args) {
        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
        // Получение значения по ключу
        storage.get("key", "default"); // "value"
        System.out.println(storage.get("key", "default"));
    }

    public static void swapKeyValue (KeyValueStorage map) {
        HashMap<String,String> rev = new HashMap<String, String>();
        for(Map.Entry<String,String> entry : map.toMap().entrySet()) {
            rev.put(entry.getValue(), entry.getKey());
            map.unset(entry.getKey());
            map.set(entry.getValue(), entry.getKey());
        }
    }

}
// END
