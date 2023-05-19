package fls;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

class Main {
  public static void main(String[] args) {
	String[] categories = {"HISTORY","ESPN's TOP 10 ALL-TIME ATHLETES","EVERYBODY TALKS ABOUT IT...","THE COMPANY LINE","EPITAPHS & TRIBUTES","3-LETTER WORDS"};
	String[][] questions = {{"Q1", "Q2", "Q3","Q4","Q5","Q6"},{"Q1","Q2"}};
	String[][] answers = {{"A1","A2","A3","A4","A5","A6"},{"A1","A2","A3","A4","A5","A6"}};
	
    Frame f = new Frame();
    f.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    		System.exit(0);
    	}
    });
    f.setSize(1000,800); 
    f.setBackground(new Color(0,0,0));
    /*
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
    n2.setVisible(false);
    
    */
    Player current;
    
    
    JLabel question = new JLabel("");
    question.setBounds(100,700,200,30);
    f.add(question);
    question.setForeground(new Color(255,255,255));
    
    for(int i = 0; i < 6;i++){
      Title t = new Title(categories[i],20 + (160*i),100);
      f.add(t);
    }
    int x = 20;
    for (int i = 0; i < 6; i++){
      int y = 140;
      for (int j = 200; j <= 1000; j+=200){
        Card c = new Card(x,50 + y,""+ j,i,(j/200)-1);
        c.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		c.setBackground(new Color(100,100,100));
        		c.setEnabled(false);
        		question.setText(questions[c.getRow()][c.getCol()]);
        	}
        });
        y+=90;
        f.add(c);
      }
      x+= 160;
    }
    
    //help from stack overflow
    f.addKeyListener(new KeyAdapter() {
    	public void keyTyped(KeyEvent e) {
    		int keycode = e.getKeyCode();
    		if (keycode == 65) {
    			question.setText("p111");
    		}
    		else if(keycode == 71) {
    			question.setText("p2");
    		}
    	}
    });
    
    JLabel what = new JLabel("What is...");
    what.setBounds(330,750,70,20);
    what.setForeground(new Color(255,255,255));
    f.add(what);
    
    TextField t = new TextField("", 90);
    t.setBounds(400,750,150,20);
    f.add(t);
    
    JButton submit = new JButton("Submit");
    submit.setBounds(575,745,100,30);
    submit.setBackground(new Color(0,0,255));
    submit.setForeground(new Color(255,255,0));
   
    submit.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		what.setVisible(false);
    		t.setVisible(false);
    		submit.setVisible(false);
    	}
    });
    f.add(submit);

    f.setLayout(null);   
    f.setVisible(true); 
  }
} 
