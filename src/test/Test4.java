package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {

    static String text = "aa aa aa bb bb bb bb cc dd dd dd dd dd dd ff ff rr";

    public static void main(String[] args) {

        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Map<String, Integer> stringsCount = new HashMap<>();
// And iterate over your array filling this map:

        for (String s : list) {
            Integer c = stringsCount.get(s);
            if (c == null) {
                c = new Integer(0);
            }
            c++;
            stringsCount.put(s, c);
        }
// Finally, you can get the most repeated element iterating over the map:

        Map.Entry<String, Integer> mostRepeated = null;
        for (Map.Entry<String, Integer> e : stringsCount.entrySet()) {
            if (mostRepeated == null || mostRepeated.getValue() < e.getValue()) {
                mostRepeated = e;
            }
        }
//And show the most common string:

        if (mostRepeated != null) {
            System.out.println("Most common string: " + mostRepeated.getKey());
        }

    }

}
