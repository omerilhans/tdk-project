package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test8 {
    
   static String text = "11 22 22 22 22 22 aa aa aa bb bb bb bb cc cc ee aaaa aaaa aaaa aaaa aa kk ttt kk ttt lll lll lll";

    public static void main(String[] args) {

        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        List<Map.Entry<String, Long>> result = getFindMostWords(text);

        for (int i = 0; i < result.size(); i++) {
            Map.Entry<String, Long> mapping = result.get(i);
            System.out.println(mapping.getKey() + " : " + mapping.getValue());
        }

    }

    public static List<Map.Entry<String, Long>> getFindMostWords(String text) {
        String[] arr = text.split(" ");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        
        Map<String, Long> map = list.stream()
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));

        List<Map.Entry<String, Long>> result = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(5)
                .collect(Collectors.toList());

        return result;
    }
}
