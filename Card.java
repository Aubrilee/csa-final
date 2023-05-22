package fls;
import java.awt.*;
public class Card extends Button{
  private int row;
  private int col;
  public Card(int x, int y, String val,int row, int col){
    super(val);
    this.row = row;
    this.col = col;
    this.setBounds(x,y,	150,80);
    this.setBackground(new Color(0,0,255));
  }
  public int getRow() {
	  return row;
  }
  public int getCol() {
	  return col;
  }
}
