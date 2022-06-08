import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.event.*;
import java.awt.*;

public class TriviaButton extends JPanel implements ActionListener {
    boolean correct; //a Scott invention

    private int rand;
    private String question;
    private String answers;
    private String correctAnswer;
    JButton b1;
    JButton b2;
    JButton b3;
    JButton b4;
    int triesLeft;
    JPanel pButtons; 
    JTextPane text;
    ArrayList<JButton> randomizedButtonList = new ArrayList<JButton>();
    TriviaButton() {
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT));
		this.setBackground(new Color (154, 211, 247));
        this.setLayout(new BorderLayout());
		this.setFocusable(true);
        this.triesLeft = 2;
        
        pButtons = new JPanel();
        pButtons.setFocusable(true);
        pButtons.setBackground(new Color (154, 211, 247));
        pButtons.setPreferredSize(new Dimension(100,100));
        this.add(pButtons, BorderLayout.SOUTH); 

        try {
            activate();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        

    }

    Counter c;

    public  void buttonAdd(){
        buttonRandomize();
        for (int i = 0; i<randomizedButtonList.size(); i++){
            pButtons.add(randomizedButtonList.get(i));
        }

        for (int i = 0; i<randomizedButtonList.size(); i++){
            JButton b = randomizedButtonList.get(i);
            b.addActionListener(
            new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    if (b.getText().equals(correctAnswer)){
                        b.setBackground(Color.green);
                         c = new Counter(1);
                         for (JButton x : randomizedButtonList){
                            x.setEnabled(false);
                        }
                        GameFrame.pCenter.updatePlants();
			            GameRunner.frame.updateHarvest();

                    } else {
                        triesLeft--;
                        b.setBackground(Color.red);
                        if (triesLeft<=0){
                            for (JButton x : randomizedButtonList){
                                x.setEnabled(false);
                            }
                             c = new Counter(1);
                        }
                    }
                }
            }
           );
        }
    



    }

    public void buttonRandomize(){
        ArrayList<JButton> list = new ArrayList<JButton>();
        list.add(b1); list.add(b2); list.add(b3); list.add(b4);

        //randomizedButtonList
        int i = list.size();
        int r;
        while ( i == list.size() && i > 0) {
            r= (int)(Math.random() * list.size());
            randomizedButtonList.add(list.get(r));
            list.remove(r);
            i--;
        }
    }

    public void initilizeButtons(String answers){
        Scanner scan = new Scanner(answers);  
        scan.useDelimiter(",");  

        b1  = new JButton(scan.next());
        b2  = new JButton(scan.next());
        b3  = new JButton(scan.next());
        b4  = new JButton(scan.next());

        Font f = new Font("Serif", Font.PLAIN, 20);
        b1.setFont(f); 
        b2.setFont(f); 
        b3.setFont(f); 
        b4.setFont(f); 
        
        scan.close();  
    }

    public void activate() throws FileNotFoundException{
        rand = (int)(Math.random()*(numOfLines("Questions.txt")-1+1)+1);
        question = getFileLine("Questions.txt", rand);
        answers = getFileLine("Answers.txt",rand);
        correctAnswer = getFileLine("CorrectAnswers.txt",rand);

        System.out.println(rand + ": Number chosen with random");
        
        //buttonAdd initiates other 2 methods above
        //must be used after buttons have been created using Scanner delimineter
        initilizeButtons(answers);
        buttonAdd();
        print();
    }

    public void print() {
        text = new JTextPane();
        text.setBackground(new Color (230,202,216));
        text.setFont(new Font("Serif", Font.BOLD, 60)); 
        text.setText(question);
  
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        this.add(text,BorderLayout.CENTER);
    }

    public void generateRands() throws FileNotFoundException{
        rand = (int)(Math.random()*(numOfLines("Questions.txt"))+1);
        System.out.println(rand);
    }


    //returns specific line in a file as a string
    public static String getFileLine(String fileName, int lineNum) {
        String resultString = "";
        try {
			Scanner scanner = new Scanner(new File(fileName));
			for (int i = 0; i < lineNum; i++) {
                resultString = scanner.nextLine();
			}
	
		} catch (FileNotFoundException e) {
			System.out.println("broken");  //I like this file exception 
		}
        return resultString;
	}

    //returns num of lines in a file
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
    @Override
    public void actionPerformed(ActionEvent e) {

    }               
}
