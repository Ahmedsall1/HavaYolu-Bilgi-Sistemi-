package havayolubilgisistemi;

public class Koltuk {

    public String No;
    public double ucret;
    public boolean durum = false;
    public Yolcu yolcu;
    public String koltuktipi = tipi[1];
    public static String[] tipi = { "Business", "Standart", "Ekonomik" };

    // uçak tipi göre sıralama
    public void KoltukUcreti(int sira,int toplamsira , double ucret){
        if(sira<=(int)toplamsira*1/3) {  
            koltuktipi=tipi[1]; 
            this.ucret=ucret;
        }
        else if(sira<=(int)toplamsira*2/3 && sira> (int)toplamsira*1/3){
            koltuktipi=tipi[2]; 
            this.ucret=ucret-ucret*1/5;
        }
        else{
            koltuktipi=tipi[0];
            this.ucret=ucret+ucret*1/5;
        }
    }
    // Bilgiler Al ve Koltuk tip Belirle
    public Koltuk(int sira,char harf ,int toplamsira,double ucret) {
        KoltukUcreti(sira, toplamsira, ucret);
        No=Integer.toString(sira) + String.valueOf(harf);
    }

}
