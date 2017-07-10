package test;

import java.util.ArrayList;
import java.util.List;

public class TestMax {

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
        Tekrar tkrMax = new Tekrar();
        tkrMax.setKelime(tekrarList.get(0).getKelime());
        tkrMax.setMiktar(tekrarList.get(0).getMiktar());
        Tekrar tmpTkrMax = null;

        if (tkList5.isEmpty() && oldTkrMax != null) {
            tkrMax.setMiktar(oldTkrMax.getMiktar());
            tkrMax.setKelime(oldTkrMax.getKelime());
        } else if (oldTkrMax == null) {
            for (int i = 0; i < tekrarList.size(); i++) {
                Tekrar tkr = tekrarList.get(i);
                if (tkrMax.getMiktar() < tkr.getMiktar()) {
                    tkrMax.setMiktar(tkr.getMiktar());
                    tkrMax.setKelime(tkr.getKelime());
                }
            }
        } else {
            tmpTkrMax = new Tekrar();
            for (int i = 0; i < tekrarList.size(); i++) {
                Tekrar tkr = tekrarList.get(i);
                boolean hasIntoList = check5(tkList5, tkr);
                if (!hasIntoList
                        && !tkrMax.getKelime().equals(tkr.getKelime())
                        && tmpTkrMax.getMiktar() <= tkr.getMiktar()) {
                    tmpTkrMax.setMiktar(tkr.getMiktar());
                    tmpTkrMax.setKelime(tkr.getKelime());
                }
            }
        }

        if (tkList5.isEmpty()) {
            tkList5.add(tkrMax);
        } else {
            if (tmpTkrMax != null) {
                tkrMax.setMiktar(tmpTkrMax.getMiktar());
                tkrMax.setKelime(tmpTkrMax.getKelime());
            }
            tkList5.add(tkrMax);
        }

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

    public static Tekrar findMaxOne(List<Tekrar> tekrarList) {
        Tekrar tkrMax = tekrarList.get(0);
        for (int i = 0; i < tekrarList.size(); i++) {
            Tekrar tkr = tekrarList.get(i);
            if (tkrMax.getMiktar() <= tkr.getMiktar()) {
                tkrMax.setKelime(tkr.getKelime());
                tkrMax.setMiktar(tkr.getMiktar());
            }
        }

        return tkrMax;
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

}
