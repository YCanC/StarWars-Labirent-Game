
public class Stormtrooper extends Karakter{

    public Stormtrooper(String Ad, String Tur) {
        super(Ad, Tur);
        
        
        
    }

    public Stormtrooper() {
    }

    @Override
    public String getAd() {
        return Ad;
    }

    @Override
    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    @Override
    public String getTur() {
        return Tur;
    }

    @Override
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
