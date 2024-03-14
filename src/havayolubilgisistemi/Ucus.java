package havayolubilgisistemi;

import java.time.LocalTime;

public class Ucus extends Sefer {

    private static int ID = 1;
    public int i;
    public double ucret;
    public Ucak ucak;
    public LocalTime saat;

    // Oluşturcu 
    public Ucus(LocalTime saat, Sefer sefer, Ucak ucak, double ucret) {
        super(sefer.KM, sefer.nerden, sefer.nereye, sefer.sure, sefer.date);
        this.ucak = ucak;
        this.saat = saat;
        this.ucret = ucret;
        ucak.koltukUcreti = ucret;
        i = ID;
        ID++;
        for(int i = 1; i <ucak.siraSayisi; i++){ // koltuk Ucret belirle
            for(int j=0;j<ucak.harfSayisi;j++){
                ucak.kolutkList[i][j].KoltukUcreti(i, ucak.siraSayisi, ucret);
            }
        }
        ucak.pilot.Ucuslar.add(this);
        for (Hostese host : ucak.hosteseList) {
            host.Ucuslar.add(this);
        }
        HavaYolu.UcusList.add(this);
    }
    // uçuş bilgileri 
    public String UcusBilgileri() {
        return "Ucus Sirket Adi: " + ucak.sirketadi +
                "Ucak Adi: " + ucak.name +
                " Ucus tarihi ve Saati: " + formattedDate +
                " Ucus Ucreti: " + ucak.koltukUcreti + " TL" +
                " Ucus Mesafesi: " + KM + " KM" +
                " Ucus " + nerden + " > " + nereye +
                " Ucus Suresi:" + sure +
                " Ucus Koltuk sayisi: " + ucak.kolutkList.length * ucak.kolutkList[0].length +
                " Ucus bos Koltuk sayisi: " + ((ucak.kolutkList.length * ucak.kolutkList[0].length) - ucak.koltukSayisi);
    }
}
