package fls;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

class Main {
	public static Player current;
	public static Player p;
	public static Player p2;
	public static Player p3;
	public static Label winBuzz;
	public static boolean pressed;
	public static String[] categories = {"HISTORY","ESPN's TOP 10 ALL-TIME ATHLETES","EVERYBODY TALKS ABOUT IT...","THE COMPANY LINE","EPITAPHS & TRIBUTES","3-LETTER WORDS"};
	public static String[][] questions = {
		{"For the last 8 years of his life, Galileo was under house arrest for espousing this man's theory.",
		"Built in 312 B.C. to link Rome & the South of Italy, it's still in use today",
		"In 1000 Rajaraja I of the Cholas battled to take this Indian Ocean island now known for its tea",
		"Karl led the first of these Marxist organizational efforts; the second one began in 1889",
		"This Asian political party was founded in 1885 with \"Indian National\" as part of its name"},
			
		{"No. 2: 1912 Olympian; football star at Carlisle Indian School; 6 MLB seasons with the Reds, Giants & Braves",
		"No. 8: 30 steals for the Birmingham Barons; 2,306 steals for the Bulls",
		"No. 1: Lettered in hoops, football & lacrosse at Syracuse & if you think he couldn't act, ask his 11 \"unclean\" buddies",
		"No. 10: FB/LB for Columbia U. in the 1920s; MVP for the Yankees in '27 & '36; \"Gibraltar in Cleats\"",
		"No. 5: Only center to lead the NBA in assists; track scholarship to Kansas U.; marathoner; volleyballer"},
		
		{"The city of Yuma in this state has a record average of 4,055 hours of sunshine each year",
		"In the winter of 1971-72, a record 1,122 inches of snow fell at Rainier Paradise Ranger Station in this state",
		"On June 28, 1994 the nat'l weather service began issuing this index that rates the intensity of the sun's radiation",
		"Africa's lowest temperature was 11 degrees below zero in 1935 at Ifrane, just south of Fez in this country",
		"N/A"},
		
		{"In 1963, live on \"The Art Linkletter Show\", this company served its billionth burger",
		"This housewares store was named for the packaging its merchandise came in & was first displayed on",
		"This company's Accutron watch, introduced in 1960, had a guarantee of accuracy to within one minute a  month",
		"Edward Teller & this man partnered in 1898 to sell high fashions to women",
		"The Kirschner brothers, Don & Bill, named this ski company for themselves & the second-highest mountain"},
		
		{"Signer of the Dec. of Indep., framer of the Constitution of Mass., second President of the United States",
		"\"And away we go\"",
		"Outlaw: \"Murdered by a traitor and a coward whose name is not worthy to appear here\"",
		"1939 Oscar winner: \"...you are a credit to your craft, your race and to your family\"",
		"Revolutionary War hero: \"His spirit is in Vermont now\""},
		
		{"In the title of an Aesop fable, this insect shared billing with a grasshopper",
		"Cows regurgitate this from the first stomach to the mouth & chew it again",
		"A small demon, or a mischievous child (who might be a little demon!)",
		"In geologic time one of these, shorter than an eon, is divided into periods & subdivided into epochs",
		"A single layer of paper, or to perform one's craft diligently"}
		
	};
	public static String[][] answers = {{"Copernicus",
		"the Appian Way",
		"Sri Lanka",
		"the International",
		"Congress Party"},
			
		{"Jim Thorpe",
		"Michael Jordan",
		"Jim Brown",
		"Lou Gehrig",
		"(Wilt) Chamberlain"},
		
		{"Arizona",
		"Washington",
		"UV index",
		"Morocco",
		"N/A"},
		
		{"McDonald's",
		"Crate & Barrel",
		"Bulova",
		"Paul Bonwit",
		"K2"},
		
		{"John Adams",
		"Jackie Gleason",
		"Jesse James",
		"Hattie McDaniel",
		"Ethan Allen"},
		
		{"ant",
		"cud",
		"imp",
		"era",
		"ply"}};
  public static void main(String[] args) {
	
// jeapordy board front page 
    Frame f = new Frame();
    f.addWindowListener(new WindowAdapter() {
    	public void windowClosing(WindowEvent e) {
    		System.exit(0);
    	}
    });
    f.setSize(1000,800); 
    f.setBackground(new Color(0,0,0));
  
	  // to ask for name of player
    NameGetter n = new NameGetter(1);
    while (n.getName() == null){
    	n.setVisible(true);
    }
    p = new Player(n.getName(), 30);
    f.add(p);
    
    NameGetter n2 = new NameGetter(2);
    while (n2.getName() == null){
    	n2.setVisible(true);
    }
    p2 = new Player(n2.getName(), 150);
    f.add(p2);
    
    NameGetter n3 = new NameGetter(3);
    while (n3.getName() == null){
    	n3.setVisible(true);
    }
    p3 = new Player(n3.getName(), 270);
    f.add(p3);
    
    n.setVisible(false);
    n2.setVisible(false);
    n3.setVisible(false);
    
	  // displays question on bottom of frame 1 
	  // beautify
    JLabel question = new JLabel("");
    question.setBounds(100,700,800,30);
    f.add(question);
    question.setForeground(new Color(255,255,255));
    
    Label turn = new Label("");
    turn.setBounds(100,650,300,30);
    turn.setForeground(new Color(255,255,255));
    turn.setVisible(true);
    winBuzz = turn;
    f.add(turn);
    
    Label selectedC = new Label();
    
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
   
    // puts titles for category
    for(int i = 0; i < 6;i++){
      Title a = new Title(categories[i],20 + (160*i),100);
      f.add(a);
    }
   // put all questions in correspondance to price button 
    int x = 20;
    for (int i = 0; i < 6; i++){
      int y = 140;
      for (int j = 200; j <= 1000; j+=200){
        Card c = new Card(x,50 + y,""+ j,(j/200)-1,i);
        c.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		winBuzz.setText(null);
        		t.setText(null);
        		what.setVisible(true);
        		t.setVisible(true);
        		submit.setVisible(true);
        		c.setBackground(new Color(100,100,100));
        		question.setText(questions[c.getCol()][c.getRow()]);
        		c.setEnabled(false);
        		f.setFocusable(true);
        		questBox(c.getCol(),c.getRow());
        		selectedC.setText("" + c.getRow() + c.getCol());
        	}
        });
        y+=90;
        f.add(c);
      }
      x+= 160;
    }
    
    // submit button frame 1 sets it hidden and checks if answer is correct
    submit.addActionListener(new ActionListener(){
    	public void actionPerformed(ActionEvent e) {
    		what.setVisible(false);
    		t.setVisible(false);
    		submit.setVisible(false);
    		int r = Integer.parseInt(selectedC.getText().substring(0,1));
    		int c = Integer.parseInt(selectedC.getText().substring(1));
    		int money = (r+1)*200;
    		 if (current != null && t.getText().equalsIgnoreCase(answers[c][r])){
    			question.setText("Right! Choose another question!");
    			current.addMoney(money);
    			current = null;
    			
    		}else if (current != null){
    			question.setText("Wrong! The correct answer was: " + answers[c][r] + ". Choose another question!");
    			current.subMoney(money);
    			current = null;
    		}
    	}
    });
    f.add(submit);
    
 
    

    f.setLayout(null);   
    f.setVisible(true); 
  }
	
	// buzzing in and timer frame 
	// beautify (font color size place)
	
  public static void questBox(int col, int row) {
	  pressed = false;
	  winBuzz.setText(null);
	  Frame f = new Frame();
	  f.setSize(1000,800); 
	   f.setBackground(new Color(0,0,0));
	   //code ranch
	  f.setFocusable(true);
	  
	  JLabel question = new JLabel("");
	    question.setBounds(100,300,800,30);
	    f.add(question);
	    question.setForeground(new Color(255,255,255));
	    question.setText(questions[col][row]);
	    
	  
	  Label l = new Label();
	  l.setBounds(100,650,300,30);
	  l.setForeground(new Color(255,255,255));
	  l.setVisible(true);
	  f.add(l);
	  
	  Label whoWin = new Label("Buzz in with 'a' (player 1), 'g' (player 2), and 'l' (player 3) keys! ");
	  whoWin.setBounds(100,440,300,30);
	  whoWin.setForeground(new Color(255,255,255));
	  whoWin.setVisible(true);
	  f.add(whoWin);
	  
	  KeyAdapter keyad = new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		int keycode = e.getKeyCode();
	    		if ((keycode == KeyEvent.VK_A)){
	    			pressed = true;
	    			whoWin.setText("Player 1 -" + p.getName() + "- wins!!");
	    			current = p;
	    			f.setFocusable(false);
	    			Timer x = new Timer();
	    			TimerTask b = new TimerTask() {
	    				public void run() {
	    					cancel();
	    					x.cancel();
	    					f.dispose();
	    				}
	    			};
	    			x.schedule(b,2000);
	    		}
	    		else if((keycode == KeyEvent.VK_G)) {
	    			pressed = true;
	    			current = p2;
	    			f.setFocusable(false);
	    			whoWin.setText("Player 2 -" + p2.getName() + "- wins!");
	    			Timer x = new Timer();
	    			TimerTask b = new TimerTask() {
	    				public void run() {
	    					cancel();
	    					x.cancel();
	    					f.dispose();
	    				}
	    			};
	    			x.schedule(b,2000);
	    		}
	    		else if((keycode == KeyEvent.VK_L)) {
	    			pressed = true;
	    			current = p3;
	    			f.setFocusable(false);
	    			whoWin.setText("Player 3 -" + p3.getName() + "- wins!");
	    			Timer x = new Timer();
	    			TimerTask b = new TimerTask() {
	    				public void run() {
	    					cancel();
	    					x.cancel();
	    					f.dispose();
	    				}
	    			};
	    			x.schedule(b,2000);
	    		}
	    	}
	    };
	    f.addKeyListener(keyad); //checks if key was clicked by player
	    
	    Timer t = new Timer();
		TimerTask h = new TimerTask(){
			int we = 10;
			public void run() {
				if (pressed) {
					this.cancel();
					t.cancel();
				}
				l.setText(we +" seconds!");
				if (we > 0) {
					we--;
				}
				
				if (we == 0 && !pressed) {
					this.cancel();
					t.cancel();
					winBuzz.setText("Too Late! Choose another question!");
					l.setText("Too Late!");
					f.dispose();
				}
				
			}
		};
		t.schedule(h,0,1000); // every second there is countdown
	  
	  f.setLayout(null);
	  f.setVisible(true); //frame 2
	  
  }
} 
