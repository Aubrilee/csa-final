import java.awt.*;
import javax.swing.*;
public class NameGetter extends JDialog{
  public NameGetter(){
    this.setBounds(200,200,250,200);
    this.setBackground(new Color(0,0,170));
    JButton b = new JButton("Submit");
    b.setBounds(70,130,100,30);
    b.setBackground(new Color(0,0,255));
    b.setForeground(new Color(255,255,0));
    this.add(b);
    TextField t = new TextField("", 90);
    t.setBounds(50,80,150,20);
    this.add(t);
    JLabel l = new JLabel("Please enter player 1's name: ");
    l.setBounds(40,30,150,20);
    l.setForeground(new Color(0,0,0));
    this.add(l);
    this.setLayout(null);
    this.setVisible(true);
  }
}