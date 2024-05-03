package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private String filePath;

    public FileKV(String filePath, Map<String, String> map) {
        this.filePath = filePath;
        String serializeContent = Utils.serialize(map);
        Utils.writeFile(this.filePath, serializeContent);
    }
    @Override
    public void set(String key, String value) {
        String content = Utils.readFile(this.filePath);
        Map<String, String> json = Utils.unserialize(content);
        json.put(key, value);
        String serializeContent = Utils.serialize(json);
        Utils.writeFile(this.filePath, serializeContent);
    }

    @Override
    public void unset(String key) {
        String content = Utils.readFile(this.filePath);
        Map<String, String> json = Utils.unserialize(content);
        json.remove(key);
        String serializeContent = Utils.serialize(json);
        Utils.writeFile(this.filePath, serializeContent);
    }

    @Override
    public String get(String key, String defaultValue) {
        String content = Utils.readFile(this.filePath);
        Map<String, String> json = Utils.unserialize(content);
        return json.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String content = Utils.readFile(this.filePath);
        return Utils.unserialize(content);
    }
}
// END
