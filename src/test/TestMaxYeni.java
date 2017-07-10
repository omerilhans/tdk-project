package test;

import java.util.ArrayList;
import java.util.List;

public class TestMaxYeni {
    
    public static String text = "aaa aaa aaa dd dd dd dd ee wwwww wwwww wwwww wwwww wwwww r r r t t";
    
    public static void main(String[] args) {
        Tekrar oldTkrMax = null;
        List<Tekrar> tmpTkList5 = new ArrayList<>();
        List<Tekrar> tekrarList = Test2.getFindMostWords(text);
        
        List<Tekrar> tkrList5 = findMax(oldTkrMax, tmpTkList5, tekrarList);
        for (int i = 0; i < tkrList5.size(); i++) {
            Tekrar tkr = tkrList5.get(i);
            System.out.println(tkr.getMiktar() + " : " + tkr.getKelime());
        }
    }
    
    public static List<Tekrar> findMax(Tekrar oldTkrMax, List<Tekrar> tkList5, List<Tekrar> tekrarList) {
        Tekrar tkrMax = findMin(tekrarList);
        
        if (tkList5.isEmpty() && oldTkrMax != null) {
            tkrMax.setMiktar(oldTkrMax.getMiktar());
            tkrMax.setKelime(oldTkrMax.getKelime());
        } else if (oldTkrMax == null) {
            for (int i = 0; i < tekrarList.size(); i++) {
                Tekrar tkr = tekrarList.get(i);
                if (tkrMax.getMiktar() < tkr.getMiktar()
                        && !check5(tkList5, tkr)) {
                    tkrMax.setMiktar(tkr.getMiktar());
                    tkrMax.setKelime(tkr.getKelime());
                }
            }
        } else {
            for (int i = 0; i < tekrarList.size(); i++) {
                Tekrar tkr = tekrarList.get(i);
                boolean hasIntoList = check5(tkList5, tkr);
                if (!hasIntoList
                        && !tkrMax.getKelime().equals(tkr.getKelime())
                        && tkrMax.getMiktar() <= tkr.getMiktar()) {
                    tkrMax.setMiktar(tkr.getMiktar());
                    tkrMax.setKelime(tkr.getKelime());
                }
            }
        }
        
        tkList5.add(tkrMax);
        if (tkList5.size() < 5) {
            oldTkrMax = new Tekrar();
            oldTkrMax.setMiktar(tkrMax.getMiktar());
            oldTkrMax.setKelime(tkrMax.getKelime());
            findMax(oldTkrMax, tkList5, tekrarList);
        } else {
            System.out.println("tkList5 : " + tkList5.size());
            return tkList5;
        }
        return tkList5;
    }
    
    public static boolean check5(List<Tekrar> tkr5List, Tekrar tkr) {
        if (tkr5List.isEmpty()) {
            return false;
        }
        for (int j = 0; j < tkr5List.size(); j++) {
            Tekrar tkr5 = tkr5List.get(j);
            if (tkr.getKelime().equals(tkr5.getKelime()) && tkr.getMiktar() == tkr5.getMiktar()) {
                return true;
            }
        }
        
        return false;
    }
    
    public static Tekrar findMin(List<Tekrar> tekrarList) {
        Tekrar tkMin = new Tekrar();
        tkMin.setKelime(tekrarList.get(0).getKelime());
        tkMin.setMiktar(tekrarList.get(0).getMiktar());
        for (int i = 0; i < tekrarList.size(); i++) {
            Tekrar tkr = tekrarList.get(i);
            if (tkMin.getMiktar() > tkr.getMiktar()) {
                tkMin.setKelime(tkr.getKelime());
                tkMin.setMiktar(tkr.getMiktar());
            }
        }
        
        return tkMin;
    }
    
}
