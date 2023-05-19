package fls;
import javax.swing.*;
import java.awt.*;
public class Title extends JLabel{
  public Title(String val, int x, int y){
    super(val);
    this.setBounds(x,y,150,80);
    this.setFont(new Font("Serif",3, 13));
    if (val.length() > 20) {
    	this.setFont(new Font("Serif",1,8));
    }
    this.setBackground(new Color(255,0,255));
    this.setForeground(new Color(255,255,0));
    this.setAlignmentX(SwingConstants.CENTER);
    this.setAlignmentY(SwingConstants.CENTER);
  }
}
