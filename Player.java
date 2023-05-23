package fls;
import java.awt.*;
import javax.swing.*;

public class Player extends JLabel{
  private int totalMoney;
  private String name;

  public Player(String name,int x){
    super();
    totalMoney = 0;
    this.name = name;
    this.setText(name + ": " + totalMoney);
    this.setBackground(new Color(0,0,0));
    this.setForeground(new Color(255,255,255));
    this.setBounds(x,30,80,50);
  }

  public void addMoney(int money){
    this.totalMoney += money;
    this.setText(name + ": " + totalMoney);
  }
  public void subMoney(int money){
	    this.totalMoney -= money;
	    this.setText(name + ": " + totalMoney);
	  }

  public String getName() {
	  return name;
  }
  
}
