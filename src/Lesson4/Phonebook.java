package Lesson4;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {

    private HashMap<String, String> newPhonebookHashMap = new HashMap<>();

    public void add (String phoneNumber, String name){
        newPhonebookHashMap.put(phoneNumber,name);
    }

    public void get(String name) {
        boolean chk = false;
        for (Map.Entry<String, String> o : newPhonebookHashMap.entrySet()) {
            if (name.equals(o.getValue())){
                System.out.println(o.getKey() + ": " + o.getValue());
                chk = true;
            }

        }
        if (!chk){
            System.out.println("Телефон не найден");
        }

    }
}
