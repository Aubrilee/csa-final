import javax.swing.*;
import java.awt.*;
public class Title extends JLabel{
  public Title(String val, int x, int y){
    super(val);
    this.setBounds(x,y,80,50);
    this.setBackground(new Color(0,0,255));
    this.setForeground(new Color(255,255,0));
    this.setAlignmentX(CENTER_ALIGNMENT);
    this.setAlignmentY(CENTER_ALIGNMENT);
  }
}