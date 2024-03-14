package havayolubilgisistemi;

public class Pilot extends Personel {
    
    public Pilot(String name) {
        super(name);
    }
    @Override
    public String gettip(){
        return "Pilot";
    }
}