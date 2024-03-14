package havayolubilgisistemi;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;


public class HavaYolu {

    final static String UcakTipi[] = { "Kucuk", "Orta", "Buyuk" };
    public static String[] Airports = {
            // region bilgi
            "Istanbul Airport",
            "Adana Airport",
            "Ankara Esenboga Airport",
            "Gazipasa Airport",
            "Antalya Airport",
            "Balikesir Koca Seyit Airport",
            "Bursa Yenisehir Airport",
            "Denizli Cardak Airport",
            "Diyarbakir Airport",
            "Elazig Airport",
            "Erzurum Airport",
            "Eskisehir Hasan Polatkan Airport",
            "Gaziantep Airport",
            "Hatay Airport",
            "Isparta Suleyman Demirel Airport",
            "Istanbul Sabiha Gokcen Airport",
            "Izmir Adnan Menderes Airport",
            "Kars Harakani Airport",
            "Kayseri Airport",
            "Kocaeli Cengiz Topel Airport",
            "Konya Airport",
            "Zafer Airport",
            "Malatya Airport",
            "Dalaman Airport",
            "Milas–Bodrum Airport",
            "Nevsehir Kapadokya Airport",
            "Ordu Giresun Airport",
            "Samsun-Carsamba Airport",
            "Sinop Airport",
            "Sivas Nuri Demirag Airport",
            "Sanliurfa GAP Airport",
            "Tekirdag Corlu Airport",
            "Trabzon Airport",
            "Van Ferit Melen Airport",
            "Zonguldak Caycuma Airport",
            "Adiyaman Airport",
            "Agri Ahmed-i Hani Airport",
            "Amasya Merzifon Airport",
            "Aydin Cildir Airport",
            "Balikesir Merkez Airport",
            "Batman Airport",
            "Bingol Airport",
            "Canakkale Airport",
            "Gokceada Airport",
            "Erzincan Airport",
            "Hakkari–Yuksekova Selahaddin Eyyubi Airport",
            "Igdir Airport",
            "Istanbul Hezarfen Airfield",
            "Selcuk–Efes Airport",
            "Kahramanmaras Airport",
            "Kastamonu Airport",
            "Mardin Airport",
            "Mus Airport",
            "Rize-Artvin Airport",
            "Siirt Airport",
            "Sirnak Serafettin Elci Airport",
            "Tokat Airport",
            "Usak Airport",
            "İncirlik Air Base",
            "Afyon Airport",
            "Merzifon Air Base",
            "Etimesgut Air Base",
            "Guvercinlik Army Air Base",
            "Murted Air Base",
            "Balikesir Air Base",
            "Bandirma Air Base",
            "Bursa Yunuseli Airport",
            "Diyarbakir Air Base",
            "Kesan Army Air Base",
            "Eskisehir Air Base",
            "Sivrihisar Air Base",
            "Istanbul Samandira Army Air Base",
            "Cigli Air Base",
            "Gaziemir Army Air Base",
            "Kaklic Air Base",
            "Erkilet Air Base",
            "Cengiz Topel Naval Air Station",
            "Konya Air Base",
            "Kutahya Air Base",
            "Erhac Air Base",
            "Malatya Tulga Army Air Base",
            "Akhisar Air Base",
            "Bodrum-Imsik Airport",
            "Yalova Air Base",
            "Cukurova Regional Airport",
            "Kas-Demre Bati Antalya Airport",
            "Tatvan Airport",
            "Edirne-Kirklareli Airport",
            "Cesme-Alacati Airport",
            "Gumushane-Bayburt Airport",
            "Karaman Airport",
            "Cukurova Regional Airport",
            "Hasandagi (Nigde Aksaray) Airport",
            "Yozgat Airport"
            // endregion bilgi
    };

    static ArrayList<Sirket> SirketiList = new ArrayList<>();
    static ArrayList<User> PersonelList = new ArrayList<>();
    static ArrayList<Yolcu> YolcuList = new ArrayList<>();
    static ArrayList<Sefer> SeferList = new ArrayList<>();
    static ArrayList<Ucak> UcakList = new ArrayList<>();
    static ArrayList<Ucus> UcusList = new ArrayList<>();

    public void SetSefer(int No, float KM, String nerden, String nereye, LocalTime sure, LocalDateTime date) {
        SeferList.add(new Sefer(KM, nerden, nereye, sure, date));
    }

    public void SetSefer(Sefer sefer) {
        SeferList.add(new Sefer(sefer.KM, sefer.nerden, sefer.nereye, sefer.sure, sefer.date));
    }

    public void setSirket(Sirket sirket) {
        SirketiList.add(sirket);
    }

    public void UcusEkle(ArrayList<Ucus> ucusList) {
        UcusList.addAll(ucusList);
    }

    public void UcusEkle(Ucus ucus) {
        UcusList.add(ucus);
    }
    public static void create() {

        LocalTime saat1 = LocalTime.now();
        LocalTime saat = LocalTime.of(saat1.getHour(), saat1.getMinute());
        LocalDateTime date = LocalDateTime.now();
        Pilot pilot = new Pilot("Ahmed");
        Hostese host = new Hostese("Fatma");
        Ucak ucak = new Ucak(HavaYolu.UcakTipi[1], "AirJet", pilot, host, "AnadoluJet");
        Yolcu yolcu = new Yolcu("Yusuf Demir");
        ucak.kolutkList[2][2].yolcu=yolcu;
        ucak.kolutkList[2][2].durum=true;
        ucak.kolutkList[3][3].durum=true;
        yolcu.Koltuk=ucak.kolutkList[2][2].No;
        for(int j=1;j<ucak.siraSayisi;j++){
            for(int k=0;k<ucak.harfSayisi;k++){
                    if(k>=2 && k<5)
                        ucak.kolutkList[j][k].durum=true;
            }
        }
        int i = 100;
        for (String airport : HavaYolu.Airports) {
            i++;
            date = date.plusDays(1);
            Sefer sefer = new Sefer(i, airport, HavaYolu.Airports[0], saat, date);
            
            new Ucus(saat, sefer, ucak,400);
            new Sirket("AirPort" + Integer.toString(i), ucak);
            new Ucak(HavaYolu.UcakTipi[1], "AnadoluJet", pilot, host, "AirPort");
            new Yolcu(airport);

        }
    }

}




