package havayolubilgisistemi;

import java.util.ArrayList;

public class Personel extends User {

    public ArrayList<Ucus> Ucuslar = new ArrayList<>();    
    public Personel(String name) {
        super(name);
    }

    @Override
    public String gettip() {
        return "personel";
    }

}