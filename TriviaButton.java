import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TriviaButton extends JPanel implements ActionListener {
    private int rand;
    private String question;
    private String answer;
    private String correctAnswer;
    
    TriviaButton() throws FileNotFoundException {
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT));
		this.setBackground(new Color (142, 30, 76));
		this.setFocusable(true);

        activate();
        //draw String quesztion prompt
        //add buttons 1 -4 
        //logic written below         

    }

    public void activate() throws FileNotFoundException{
        rand = (int)(Math.random()*(numOfLines("Questions.txt")-1)+1);
        question = getFileLine("Questions.txt", rand);
        answer = getFileLine("Answers.txt",rand);
        correctAnswer = getFileLine("CorrectAnswers.txt",rand);

        System.out.println(rand + ": Number chosen with random");
        System.out.println(question);

        System.out.println(answer);
        System.out.println("cA: " + correctAnswer);
        
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
    public static String getFileLine(String fileName, int lineNum) {
        String resultString = "";
        try {
			Scanner scanner = new Scanner(new File(fileName));
			for (int i = 0; i < lineNum; i++) {
                resultString = scanner.nextLine();
			}
	
		} catch (FileNotFoundException e) {
			System.out.println("broken");
		}
        return resultString;
	}



    //returns num of lines in a file..  
    public static int numOfLines(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        int lines = 0;
        try {
            while(sc.hasNextLine()){
                sc.nextLine(); 
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
