package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MainTest1 {
    
   static String text = "there was a problem with women's outdoor gear long before the industry starting “shrinking and pinking” equipment to fit women.\n" +
"“I’ve had the fortune of being at REI for 20 years,” says Viscon, the company's Senior Vice President of Merchandising. “At that time I remember buying a unisex Gore-Tex jacket. It fit like a garbage sack.”\n" +
"Thus began Viscon’s two-decade quest to recreate apparel, backpacks, sleeping bags, hiking boots, and other products, designed specifically for women. Thanks to her and a small cadre of industry visionaries, women’s backpacks today have more anatomically suitable hip belts; women’s sleeping bags add insulation in all the right places; even some women’s hiking boots have been created for women from the ground up, rather than building on the industry standard for men.\n" +
"“Not everything has to have a gender lens on it,” says Viscon. “Only products where women are benefited by performance and comfort.”\n" +
"In May, REI launched its women-focused “Force of Nature” campaign, acknowledging women’s place in adventure sports and athletics. The campaign dovetails an industry shift: The same month, Outside magazine proclaimed on its cover that the “Future of Adventure is Female.” And on June 15, bike maker Specialized unveiled the Women’s Diverge, a high-end adventure bike for the distaff side. There’s no doubt that ladies are crushing it. But women’s gear, which has notoriously lagged behind men’s, is just now catching up.";

    public static void main(String[] args) {
        
        getFindMostWords(text);
        
        
    }
    
    public static List<MostWords> getFindMostWords(String text) {
        List<String> list = Arrays.asList(text.split(" "));
        List<MostWords> tkList = new ArrayList<>();
        List<MostWords> tkList5 = new ArrayList<>();
        List<Integer> tkNumberList = new ArrayList<>();
        Set<String> uniqueWords = new HashSet<String>(list);

        for (String word : uniqueWords) {
            int frekans = Collections.frequency(list, word);
            MostWords tk = new MostWords();
            tk.setWord(word);
            tk.setRepeatCount(frekans);
            tkList.add(tk);
            tkNumberList.add(frekans);
        }

        int[] tkNumberListArr = new int[tkNumberList.size()];
        for (int i = 0; i < tkNumberList.size(); i++) {
            tkNumberListArr[i] = tkNumberList.get(i);
        }

        Arrays.sort(tkNumberListArr);
        for (int i = 0; i < tkList.size(); i++) {
            MostWords tk = tkList.get(i);
            for (int j = tkNumberListArr.length - 1; j > tkNumberListArr.length - 6; j--) {
                if (tk.getRepeatCount() == tkNumberListArr[j]) {
                    tkList5.add(tk);
                }
            }
        }

        int[] repeatNumbList = new int[5];
        for (int i = 0; i < 5; i++) {
            repeatNumbList[i] = tkList5.get(i).getRepeatCount();
        }
        Arrays.sort(repeatNumbList);
        ArrayList<MostWords> tkList5Revert = new ArrayList<>();
        for (int k=repeatNumbList.length-1;k>=0;k--) {
            int numb = repeatNumbList[k];

            for (int t=0; t<tkList5.size();t++) {
                MostWords mw = tkList5.get(t);
                if (mw.getRepeatCount() == numb){
                    tkList5Revert.add(mw);
                    break;
                }
            }
        }

        for (MostWords mw : tkList5Revert) {
            System.out.println("CCCE :"+mw.getWord() + " - " + mw.getRepeatCount());
        }

        return tkList5Revert;
    }

    
}
