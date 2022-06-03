import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;


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
    JLabel label1;
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

                        //System.out.println("correct answer clicked");
                        b.setBackground(Color.green);
                         c = new Counter(1);
                         try {
                            Thread.sleep(500);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                        GameFrame.pCenter.updatePlants();
                    
                    } else {

                        b.setBackground(Color.red);
                        //System.out.println("Wrong asnwer clicked");
                        triesLeft--;

                        if(triesLeft<=0){
                             c = new Counter(.4);
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }

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
        //randomize order into new list for later access

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
        //System.out.println(question);
        //System.out.println(answer);
        //System.out.println("cA: " + correctAnswer);

        //buttonAdd initiates other 2 methods above
        //must be used after buttons have been created using Scanner delimineter
        initilizeButtons(answers);
        buttonAdd();
        //repaint();
        print();
    }

    public void print() {
        label1 = new JLabel(question, SwingConstants.CENTER);
        label1.setBackground(new Color (40,40,40));
        label1.setFont(new Font("Serif", Font.BOLD, 60)); 
        this.add(label1,BorderLayout.CENTER);
    }

    /*
    @Override
    public void paintComponent(Graphics g) {
		super.paintComponent(g);
        System.out.println("Drawing String");
        g.setColor(Color.BLACK);
        g.setFont(new Font("Serif", Font.PLAIN, 80));
        g.drawString(question, 0, 80);
	}
*/
    public void generateRands() throws FileNotFoundException{
        rand = (int)(Math.random()*(numOfLines("Questions.txt")-1+1)+1);
        System.out.println(rand);
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
			System.out.println("broken");  //I like this file exception 
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
