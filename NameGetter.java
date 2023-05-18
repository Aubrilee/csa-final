package fls;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class NameGetter extends JDialog{
	private String name;
  public NameGetter(int num){
    this.setBounds(200,200,250,200);
    this.setBackground(new Color(0,0,170));
    TextField t = new TextField("", 90);
    t.setBounds(50,80,150,20);
    this.add(t);
    JLabel l = new JLabel("Please enter player" + num + "'s name: ");
    l.setBounds(30,30,190,20);
    l.setForeground(new Color(0,0,0));
    this.add(l);
    JButton b = new JButton("Submit");
    b.setBounds(70,110,100,30);
    b.setBackground(new Color(0,0,255));
    b.setForeground(new Color(255,255,0));
   
    b.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		name = t.getText();
    	}
    });
    this.add(b);
    this.setLayout(null);
    this.setVisible(true);
  }
  
  public String getName() {
	  return name;
  }
}
