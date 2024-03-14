package havayolubilgisistemi;

import java.util.ArrayList;

public class Sirket {
    
    private static int ID=1; 
    public int id;
    public String name;
    public Personel yonetici ;
    public ArrayList<Ucak> ucakList = new ArrayList<Ucak>();// her Şirketin uçakların listesi verdır
    public ArrayList<Ucus> ucusList = new ArrayList<Ucus>();// her Şirketin uçuşların listesi verdır
    
    // set get methodlar
    public String SirketinAdi() {return name;}
    public String gettip(){ return "Sirket";}
    public void ucakEkle(Ucak ucak) { this.ucakList.add(ucak);}
    public void ucakEkle(ArrayList<Ucak> ucak) { this.ucakList.addAll(ucak);}
    public void ucusEkle(Ucus ucus) { this.ucusList.add(ucus);}
    public void setName(String name) {this.name=name;}
    // Oluşturcu
    public Sirket(String name,Ucak ucak) { 
        id=ID;
        ID++;
        this.name=name;
        if(ucak!=null) {
            ucakList.add(ucak);
        }
        boolean var=false;
        for(Sirket sirket: HavaYolu.SirketiList){
            if(sirket.name.equals(name)){
                var=true;  break;
            }
        }
        if(!var)
            HavaYolu.SirketiList.add(this);
    }
}
