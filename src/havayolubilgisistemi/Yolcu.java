package havayolubilgisistemi;

import java.util.ArrayList;

public class Yolcu extends User{

    public static String tip[]={"Standart", "VIP"};
    public String Ytip=tip[0];
    public int sira , harf;
    public ArrayList<Ucus> ucuslar;
    public ArrayList<String> Koltuklar;
    public String Koltuk;

    public Yolcu(String name) {
        super(name);
        HavaYolu.YolcuList.add(this);
        this.ucuslar=new ArrayList<>();
        this.Koltuklar=new ArrayList<>();
    }

    @Override
    public String gettip(){
        return "Yolcu";    
    }
}