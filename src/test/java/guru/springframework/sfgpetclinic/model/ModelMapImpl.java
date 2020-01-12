package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.fauxspring.Model;

import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model {

    private Map<String, Object> hashMap = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        hashMap.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        hashMap.put(null, o);
    }

    public Map getHashMap() {
        return hashMap;
    }

}
