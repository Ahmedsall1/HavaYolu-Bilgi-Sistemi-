package havayolubilgisistemi;

import java.util.ArrayList;

public class Ucak {

    private static int ID = 1;
    private static boolean is = false;
    public int id;
    public String name;
    public Koltuk kolutkList[][];
    public ArrayList<Hostese> hosteseList = new ArrayList<>();
    public Pilot pilot;
    public String sirketadi;
    public String tip;
    public int harfSayisi;
    public int siraSayisi;
    public double koltukUcreti;
    public int koltukSayisi;

    // Koltuk saysi Uçak tip göre sırala
    public void sayisi(String tip) {
        this.tip = tip;
        if (tip == HavaYolu.UcakTipi[0]) {
            siraSayisi = 18;
            harfSayisi = 4;
        } else if (tip == HavaYolu.UcakTipi[1]) {
            siraSayisi = 18;
            harfSayisi = 6;
        } else if (tip == HavaYolu.UcakTipi[2]) {
            siraSayisi = 30;
            harfSayisi = 6;
        }
    }
    // bilgiler al
    public Ucak(String tip, String name, Pilot pilot, Hostese hostes, String sirketadi) {
        sayisi(tip);
        id = ID; ID++;
        this.name = name;
        kolutkList = new Koltuk[siraSayisi][harfSayisi];
        this.pilot = pilot;
        this.hosteseList.add(hostes);
        this.sirketadi = sirketadi;
        for (int i = 1; i < siraSayisi; i++) {
            for (int j = 0; j < harfSayisi; j++) {
                kolutkList[i][j] = new Koltuk(i, (char) (j + 65), siraSayisi, koltukUcreti);
            }
        }
        for (Sirket sirket : HavaYolu.SirketiList) {
            if (sirket.name.equals(sirketadi)) {
                sirket.ucakList.add(this);
                break;
            }
        }
        new Sirket(sirketadi, this);
        HavaYolu.UcakList.add(this);
    }
    // koltuk seç
    public Boolean Koltuksec(int sira, int koltuk, Yolcu yolcu) {

        if (kolutkList[sira][koltuk].durum == false) {
            koltukSayisi++;
            yolcu.sira = sira;
            yolcu.harf = koltuk;
            kolutkList[sira][koltuk].durum = true;
            kolutkList[sira][koltuk].yolcu = yolcu;
            return true;
        } else {
            System.out.println("Koltuk Dolu !!!");
            return false;
        }
    }
    public void inis() {
        for (int i = 1; i < kolutkList.length; i++) {
            for (int j = 0; j < kolutkList[0].length; j++) {
                kolutkList[i][j].durum = false;
                kolutkList[i][j].yolcu = null;
                kolutkList[i][j].ucret = 0;
            }
        }
        koltukSayisi = 0;
    }
}
