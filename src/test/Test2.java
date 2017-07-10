package test;

import java.util.ArrayList;
import java.util.Arrays;

public class Test2 {

//    static String text = "aa   aa aa bb bb bb bb cc cc ee aaaa aaaa aaaa aaaa aa kk ttt kk ttt lll lll lll";

    public static void main(String[] args) {

        getFindMostWords("");
    }

    public static ArrayList<Tekrar> getFindMostWords(String text) {
        ArrayList<Tekrar> tekrarList = new ArrayList();

        String[] wordArr = text.split(" ");
        for (int i = 0; i < wordArr.length; i++) {
            String eleman = wordArr[i];
            Tekrar tekrar = new Tekrar();

            int adet = 0;
            for (int j = 0; j < wordArr.length; j++) {
                String subEleman = wordArr[j];
                if (!eleman.equals(" ") && eleman.equals(subEleman)) {
                    adet++;
                }
            }
            tekrar.setKelime(eleman);
            tekrar.setMiktar(adet);
            boolean has = false;
            if (tekrarList.isEmpty()) {
                tekrarList.add(tekrar);
            } else {
                for (int j = 0; j < tekrarList.size(); j++) {
                    Tekrar tk = tekrarList.get(j);
                    String tkKelime = tk.getKelime();
                    int tkAdet = tk.getMiktar();
                    String tekrarKelime = tekrar.getKelime();
                    int tekrarAdet = tekrar.getMiktar();
                    if (tekrarKelime.equals(tkKelime) && tekrarAdet == tkAdet) {
                        has = true;
                        break;
                    }
                }

                if (!has) {
                    tekrarList.add(tekrar);
                }
            }
        }

        for (int i = 0; i < tekrarList.size(); i++) {
            Tekrar tk = tekrarList.get(i);
//            System.out.println(tk.getKelime() + " :: " + tk.getTekrarMiktari());
        }

        int[] tekrarArr = new int[tekrarList.size()];
        for (int i = 0; i < tekrarArr.length; i++) {
            tekrarArr[i] = tekrarList.get(i).getMiktar();
        }

        ArrayList<Tekrar> tkList5 = new ArrayList<>();
        Arrays.sort(tekrarArr);
        for (int i = tekrarArr.length - 1; i >= tekrarArr.length - 5; i--) {
            int num = tekrarArr[i];

            for (int j = 0; j < tekrarList.size(); j++) {
                Tekrar tk = tekrarList.get(j);
                if (tk.getMiktar()== num) {
                    tkList5.add(tk);
                    break;
                }
            }
        }

        System.out.println("----------");
        for (int i = 0; i < tekrarArr.length; i++) {
            System.out.println(tekrarArr[i]);
        }

        System.out.println("-------------");
        for (int i = 0; i < tekrarList.size(); i++) {
            System.out.println(tekrarList.get(i).getKelime() + " : " + tekrarList.get(i).getMiktar());
        }
        
        return tekrarList;
    }

}
