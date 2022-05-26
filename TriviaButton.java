
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.stream.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TriviaButton extends JPanel implements ActionListener {
    private int randQuestion;
    private String question;
    private String answers;
    private String correctAnswer;
    
    TriviaButton() {
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT));
		this.setBackground(new Color (142, 30, 76));
		this.setFocusable(true);

        activate();
        //draw String quesztion prompt
        //add buttons 1 -4 
        //logic written below 
        

        

    }

    public void activate(){
        randQuestion = (int)(Math.random()*(numOfLines("Questions.txt")-1)+1);
        question = getFileLine("Questions.txt", randQuestion);
        answers = getFileLine("Answers.txt",randQuestion);
        correctAnswer = getFileLine("CorrectAnswers.txt",randQuestion);

        System.out.println(randQuestion + ": Number chosen with random");
        System.out.println(question);
        
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        System.out.println("Drawing String");
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 80));
        g.drawString(question, 0, 80);
	}


    //returns specificec line in a file as a string (later use with scanner del)
    public String getFileLine(String fileName, int lineNum) {
        String result = "";
        int count = 0;
        try {
          File file = new File(fileName);
          Scanner sc = new Scanner(file);
    
          while(sc.hasNextLine()) {
            if (count-1 == lineNum){
                result = sc.nextLine();
                break;
            }
            sc.nextLine();
            count++;

          }
          // close scanner
          sc.close();
        } catch (Exception e) {
          e.getStackTrace();
        }

        return result;
	}



    //returns num of lines in a file..  
    public static int numOfLines(String fileName) {
        int count = 0;

        try {
          // create a new file object
          File file = new File("Questions.txt");
          Scanner sc = new Scanner(file);
          while(sc.hasNextLine()) {
            sc.nextLine();
            count++;
          }
          System.out.println("Total Number of Lines: " + count);
    
          // close scanner
          sc.close();
        } catch (Exception e) {
          e.getStackTrace();
        }

        return count;
      
    }

    //When button clicked in frame class set ALL visible to false 
    //(we'll make the panel auto close so no need for exit button)
    //That panel is used to clear out the other buttons essentailly we need to make It the ONLY panel visible
    //on this new panel, we call the trivia PANEL which will populate itself with the multiple choice and question
    //prompt
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
                 
    
}


/**
               Scanner scan = new Scanner("JavaTpoint/Abhishek/Male/22");  
  
               scan.useDelimiter("/");  
               while(scan.hasNext()){  
                   System.out.println(scan.next());  
               }  
               scan.close();    */
