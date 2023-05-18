package fls;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;
class Main {
  public static void main(String[] args) {
    Frame f = new Frame();
    f.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    		System.exit(0);
    	}
    });
    f.setSize(600,700); 
    f.setBackground(new Color(0,0,0));
    
    NameGetter n = new NameGetter(1);
    while (n.getName() == null){
    	n.setVisible(true);
    }
    Player p = new Player(n.getName(), 30);
    f.add(p);
    
    NameGetter n2 = new NameGetter(2);
    while (n2.getName() == null){
    	n2.setVisible(true);
    }
    Player p2 = new Player(n2.getName(), 150);
    f.add(p2);
    
    n.setVisible(false);
    n.setLocationRelativeTo(f);
    
    Player current = p;
    
    for(int i = 0; i < 6;i++){
      Title t = new Title("replace",20 + (90*i),100);
      f.add(t);
    }
    int x = 20;
    for (int i = 0; i < 6; i++){
      int y = 110;
      for (int j = 200; j <= 1000; j+=200){
        Card c = new Card(x,50 + y,""+ j);
        c.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		//do something
        	}
        });
        y+=60;
        f.add(c);
      }
      x+= 90;
    }

    
    

    

    f.setLayout(null);   
    f.setVisible(true); 
  }
} 
