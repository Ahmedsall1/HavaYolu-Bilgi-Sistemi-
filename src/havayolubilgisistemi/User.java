package havayolubilgisistemi;

public abstract class User {
    
    private static int ID=1; // Her Kolanıcı için farklı bir ID verilmektedir
    private int id;
    private String name;
    public User(String name ) {
        this.name = name;
        id=ID;
        ID++;
        if(!this.gettip().equals("Yolcu"))
            HavaYolu.PersonelList.add(this);
    }
    public String getName() {return this.name;}
    public void setName(String name) {this.name=name;}
    public int getId() {return id;}  

    public abstract  String gettip();

}
