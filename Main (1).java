import java.awt.*;
import javax.swing.*;
class Main {
  public static void main(String[] args) {
    Frame f = new Frame();
    f.setSize(600,500); 
    f.setBackground(new Color(0,0,0));
    for(int i = 0; i < 6;i++){
      Title t = new Title("replace",20 + (90*i),100);
      f.add(t);
    }
    int x = 20;
    for (int i = 0; i < 6; i++){
      int y = 110;
      for (int j = 200; j <= 1000; j+=200){
        Card c = new Card(x,50 + y,""+ j);
        y+=60;
        f.add(c);
      }
      x+= 90;
    }

    
    NameGetter n = new NameGetter();
    
    Player p = new Player("Bob",30);
    Player p2 = new Player("Bob2",90);
    f.add(p);

    

    f.setLayout(null);   
    f.setVisible(true); 
  }
} 