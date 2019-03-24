import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.util.ArrayDeque;
import java.util.Queue;

//en kısa yol algoritması için node
 class Node{
     int x, y, found;

    public Node(int x, int y, int found) {
        this.x = x;
        this.y = y;
        this.found = found;
    }
    
    Node() {}
    ArrayList<Integer> pathx = new ArrayList<>();
    ArrayList<Integer> pathy = new ArrayList<>();

 }

public class bizimPencere extends JFrame implements KeyListener{
    
  int dizi[][]  = new int[11][14];   
  boolean bittiMi=false;
  boolean kazandiMi=false;
  
  //Yol çizimi için kullanılan değişkenler
 static int degiskenStorm = 0;
 static int degiskenVader=0;
 static int degiskenKylo=0;
  //Yol çizimi için kullanılan değişkenler

  
    int kotuToplam=0; //Toplam kötü karakter sayısı
    
    //finish image
    Image finishImage;
    ImageIcon finishImg = new ImageIcon("image/finish.png");
    
    //kazandi image
    Image wonImage;
    ImageIcon wonImg= new ImageIcon("image/won.png");
    
    
    //iyi karakterlerin resmini bulma işlemi-----------------------------------------------
    Image YodaImage;
    ImageIcon YodaImg = new ImageIcon("image/yoda.jpg");
    
    ArrayList<MasterYoda> YodaList = new ArrayList<>();
    
    Image LukeImage;
    ImageIcon LukeImg = new ImageIcon("image/Luke.png");
    ArrayList<LukeSkywalker> LukeList = new ArrayList<>();
    
    //hangi iyi karakterin seçildiğini ve hangi lokasyonu kullanmak gerektiğini anlamak için
    boolean YodaMi=false;
   
    //kötü karakterlerin resmini bulma işlemi***********************************************
    Image VaderImage;
    ImageIcon VaderImg = new ImageIcon("image/DarthVader.jpg");
    ArrayList<DarthVader> DarthVaderList= new ArrayList<>();
    
    Image StormImage;
    ImageIcon StormImg = new ImageIcon("image/Stormtrooper.jpg");
    ArrayList<Stormtrooper> StormList = new ArrayList<>();
    
    Image KyloImage;
    ImageIcon KyloImg = new ImageIcon("image/KyloRen.jpg");
    ArrayList<KyloRen> KyloList = new ArrayList<>(); 
    
    
    int i;
    int j;
   // 
    int baslangicx=6; 
    int baslangicy=5;
    
    int startMemx=540;
    int startMemy=480;
    

    ArrayList <String> satirDizisi2 = new ArrayList<String>();
 
    public bizimPencere(){
       super();
       addKeyListener(this);
    }
    
    
    int sayac =0;
    int sayac2=0;
    int m; int n;
    
    public void kotuKarakterOlustur(String isim,int x, int y)
    {
        if(isim.contains("Darth Vader"))
        {
          //yeni Darth Vader nesnesi oluşturma işleminin dinamik olarak yapılabilmesi 
         
           DarthVaderList.add(new DarthVader());
           DarthVaderList.get(DarthVaderList.size()-1).lokasyon.x = x;
           DarthVaderList.get(DarthVaderList.size()-1).lokasyon.y = y;
           DarthVaderList.get(DarthVaderList.size()-1).startx=x;
           DarthVaderList.get(DarthVaderList.size()-1).starty=y;
           //System.out.println("DarthVaderList.get(0).lokasyon.x: "+  DarthVaderList.get(DarthVaderList.size()-1).lokasyon.x);
        }
        
         if(isim.contains("Stormtrooper"))
        {
          StormList.add(new Stormtrooper());
          StormList.get(StormList.size()-1).lokasyon.x = x;
          StormList.get(StormList.size()-1).lokasyon.y = y; 
          StormList.get(StormList.size()-1).startx=x;
          StormList.get(StormList.size()-1).starty=y;
        }
            
         if(isim.contains("Kylo Ren"))
        {
          KyloList.add(new KyloRen());
          KyloList.get(KyloList.size()-1).lokasyon.x=x;
          KyloList.get(KyloList.size()-1).lokasyon.y=y;
          KyloList.get(KyloList.size()-1).startx=x;
          KyloList.get(KyloList.size()-1).starty=y;
        }
         
    //Kötü karakterlerin toplam sayısını alma işlemi
    kotuToplam = (KyloList.size()+ StormList.size()+ DarthVaderList.size());
    }
    
    public void iyiKarakterOlustur(String isim, int x, int y)
    {
        if(isim.contains("Master Yoda"))
        {
            YodaList.add(new MasterYoda());
            YodaList.get(0).lokasyon.x=x;
            YodaList.get(0).lokasyon.y=y;
            YodaList.get(0).startx=x;
            YodaList.get(0).starty=y;
            YodaMi = true;
        }
        
         if(isim.contains("Luke Skywalker"))
        {
            LukeList.add(new LukeSkywalker());
            LukeList.get(0).lokasyon.x=x;
            LukeList.get(0).lokasyon.y=y;
            LukeList.get(0).startx=x;
            LukeList.get(0).starty=y;
            YodaMi = false;
        }
        
    }
   
    
    
     @Override
    public void paint (Graphics g)
    {
        super.paint(g);
        //n değeri tüm kötü karakter dizilerinin toplam eleman sayısına eşit olucak, text yapısından dolayı.
         m=0; n=kotuToplam;
         
         
               //Kısa yol çizdirme işlemi***************************************************************
      if(!StormList.isEmpty())
       {
           for (int r = 0; r < StormList.size(); r++) {
                  for (int k = 0; k< StormList.get(r).KisaYolx.size(); k++) {
                   g.setColor(Color.blue);
                   g.fillRect( (180+(60*StormList.get(r).KisaYoly.get(k))), (180+(60*StormList.get(r).KisaYolx.get(k))), 42, 42);
                   
               
                   
              }
                         System.out.println("Stormtrooper's shortest path : "+ (StormList.get(r).KisaYolx.size()-1));
           }
         
       } 
       
     
        if(!KyloList.isEmpty())
       {        
           for (int p = 0; p < KyloList.size(); p++) {
               
               for (int k = 0; k < KyloList.get(p).KisaYolx.size(); k++) {
                   
                   g.setColor(Color.red);
                   g.fillRect(180+(60*KyloList.get(p).KisaYoly.get(k)), 180+(60*KyloList.get(p).KisaYolx.get(k)), 55, 55);
                   
                   
               }
                System.out.println("KyloRen's shortest path : "+ (KyloList.get(p).KisaYolx.size()-2));
           }
       }
       
       //Kısa yol çizdirme işlemi***************************************************************


        //Kötü karakterleri çizdirme işlemi
        VaderImage = VaderImg.getImage();
        StormImage = StormImg.getImage();
        KyloImage = KyloImg.getImage();
        
      //bitme resmi
      finishImage = finishImg.getImage();
      
      //kazanma resmi
      wonImage = wonImg.getImage();
        
       for(i=0; i<840; i+=60)
        {
            for( j =0; j<660; j+=60)
            {
                 char temp =satirDizisi2.get(n).charAt(m) ; 
                 sayac= Character.getNumericValue(temp);
                   g.setColor(Color.black);
                   g.drawRect(180+i, 180+j, 60, 60);
                  if(sayac==0)
                 {
                    g.setColor(Color.black);
                    g.fillRect(180+i, 180+j, 60, 60);
                 }
                 if(n<=(12+kotuToplam))
                 {
                     n++;
                 }
            }
           if(m<=26)
           {
                m+=2;
           }
           //n değeri tüm kötü karakter dizilerinin toplam eleman sayısına eşit olucak, text yapısından dolayı.
            n=kotuToplam;
        }
       
      //darth vader için özel
         if(!DarthVaderList.isEmpty())
       {        
           for (int p = 0; p < DarthVaderList.size(); p++) {
               
               for (int k = 0; k < DarthVaderList.get(p).KisaYolx.size()-1; k++) {
                   g.setColor(Color.orange);
                   g.fillRect(180+(60*DarthVaderList.get(p).KisaYoly.get(k)), 180+(60*DarthVaderList.get(p).KisaYolx.get(k)), 30, 30);
                  
             
         
               }
                     System.out.println("Darth Vader's shortest path : "+ (DarthVaderList.get(p).KisaYolx.size()-1));
           }
       }
             if(!DarthVaderList.isEmpty())
        {
            for (int k = 0; k < DarthVaderList.size(); k++) {
                g.drawImage(VaderImage,  DarthVaderList.get(k).lokasyon.x, DarthVaderList.get(k).lokasyon.y, 60, 60, null);
            }
        }
                //Kötü karakterleri çizdirme işlemi----------------------------------------------------------------------
     
        if(!StormList.isEmpty())
        {
            for (int k = 0; k < StormList.size(); k++) {
                
                g.drawImage(StormImage, StormList.get(k).lokasyon.x, StormList.get(k).lokasyon.y,60,60,null);
          
            }
        }
        
        if(!KyloList.isEmpty())
        {
            for (int k = 0; k < KyloList.size(); k++) {
                    
                  g.drawImage(KyloImage, KyloList.get(k).lokasyon.x, KyloList.get(k).lokasyon.y, 60, 60, null);
            }
        }
        //--------------------------------------------------------------------------------------------------------
             
               //iyi karakteri çizdirme işlemi
                YodaImage = YodaImg.getImage();
                LukeImage = LukeImg.getImage();
                               
        if(!YodaList.isEmpty())
        {
            for (int k = 0; k <YodaList.size(); k++) {
 
                 g.drawImage(YodaImage, YodaList.get(0).lokasyon.x, YodaList.get(0).lokasyon.y, 60, 60, null);
            }
        }
        if(!LukeList.isEmpty())
        {
            for (int k = 0; k < LukeList.size(); k++) {
               
                g.drawImage(LukeImage, LukeList.get(0).lokasyon.x, LukeList.get(0).lokasyon.y, 60,60,null);
            }
            
        }
        
        if(bittiMi==true)
        {
            g.drawImage(finishImage, 200, 200, 750, 750, null);
        }
        
        if(kazandiMi==true)
        {
            g.drawImage(wonImage, 230,230,750,750,null);
        }
       
        if(!YodaList.isEmpty())
        {
            g.setFont(new Font("TimesRoman", Font.ITALIC, 20)); 
            g.drawString("Master Yoda Can: "+YodaList.get(0).can, 950, 100);
            
        }
           if(!LukeList.isEmpty())
        {
            g.setFont(new Font("TimesRoman", Font.ITALIC, 20)); 
            g.drawString("Luke Skywalker Can: "+LukeList.get(0).can, 950, 100);
            
        }
              
    }
    
    public void matrisOlustur()
    {
        int dizix=0;
        int diziy=0;
  
        //h değeri n değeri gibi kötü karakterlerin toplam sayısından başlamak zorunda 
         for(int h=kotuToplam; h<(11+kotuToplam); h++)
         {
             for(int m=0; m<=26; m+=2)
             {
                 char temp =satirDizisi2.get(h).charAt(m); 
                 dizi[dizix][diziy] = Character.getNumericValue(temp);
                // System.out.print(dizi[dizix][diziy]);
                 diziy++;
             }
             diziy=0;
             dizix++;
         }
    }
  
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
          int tempx=0;
          int tempy=0; 
        
         if(YodaMi == true)
                  {              
               
                tempx=YodaList.get(0).lokasyon.x;
                tempy=YodaList.get(0).lokasyon.y;
                
                  }
          else
              {
                tempx=LukeList.get(0).lokasyon.x;
                tempy=LukeList.get(0).lokasyon.y;
              }
        
        //sağ ok tuşu
        if(e.getKeyCode()==39)
        {
         tempx+=60;
         baslangicx++;
         
          if(tempx==1020 && tempy==720)
         {
             System.out.println("Tebrikler Kazandınız");
             kazandiMi=true;
         }
          
             else if(dizi[baslangicy][baslangicx]==1)
              {
             
             if(YodaMi == true)
                  {
                YodaList.get(0).lokasyon.x=tempx;
                YodaList.get(0).lokasyon.y=tempy;
              
                  }
                  else
                  {
                      LukeList.get(0).lokasyon.x=tempx;
                      LukeList.get(0).lokasyon.y=tempy;
                  }
               
              }
              else
              {
                   baslangicx--;
                   System.out.println("burdaki elseye girdi");
              }
              
         
           repaint();
        } 
        //alt ok tuşu
          if(e.getKeyCode()==40)
        {
            tempy+=60;
            baslangicy++;
            
        if(tempx==1020 && tempy==720)
         {
             System.out.println("Tebrikler Kazandınız");
             kazandiMi=true;
         }
        
           else if(dizi[baslangicy][baslangicx]==1)
              {
   
                if(YodaMi == true)
                  {
                YodaList.get(0).lokasyon.x=tempx;
                YodaList.get(0).lokasyon.y=tempy;     
                  }
                  else
                  {
                      LukeList.get(0).lokasyon.x=tempx;
                      LukeList.get(0).lokasyon.y=tempy;
                  }
               
              }
              else
              {
                   baslangicy--;
                   
              }
            
                 repaint();
        }
        //sol ok tuşu
            if(e.getKeyCode()==37)
        {
            tempx-=60;
            baslangicx--;
            
         if(tempx==1020 && tempy==720)
         {
             System.out.println("Tebrikler Kazandınız");
             kazandiMi=true;
         }
          else if(dizi[baslangicy][baslangicx]==1)
              {
                  
                 if(YodaMi == true)
                  {
                YodaList.get(0).lokasyon.x=tempx;
                YodaList.get(0).lokasyon.y=tempy;

                  }
                  else
                  {
                      LukeList.get(0).lokasyon.x=tempx;
                      LukeList.get(0).lokasyon.y=tempy;
                  }
              
              }
              else
              {
                   baslangicx++;
                   System.out.println("elseye girdi");
              }
          
          repaint();
        } 
        //yukari ok tuşu
              if(e.getKeyCode()==38)
        {
            tempy-=60; 
            baslangicy--;
            
            if(tempx==1020 && tempy==720)
         {
             System.out.println("Tebrikler Kazandınız");
             kazandiMi=true;
         }
            
            else if(dizi[baslangicy][baslangicx]==1)
              {
                  
                  if(YodaMi == true)
                  {
                YodaList.get(0).lokasyon.x=tempx;
                YodaList.get(0).lokasyon.y=tempy;

                  }
                  else
                  {
                      LukeList.get(0).lokasyon.x=tempx;
                      LukeList.get(0).lokasyon.y=tempy;
                  }
                  
              }
              else
              {
                   baslangicy++;
                   System.out.println("elseye girdi");
              }
              
             
             repaint();
        }
     
         AdimAt();
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

      
    }
//Adım Atma kısmı*********************************************************************
    void AdimAt()
    {
        if(!YodaList.isEmpty())
       {
             if(!StormList.isEmpty())
        {
             for (int c = 0; c <StormList.size(); c++) {
             BFS(dizi, (StormList.get(c).lokasyon.y-180)/60, (StormList.get(c).lokasyon.x-180)/60, (YodaList.get(0).lokasyon.y-180)/60,  (YodaList.get(0).lokasyon.x-180)/60, "Stormtrooper",c); 
            
             if(!StormList.get(c).KisaYolx.isEmpty())
             {
                     StormList.get(c).lokasyon.y =  180+(60*StormList.get(c).KisaYolx.get(0));
             }
            if(!StormList.get(c).KisaYoly.isEmpty())
             {
            StormList.get(c).lokasyon.x =  180+(60*StormList.get(c).KisaYoly.get(0));
             }
            
            if(StormList.get(c).lokasyon.x == YodaList.get(0).lokasyon.x && StormList.get(c).lokasyon.y == YodaList.get(0).lokasyon.y)
            { 
                baslangicx=6;
                baslangicy=5;
               YodaList.get(0).can--;
                System.out.println("YodaList.get(0).can: "+YodaList.get(0).can);
               if(YodaList.get(0).can==0)
               {
                   System.out.println("oyun bitti");
                   bittiMi=true;
                   break;
               }
               YodaList.get(0).lokasyon.x= YodaList.get(0).startx;
               YodaList.get(0).lokasyon.y= YodaList.get(0).starty;
               
               
                for (int s = 0; s < StormList.size(); s++) {
                  StormList.get(s).lokasyon.x=StormList.get(s).startx;
                  StormList.get(s).lokasyon.y=StormList.get(s).starty;
                }
                     if(!DarthVaderList.isEmpty())
                       {
                           for (int yc = 0; yc < DarthVaderList.size(); yc++) {
                               DarthVaderList.get(yc).lokasyon.x = DarthVaderList.get(yc).startx;
                               DarthVaderList.get(yc).lokasyon.y = DarthVaderList.get(yc).starty;
                           }
                       }
                     
                          if(!KyloList.isEmpty())
                       {
                           for (int yc = 0; yc < KyloList.size(); yc++) {
                               KyloList.get(yc).lokasyon.x = KyloList.get(yc).startx;
                               KyloList.get(yc).lokasyon.y = KyloList.get(yc).starty;
                           }
                       }
  
            }
            
          }
        }
         
         if(!KyloList.isEmpty())
         {
             for(int f=0; f<KyloList.size(); f++)
             {
               BFS(dizi,(KyloList.get(f).lokasyon.y-180)/60, (KyloList.get(f).lokasyon.x-180)/60, (YodaList.get(0).lokasyon.y-180)/60,(YodaList.get(0).lokasyon.x-180)/60, "Kylo Ren",f);
           
                     if(KyloList.get(f).KisaYoly.size() >1)
                   {
                     KyloList.get(f).lokasyon.x = 180+(60*KyloList.get(f).KisaYoly.get(1));
                     KyloList.get(f).lokasyon.y = 180+(60*KyloList.get(f).KisaYolx.get(1));
                   }
                   if(KyloList.get(f).KisaYolx.size() ==1)
                   {
                     KyloList.get(f).lokasyon.y = 180+(60*KyloList.get(f).KisaYolx.get(0));
                   }
                    if(KyloList.get(f).KisaYoly.size() ==1)
                   {
                     KyloList.get(f).lokasyon.x = 180+(60*KyloList.get(f).KisaYoly.get(0));
                   }
            
                   if(KyloList.get(f).KisaYoly.isEmpty() || KyloList.get(f).KisaYolx.isEmpty() || YodaList.get(0).lokasyon.x==KyloList.get(f).lokasyon.x && YodaList.get(0).lokasyon.y== KyloList.get(f).lokasyon.y)
                  {
           
                      baslangicx=6;
                      baslangicy=5;
                     YodaList.get(0).can--;
              
                       System.out.println("YodaList.get(0).can: "+YodaList.get(0).can);
               if(YodaList.get(0).can==0)
               {
                   System.out.println("oyun bitti");
                   bittiMi=true;
                   break;
               }
               
               //Lokasyonları başa döndürme işlemi
                       YodaList.get(0).lokasyon.x= YodaList.get(0).startx;
                       YodaList.get(0).lokasyon.y= YodaList.get(0).starty;
                       KyloList.get(f).lokasyon.x=KyloList.get(f).startx;
                       KyloList.get(f).lokasyon.y=KyloList.get(f).starty;
                       
                       if(!StormList.isEmpty())
                       {
                           for (int yc = 0; yc < StormList.size(); yc++) {
                               StormList.get(yc).lokasyon.x = StormList.get(yc).startx;
                               StormList.get(yc).lokasyon.y = StormList.get(yc).starty;
                           }
                       }
                        if(!DarthVaderList.isEmpty())
                       {
                           for (int yc = 0; yc < DarthVaderList.size(); yc++) {
                               DarthVaderList.get(yc).lokasyon.x = DarthVaderList.get(yc).startx;
                               DarthVaderList.get(yc).lokasyon.y = DarthVaderList.get(yc).starty;
                           }
                       }
        
                      for (int s = 0; s < StormList.size(); s++) {
                     YodaList.get(s).lokasyon.x=YodaList.get(s).startx;
                    YodaList.get(s).lokasyon.y=YodaList.get(s).starty;
                    }
                      for (int t = 0; t < KyloList.size(); t++) {
                          KyloList.get(t).KisaYolx.clear();
                          KyloList.get(t).KisaYoly.clear();
                      }
                
               }
      
          }
             
       }
         
          if(!DarthVaderList.isEmpty())
       { 
             for(int f=0; f<DarthVaderList.size(); f++)
          {
                 BFSvader(dizi,(DarthVaderList.get(f).lokasyon.y-180)/60, (DarthVaderList.get(f).lokasyon.x-180)/60,  (YodaList.get(0).lokasyon.y-180)/60,  (YodaList.get(0).lokasyon.x-180)/60, "Darth Vader",f);
              
                 if(!DarthVaderList.get(f).KisaYoly.isEmpty())
                 {
                         DarthVaderList.get(f).lokasyon.x = 180+(60*DarthVaderList.get(f).KisaYoly.get(0));
                 }
                            if(!DarthVaderList.get(f).KisaYolx.isEmpty())
                 {  
                               DarthVaderList.get(f).lokasyon.y = 180+(60*DarthVaderList.get(f).KisaYolx.get(0));
                 }
                if(DarthVaderList.get(f).lokasyon.x == YodaList.get(0).lokasyon.x && DarthVaderList.get(f).lokasyon.y == YodaList.get(0).lokasyon.y)
            { 
                
                  baslangicx=6;
                baslangicy=5;
               YodaList.get(0).can--;
                System.out.println("YodaList.get(0).can: "+YodaList.get(0).can);
               if(YodaList.get(0).can==0)
               {
                   System.out.println("oyun bitti");
                   bittiMi=true;
                   break;
               }
               YodaList.get(0).lokasyon.x= YodaList.get(0).startx;
               YodaList.get(0).lokasyon.y= YodaList.get(0).starty;
                
                         if(!StormList.isEmpty())
                          {
                              for (int s = 0; s < StormList.size(); s++) {
                              StormList.get(s).lokasyon.x=StormList.get(s).startx;
                              StormList.get(s).lokasyon.y=StormList.get(s).starty;
                               }
                          }
                         if(!DarthVaderList.isEmpty())
                       {
                           for (int yc = 0; yc < DarthVaderList.size(); yc++) {
                               DarthVaderList.get(yc).lokasyon.x = DarthVaderList.get(yc).startx;
                               DarthVaderList.get(yc).lokasyon.y = DarthVaderList.get(yc).starty;
                           }
                       }
                     
                          if(!KyloList.isEmpty())
                       {
                           for (int yc = 0; yc < KyloList.size(); yc++) {
                               KyloList.get(yc).lokasyon.x = KyloList.get(yc).startx;
                               KyloList.get(yc).lokasyon.y = KyloList.get(yc).starty;
                           }
                       }
                
                
            }
                   
             
          }
             
       }
     }
        
    //Luke'dan itibaren******************************************************************************************************************
        
        
     if(!LukeList.isEmpty())
       {
             if(!StormList.isEmpty())
        {
             for (int c = 0; c <StormList.size(); c++) {
             BFS(dizi, (StormList.get(c).lokasyon.y-180)/60, (StormList.get(c).lokasyon.x-180)/60, (LukeList.get(0).lokasyon.y-180)/60,  (LukeList.get(0).lokasyon.x-180)/60, "Stormtrooper",c); 
            
             if(!StormList.get(c).KisaYolx.isEmpty())
             {
                     StormList.get(c).lokasyon.y =  180+(60*StormList.get(c).KisaYolx.get(0));
             }
            if(!StormList.get(c).KisaYoly.isEmpty())
             {
            StormList.get(c).lokasyon.x =  180+(60*StormList.get(c).KisaYoly.get(0));
             }
            
            if(StormList.get(c).lokasyon.x == LukeList.get(0).lokasyon.x && StormList.get(c).lokasyon.y == LukeList.get(0).lokasyon.y)
            { 
                baslangicx=6;
                baslangicy=5;
               LukeList.get(0).can--;
                System.out.println("LukeList.get(0).can: "+LukeList.get(0).can);
               if(LukeList.get(0).can==0)
               {
                   System.out.println("oyun bitti");
                   bittiMi=true;
                   break;
               }
               LukeList.get(0).lokasyon.x= LukeList.get(0).startx;
               LukeList.get(0).lokasyon.y= LukeList.get(0).starty;
               
               
                for (int s = 0; s < StormList.size(); s++) {
                  StormList.get(s).lokasyon.x=StormList.get(s).startx;
                  StormList.get(s).lokasyon.y=StormList.get(s).starty;
                }
                     if(!DarthVaderList.isEmpty())
                       {
                           for (int yc = 0; yc < DarthVaderList.size(); yc++) {
                               DarthVaderList.get(yc).lokasyon.x = DarthVaderList.get(yc).startx;
                               DarthVaderList.get(yc).lokasyon.y = DarthVaderList.get(yc).starty;
                           }
                       }
                     
                          if(!KyloList.isEmpty())
                       {
                           for (int yc = 0; yc < KyloList.size(); yc++) {
                               KyloList.get(yc).lokasyon.x = KyloList.get(yc).startx;
                               KyloList.get(yc).lokasyon.y = KyloList.get(yc).starty;
                           }
                       }
  
            }
            
          }
        }
         
         if(!KyloList.isEmpty())
         {
             for(int f=0; f<KyloList.size(); f++)
             {
               BFS(dizi,(KyloList.get(f).lokasyon.y-180)/60, (KyloList.get(f).lokasyon.x-180)/60, (LukeList.get(0).lokasyon.y-180)/60,(LukeList.get(0).lokasyon.x-180)/60, "Kylo Ren",f);
           
                     if(KyloList.get(f).KisaYoly.size() >1)
                   {
                     KyloList.get(f).lokasyon.x = 180+(60*KyloList.get(f).KisaYoly.get(1));
                     KyloList.get(f).lokasyon.y = 180+(60*KyloList.get(f).KisaYolx.get(1));
                   }
                   if(KyloList.get(f).KisaYolx.size() ==1)
                   {
                     KyloList.get(f).lokasyon.y = 180+(60*KyloList.get(f).KisaYolx.get(0));
                   }
                    if(KyloList.get(f).KisaYoly.size() ==1)
                   {
                     KyloList.get(f).lokasyon.x = 180+(60*KyloList.get(f).KisaYoly.get(0));
                   }
            
                   if(KyloList.get(f).KisaYoly.isEmpty() || KyloList.get(f).KisaYolx.isEmpty() || LukeList.get(0).lokasyon.x==KyloList.get(f).lokasyon.x && LukeList.get(0).lokasyon.y== KyloList.get(f).lokasyon.y)
                  {
                      System.out.println("danaya girdi");
                      baslangicx=6;
                      baslangicy=5;
                     LukeList.get(0).can--;
                     
                       
                       
                       System.out.println("LukeList.get(0).can: "+LukeList.get(0).can);
               if(LukeList.get(0).can==0)
               {
                   System.out.println("oyun bitti");
                   bittiMi=true;
                   break;
               }
               
               //Lokasyonları başa döndürme işlemi
                       LukeList.get(0).lokasyon.x= LukeList.get(0).startx;
                       LukeList.get(0).lokasyon.y= LukeList.get(0).starty;
                       KyloList.get(f).lokasyon.x=KyloList.get(f).startx;
                       KyloList.get(f).lokasyon.y=KyloList.get(f).starty;
                       
                       if(!StormList.isEmpty())
                       {
                           for (int yc = 0; yc < StormList.size(); yc++) {
                               StormList.get(yc).lokasyon.x = StormList.get(yc).startx;
                               StormList.get(yc).lokasyon.y = StormList.get(yc).starty;
                           }
                       }
                        if(!DarthVaderList.isEmpty())
                       {
                           for (int yc = 0; yc < DarthVaderList.size(); yc++) {
                               DarthVaderList.get(yc).lokasyon.x = DarthVaderList.get(yc).startx;
                               DarthVaderList.get(yc).lokasyon.y = DarthVaderList.get(yc).starty;
                           }
                       }
        
                      for (int s = 0; s < StormList.size(); s++) {
                    LukeList.get(s).lokasyon.x=LukeList.get(s).startx;
                    LukeList.get(s).lokasyon.y=LukeList.get(s).starty;
                    }
                      for (int t = 0; t < KyloList.size(); t++) {
                          KyloList.get(t).KisaYolx.clear();
                          KyloList.get(t).KisaYoly.clear();
                      }
                
               }
      
          }
             
       }
         
          if(!DarthVaderList.isEmpty())
       { 
             for(int f=0; f<DarthVaderList.size(); f++)
          {
                 BFSvader(dizi,(DarthVaderList.get(f).lokasyon.y-180)/60, (DarthVaderList.get(f).lokasyon.x-180)/60,  (LukeList.get(0).lokasyon.y-180)/60,  (LukeList.get(0).lokasyon.x-180)/60, "Darth Vader",f);
              
                 if(!DarthVaderList.get(f).KisaYoly.isEmpty())
                 {
                         DarthVaderList.get(f).lokasyon.x = 180+(60*DarthVaderList.get(f).KisaYoly.get(0));
                 }
                            if(!DarthVaderList.get(f).KisaYolx.isEmpty())
                 {  
                               DarthVaderList.get(f).lokasyon.y = 180+(60*DarthVaderList.get(f).KisaYolx.get(0));
                 }
                if(DarthVaderList.get(f).lokasyon.x == LukeList.get(0).lokasyon.x && DarthVaderList.get(f).lokasyon.y == LukeList.get(0).lokasyon.y)
            { 
                
                  baslangicx=6;
                baslangicy=5;
               LukeList.get(0).can--;
                System.out.println("LukeList.get(0).can: "+LukeList.get(0).can);
               if(LukeList.get(0).can==0)
               {
                   System.out.println("oyun bitti");
                   bittiMi=true;
                   break;
               }
               LukeList.get(0).lokasyon.x= LukeList.get(0).startx;
               LukeList.get(0).lokasyon.y= LukeList.get(0).starty;
                
                         if(!StormList.isEmpty())
                          {
                              for (int s = 0; s < StormList.size(); s++) {
                              StormList.get(s).lokasyon.x=StormList.get(s).startx;
                              StormList.get(s).lokasyon.y=StormList.get(s).starty;
                               }
                          }
                         if(!DarthVaderList.isEmpty())
                       {
                           for (int yc = 0; yc < DarthVaderList.size(); yc++) {
                               DarthVaderList.get(yc).lokasyon.x = DarthVaderList.get(yc).startx;
                               DarthVaderList.get(yc).lokasyon.y = DarthVaderList.get(yc).starty;
                           }
                       }
                     
                          if(!KyloList.isEmpty())
                       {
                           for (int yc = 0; yc < KyloList.size(); yc++) {
                               KyloList.get(yc).lokasyon.x = KyloList.get(yc).startx;
                               KyloList.get(yc).lokasyon.y = KyloList.get(yc).starty;
                           }
                       }
                
                
            }
                   
             
          }
             
       }
     }
   
        
               repaint();
    }
    //Adım Atma kısmı*********************************************************************

     //En kısa yol algoritması kısmı**********************************************************************************

     static final int M = 11;
     static final int N = 14;
   
    ArrayList<Node> nodes = new ArrayList<>();
 
    void BFSvader(int mat[][], int i, int j, int x, int y, String tur, int index)
    {

        int row[] = { -1, 0, 0, 1 };
        int col[] = { 0, -1, 1, 0 };
        nodes.clear();
    
        //x,y = iyi karakter başlangıç konumu                          //N = 14
        //i,j = kötü karakter başlangıç konumu                         //M = 11 
	boolean[][] visited = new boolean[M][N];
        
        nodes.add(new Node());
        nodes.get(0).x=i;
        nodes.get(0).y=j;

      for(int k=0; k<nodes.size(); k++) {
           //değişik deneme***************************************
         
            for (int yh = 0; yh < 4; yh++) {
           if(nodes.get(k).x+row[yh]>=0 && nodes.get(k).y+col[yh]>=0 && nodes.get(k).x+row[yh]<11 &&  nodes.get(k).y+col[yh]<14)
         {
            if(mat[nodes.get(k).x+row[yh]][nodes.get(k).y+col[yh]]==1 || mat[nodes.get(k).x+row[yh]][nodes.get(k).y+col[yh]]==0)
            {
           if(nodes.get(nodes.size()-1).x == x && nodes.get(nodes.size()-1).y == y)
           {
                  if(!DarthVaderList.isEmpty() && tur.contains("Darth Vader"))
                  {
                     
                         DarthVaderList.get(index).KisaYolx.clear();
                         DarthVaderList.get(index).KisaYoly.clear();
                      for (int g = 0; g < nodes.get(nodes.size()-1).pathx.size(); g++) {
                          
                          DarthVaderList.get(index).KisaYolx.add(nodes.get(nodes.size()-1).pathx.get(g));
                          DarthVaderList.get(index).KisaYoly.add(nodes.get(nodes.size()-1).pathy.get(g));
                        //   System.out.println("Darth Vader's shortest path found in "+nodes.get(nodes.size()-1).found+" steps");
                      }
                   
                      
                  } 
        
              
               
               break;
           }
                
                
                nodes.add(new Node());
                nodes.get(nodes.size()-1).x= nodes.get(k).x+row[yh];
                nodes.get(nodes.size()-1).y= nodes.get(k).y+col[yh];
                nodes.get(nodes.size()-1).found=nodes.get(nodes.size()-2).found+1;
                visited[nodes.get(k).x+row[yh]][nodes.get(k).y+col[yh]]=true;
             
            
               nodes.get(nodes.size()-1).pathx= (ArrayList<Integer>) nodes.get(k).pathx.clone();
               nodes.get(nodes.size()-1).pathx.add(nodes.get(nodes.size()-1).x);
               
               nodes.get(nodes.size()-1).pathy= (ArrayList<Integer>) nodes.get(k).pathy.clone();
               nodes.get(nodes.size()-1).pathy.add(nodes.get(nodes.size()-1).y);
       
            }
         } 
           
       }
           //değişik deneme****************************************
    }
   
 }

    void BFS(int mat[][], int i, int j, int x, int y, String tur, int index)
    {
         int row[] = { -1, 0, 0, 1 };
         int col[] = { 0, -1, 1, 0 };
        nodes.clear();
    
        //x,y = iyi karakter başlangıç konumu                          //N = 14
        //i,j = kötü karakter başlangıç konumu                         //M = 11 
	boolean[][] visited = new boolean[M][N];
        
        nodes.add(new Node());
        nodes.get(0).x=i;
        nodes.get(0).y=j;
        
   
      for(int k=0; k<nodes.size(); k++) {
 
            for (int yh = 0; yh < 4; yh++) {
           if(nodes.get(k).x+row[yh]>=0 && nodes.get(k).y+col[yh]>=0 && nodes.get(k).x+row[yh]<11 &&  nodes.get(k).y+col[yh]<14)
         {
            if(mat[nodes.get(k).x+row[yh]][nodes.get(k).y+col[yh]]==1)
            {
           if(nodes.get(nodes.size()-1).x == x && nodes.get(nodes.size()-1).y == y)
           {
               if(!StormList.isEmpty() && tur.contains("Stormtrooper"))
                     {
                          StormList.get(index).KisaYolx.clear();
                          StormList.get(index).KisaYoly.clear();
                   for (int t = 0; t < nodes.get(nodes.size()-1).pathx.size(); t++) 
                         {
                      StormList.get(index).KisaYolx.add(nodes.get(nodes.size()-1).pathx.get(t));
                      StormList.get(index).KisaYoly.add(nodes.get(nodes.size()-1).pathy.get(t));
                        }
                          //   System.out.println("Storm's shortest path found in "+nodes.get(nodes.size()-1).found+" steps");
                   }
             
                  if(!KyloList.isEmpty() && tur.contains("Kylo Ren"))
                  {
                       KyloList.get(index).KisaYolx.clear();
                       KyloList.get(index).KisaYoly.clear();
                      for (int u = 0; u < nodes.get(nodes.size()-1).pathx.size(); u++) {
                          
                          KyloList.get(index).KisaYolx.add(nodes.get(nodes.size()-1).pathx.get(u));
                          KyloList.get(index).KisaYoly.add(nodes.get(nodes.size()-1).pathy.get(u));
                      }
                       //  System.out.println("Kylo's shortest path found in "+nodes.get(nodes.size()-1).found+" steps");
                  }
                 
         
               break;
           }
                
                
                nodes.add(new Node());
                nodes.get(nodes.size()-1).x= nodes.get(k).x+row[yh];
                nodes.get(nodes.size()-1).y= nodes.get(k).y+col[yh];
                nodes.get(nodes.size()-1).found=nodes.get(nodes.size()-2).found+1;
                visited[nodes.get(k).x+row[yh]][nodes.get(k).y+col[yh]]=true;
       
               nodes.get(nodes.size()-1).pathx= (ArrayList<Integer>) nodes.get(k).pathx.clone();
               nodes.get(nodes.size()-1).pathx.add(nodes.get(nodes.size()-1).x);
               
               nodes.get(nodes.size()-1).pathy= (ArrayList<Integer>) nodes.get(k).pathy.clone();
               nodes.get(nodes.size()-1).pathy.add(nodes.get(nodes.size()-1).y);
       
            }

         } 
                
       }
           
    }
  
 }
    
    //En kısa yol algoritması kısmı**********************************************************************************
 
}
