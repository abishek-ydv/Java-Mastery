// import java.util.*;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
public class ArrayHashMap {
    public static void main(String[] args){
        Map<Integer, String> studentData = new HashMap<>();
        studentData.put(1, "Abhishek");
        System.out.println(studentData);
        System.out.println(studentData.get(1));
        System.out.println(studentData.containsKey(1));
        System.out.println(studentData.remove(1));
        System.out.println(studentData.put(01, "Naruto"));
        System.out.println(studentData);
        System.out.println(studentData.containsValue("Naruto"));
        System.out.println(studentData.size());
        System.out.println(studentData.remove(1));
        System.out.println(studentData.put(01, "Sasuke"));
        System.out.println(studentData.put(02, "Hinata"));
        System.out.println(studentData.put(03, "Naruto"));
        System.out.println(studentData.put(04, "Rock Lee"));
        System.out.println(studentData);
        System.out.println(studentData.isEmpty());

        System.out.println(studentData.keySet());
        System.out.println(studentData.values());
        System.out.println(studentData.entrySet());

        /* Looping */
        /* For Each - The Lambda Way */
        studentData.forEach((key,value) -> {
            System.out.println(String.format("%d %s", key, value));
        });

        /* The Fast Way */
        /* For Each - Entry & entrySet Way */
        for(Map.Entry<Integer, String> entry : studentData.entrySet()){
            System.out.println(String.format("%d %s", entry.getKey(), entry.getValue()));
        }

        /* Key Iteration */
        for(int i : studentData.keySet()){
            System.out.println(i);
        }

        /* Values Iteration */
        for(String i : studentData.values()){
            System.out.println(i);
        }

        /* The OG Way */
        Iterator<Map.Entry<Integer, String>> ele = studentData.entrySet().iterator();
        while (ele.hasNext()) {
            Map.Entry<Integer, String> entry = ele.next();
            if("Night".equals(entry.getValue())){
                ele.remove();
            }
        }

        System.out.println(studentData);

        /* The Easy Way */
        studentData.entrySet().removeIf(entry -> entry.getKey() == 1); //It is a collection method or tool we can say and since we converted our tree in entrySet we can use removeIf.
        System.out.println(studentData);

        /* Modern Methods */
        /* getOrDefault(Key, Default Value) : Usually when we use get if that key is not present in hashmap, hashmap return a null value which cause issue when we are performing math operations. */
        System.out.println(studentData.getOrDefault(2, "No Key Present"));

        /* putIfAbsent(key, Value) : In this method value will only update when the key is not already in hashmap. If key is present it's value will remain same and it's value will not update.*/
        studentData.putIfAbsent(1, "Anny");
        System.out.println(studentData);
        
        /* computeIfPresent(Key, remappingFunction) : In this function we compute the value or peform some task if the key is present. If key is absent nothing will happen. Since key is prsent it will already have some value, so in lambda function we can use key and value both. */
        studentData.computeIfPresent(1, (key, value) -> "Neji");
        System.out.println(studentData);
        
        /* computeIfAbsent(key, remappingFunciton) : In this function we compute the value or peform some task if the key is absent. If key is present nothing will happen. Since key is absent it dons't have the value so in lambda function we will only use key. */
        studentData.computeIfAbsent(420, k -> "New Ninja " + k);
        System.out.println(studentData);
        studentData.remove(420);
        
        /* compute(key, remappingFunction) : It perform compute operation regardless if the key is present or not. and it has both key and value. value will be null if key is absent. */
        studentData.compute(101, (key, value) -> {
            if(value == null) return "Unknown";
            else return value+"New Student";
        });
        System.out.println(studentData);
        
        /* Merge(key, newValue, remappingFunction) : So this basically checks if they key is present or not and if the key is presnet we can merge the old value with the new one. And if the key is absent it basically put the newValue and create a entry. */
        studentData.merge(1, " Huyga", (oldValue, newValue) -> oldValue + newValue);
        System.out.println(studentData);
        
        /* Replace(key, oldValue, newValue) : This method is used to replace the old value with the new one if the key is present and old Value matchs exact value. if no key present or old value is not same then nothing will happen.*/
        studentData.replace(101, "Unknown", "Gara");
        System.out.println(studentData);
        
        /* replaceAll(remappingFunction) : This method used to update all values in the map based on the logic. */
        studentData.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(studentData);
        
        /* Map Of */
        Map<Integer, String> constants = Map.of(1, "Alpha", 2, "Beta", 3, "Gamma");
        System.out.println(constants);
        
        /* putAll(otherMap) : This method is used to take every entry from a map and put it into another. and if they key is two entry have same key it will take the value from the new map.*/
        studentData.putAll(constants);
        studentData.replaceAll((key, value) -> value.toUpperCase());
        System.out.println(studentData);
        studentData.clear();      
        System.out.println(studentData);      
    }
}
