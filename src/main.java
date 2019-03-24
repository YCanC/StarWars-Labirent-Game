import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String iyiKarakter;
        
        System.out.println("Oyuna başlamak istediğiniz karakteri giriniz");
        iyiKarakter=scan.nextLine();
        
        
        ArrayList <String> satirDizisi = new ArrayList<String>();
        String str;
        
        int i=0;
        
        try{
            FileInputStream fStream = new FileInputStream("Harita.txt");
            DataInputStream dStream = new DataInputStream(fStream);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
          
          int j=0;
          str = bReader.readLine();
          satirDizisi.add(str);
          while(str!=null) 
          {
             str = bReader.readLine();
             satirDizisi.add(str);
             j++;
          }
            dStream.close();
        }
        catch(Exception e)
                {
                   System.err.println("hata"); 
                }

        bizimPencere pencere = new bizimPencere();
        pencere.setSize(1280, 1000);
        pencere.setVisible(true);
        
        pencere.iyiKarakterOlustur(iyiKarakter, 540, 480);
       
        pencere.satirDizisi2 = (ArrayList<String>) satirDizisi.clone();
       
          while(!(satirDizisi.get(i).contains("1") && satirDizisi.get(i).contains("0")))
        {
            if(satirDizisi.get(i).contains("Darth Vader"))
            {
                if(satirDizisi.get(i).contains("Kapi:A"))
                {
                    pencere.kotuKarakterOlustur("Darth Vader", 180, 480);
                }
                if(satirDizisi.get(i).contains("Kapi:B"))
                {
                    pencere.kotuKarakterOlustur("Darth Vader", 420, 180);
                }
                if(satirDizisi.get(i).contains("Kapi:C"))
                {
                    pencere.kotuKarakterOlustur("Darth Vader", 900, 180);
                }
                if(satirDizisi.get(i).contains("Kapi:D"))
                {
                    pencere.kotuKarakterOlustur("Darth Vader", 960, 480);
                }
                if(satirDizisi.get(i).contains("Kapi:E"))
                {
                    pencere.kotuKarakterOlustur("Darth Vader", 420, 780);
                }
            }
            
             if(satirDizisi.get(i).contains("Stormtrooper"))
            {
                if(satirDizisi.get(i).contains("Kapi:A"))
                {
                    pencere.kotuKarakterOlustur("Stormtrooper", 180, 480);
                }
                if(satirDizisi.get(i).contains("Kapi:B"))
                {
                    pencere.kotuKarakterOlustur("Stormtrooper", 420, 180);
                }
                if(satirDizisi.get(i).contains("Kapi:C"))
                {
                    pencere.kotuKarakterOlustur("Stormtrooper", 900, 180);
                }
                if(satirDizisi.get(i).contains("Kapi:D"))
                {
                    pencere.kotuKarakterOlustur("Stormtrooper", 960, 480);
                }
                if(satirDizisi.get(i).contains("Kapi:E"))
                {
                    pencere.kotuKarakterOlustur("Stormtrooper", 420, 780);
                }
            }
             
             
             if(satirDizisi.get(i).contains("Kylo Ren"))
            {
                if(satirDizisi.get(i).contains("Kapi:A"))
                {
                    pencere.kotuKarakterOlustur("Kylo Ren", 180, 480);
                }
                if(satirDizisi.get(i).contains("Kapi:B"))
                {
                    pencere.kotuKarakterOlustur("Kylo Ren", 420, 180);
                }
                if(satirDizisi.get(i).contains("Kapi:C"))
                {
                    pencere.kotuKarakterOlustur("Kylo Ren", 900, 180);
                }
                if(satirDizisi.get(i).contains("Kapi:D"))
                {
                    pencere.kotuKarakterOlustur("Kylo Ren", 960, 480);
                }
                if(satirDizisi.get(i).contains("Kapi:E"))
                {
                    pencere.kotuKarakterOlustur("Kylo Ren", 420, 780);
                }
            }

            i++;
        } 
           pencere.matrisOlustur();
          
           System.out.println("pencere.dizi[6][4]: "+ pencere.dizi[6][4]);
           
   
           System.out.println("pencere.dizi[5][1]: "+pencere.dizi[5][1]);
           
             while(! (satirDizisi.get(i).contains("1") && satirDizisi.get(i).contains("0")))
        {
            System.out.println("satirDizisi.get(i): "+satirDizisi.get(i));
            i++;
        }
    
    
    }
    
}
