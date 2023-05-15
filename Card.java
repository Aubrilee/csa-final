import java.awt.*;
public class Card extends Button{
  public Card(int x, int y, String val){
    super(val);
    this.setBounds(x,y,80,50);
    this.setBackground(new Color(0,0,255));
  }
}