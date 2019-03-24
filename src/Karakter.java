
import java.util.ArrayList;


public class Karakter {
    
    String Ad;
    String Tur;
    Lokasyon lokasyon = new Lokasyon();
    
    int startx;
    int starty;
    
    ArrayList<Integer> KisaYolx = new ArrayList<>();
    ArrayList<Integer> KisaYoly = new ArrayList<>();
    
    
    public Karakter(String Ad, String Tur) {
        this.Ad = Ad;
        this.Tur = Tur;
    }

    Karakter() {

    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public String getTur() {
        return Tur;
    }

    public void setTur(String Tur) {
        this.Tur = Tur;
    }
    
    public int getlokasyonx()
    {
        return lokasyon.x;
    }
     public int getlokasyony()
    {
        return lokasyon.y;
    }
    
    public void setlokasyonx(int lokasyonx)
    {
        lokasyon.x=lokasyonx;
    }
    
    public void setlokasyony(int lokasyony)
    {
        lokasyon.y=lokasyony;
    }

}
