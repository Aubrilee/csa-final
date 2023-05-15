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

  public void changeMoney(int money){
    this.totalMoney += money;
    this.setText(name + ": " + totalMoney);
  }
// create class make a player to increment money based on how much money they have and get money 
  // dont specity how many 
  //list of questions (inmain class) with dialogue 
  /* if it's correct increment amount 
  add daily double using Math.random
  */

  
}