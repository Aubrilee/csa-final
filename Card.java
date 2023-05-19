package fls;
import java.awt.*;
public class Card extends Button{
  public Card(int x, int y, String val){
    super(val);
    this.setBounds(x,y,	150,80);
    this.setBackground(new Color(0,0,255));
  }
}
