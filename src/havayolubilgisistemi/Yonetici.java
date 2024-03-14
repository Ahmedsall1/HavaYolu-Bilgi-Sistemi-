package havayolubilgisistemi;

public class Yonetici extends User  {
    

    public HavaYolu havayolu=new HavaYolu();
    private static Yonetici yonet=new Yonetici("Ahmed Salih");
    
    public Yonetici(String name) {
        super(name);
    }
    @Override
    public String gettip(){
        return "Yonetici";    
    }
    public static Yonetici getYonet(){return yonet;}
}
