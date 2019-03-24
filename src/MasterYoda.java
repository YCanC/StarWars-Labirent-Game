
public class MasterYoda extends Karakter{

   public int can=6;
    
    public MasterYoda(String Ad, String Tur) {
        super(Ad, Tur);
    }

    public MasterYoda() {
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

    public Lokasyon getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(Lokasyon lokasyon) {
        this.lokasyon = lokasyon;
    }
    
    
    
    
}
