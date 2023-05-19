import java.awt.geom.Path2D;
//import java.io.File;
import java.util.*;

public class ScanQA {
  public static void HardC(){
    String c1 = "History";
    String c2 = "ESPN's top 10 All Time";
    String c3 = "Epitaphs & Tributes";
    String c4 = "3-Letter Words";
    
    String[][] questions = new String[5][4];
    String[][] answers = new String[5][4];
    
    Scanner scanQ = new Scanner();
    Scanner scanA = new Scanner();
    
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 4; j++){
        questions[i][j] = scanQ.nextLine();
      }
    }
      
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 4; j++){
        answers[i][j] = scanA.nextLine();
      }
    }
  }
  
/*
  private String question;
  private String answer;
  private String category;
  private String amount;
  public static void ScanQA(){
  */
    
/*
    File qaSheet = new File("Q and A Table");
    Scanner s = new Scanner(qaSheet);
 
  }

  public static getName {
    String categoryQuestions [5][5] = {{"C1", "C2", "C3", "C4", "C5"},{"Q1 A1", "Q2 A2", "Q3 A3", "Q4 A4", "Q5 A5"}, {"Q6 A6", "Q7 A7", "Q8 A8", "Q9 A9", "Q10 A10"},{"Q11 A11", "Q12 A12", "Q13 A13","Q14 A14", "Q15 A15"}, {"Q16 A16", "Q17 A17", "Q18 A18", "Q19 A19", "Q20 A20"}};
    String answers [4][4] = {{"A1", "A2", "A3", "A4", "A5"}, {"A6", "A7", "A8", "A9", "A10"},{"A11", "A12", "A13","A14", "A15"}, {"A16", "A17", "A18", "A19", "A20"}};
  
  }
  */
}


