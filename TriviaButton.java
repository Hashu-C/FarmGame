import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        JPanel trivia = new JPanel();
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT));
		this.setBackground(new Color (142, 108, 76));
		this.setFocusable(true);


        randQuestion = ThreadLocalRandom.current().nextInt(0, numOfLines("Questions.txt") + 1);
        question = getFileLine("Questions.txt", randQuestion);
        answers = getFileLine("Answers.txt",randQuestion);
        correctAnswer = getFileLine("CorrectAnswer.txt",randQuestion);
        //draw String quesztion prompt
        //add buttons 1 -4 
        //logic written below 

    }
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        g.setFont(new Font ("Serif", Font.PLAIN, 12));
        g.setColor(Color.BLUE);
        //TODO : set font, color and position
		g.drawString(question, GamePanel.SCREEN_WIDTH/2, 30);
	}

    //returns specificec line in a file as a string (later use with scanner del)
    public String getFileLine(String fileName, int lineNum) {
        int n = lineNum;
        String result ;
        try (Stream<String> lines = Files.lines(Paths.get(fileName))) {
          result = lines.skip(n).findFirst().get();
        }
        catch(IOException e){
          System.out.println(e);
        }

        return ""; // did you want it to return result??  -lauren
    }


    //returns num of lines in a file..  
    public static int numOfLines(String fileName) {
        Scanner sc = new Scanner(fileName);
        int lines = 0;
        try {
            while(sc.next()!=null){
                lines++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lines;
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