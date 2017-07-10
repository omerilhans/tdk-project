package test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
       String text = "a r b k c d se ffff g a d f s s ffff d s ft ft gh ffff ws w ffff ffff ffff v x s g h d h j j k f sd j e wed a d f";
        getFindMostWords(text);
    }

    public static void getFindMostWords( String text ) {
        
        List<String> list = Arrays.asList(text.split(" "));

        List<TekrarlayanKelimeler> tkList = new ArrayList<>();
        List<TekrarlayanKelimeler> tkList5 = new ArrayList<>();
        List<Integer> tkNumberList = new ArrayList<>();

        Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
            int frekans = Collections.frequency(list, word);
            TekrarlayanKelimeler tk = new TekrarlayanKelimeler();
            tk.setKelime(word);
            tk.setTekrarMiktari(frekans);
            tkList.add(tk);
            tkNumberList.add(frekans);
        }

        int[] tkNumberListArr = new int[tkNumberList.size()];
        for (int i = 0; i < tkNumberList.size(); i++) {
            tkNumberListArr[i] = tkNumberList.get(i);
        }
        
        Arrays.sort(tkNumberListArr);

        for (int i = tkNumberListArr.length-1 ; i >= 0; i--) {
//            System.out.println(tkNumberListArr[i]);
        }
        
        for (int i = 0; i < tkList.size(); i++) {
            TekrarlayanKelimeler tk = tkList.get(i);

            for (int j = tkNumberListArr.length -1; j >=0; j--) {
                if (tk.getTekrarMiktari() == tkNumberListArr[j]) {
                    tkList5.add(tk);
                }
            }
        }

        for (int i = 0; i < tkList5.size(); i++) {
            TekrarlayanKelimeler tk = tkList5.get(i);
            System.out.println( tk.getKelime() + " : " + tk.getTekrarMiktari());
        }
    }
    
    public static void get(int[] arr){
        ArrayList<Integer> arrList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            arrList.add(arr[i]);
        }
        
        ArrayList<Integer> newArr = new ArrayList<>();
        for (int i = 0; i < arrList.size(); i++) {
            int num1 = arrList.get(i);
            
            for (int j = 0; j < arrList.size(); j++) {
                int num2 = arrList.get(j);
                
                if(arrList.contains(num1)){
                    
                }
            }
        }
        
    }
    
}
