import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.image.BufferedImage;

public class Intro extends JPanel{
    
    JTextPane text;
    String message = "Welcome to the Farm Game: Plant crops and answer trivia questions using [GROW] to nurture crops and eventually harvest them! Then of course, use your new wealth to buy even better plants at the [Money] Shop";
    JButton proceed;
    Counter c;
    JPanel pCenter;

    public Intro() throws IOException{

        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT));
		this.setBackground(new Color (154, 211, 247));
        this.setLayout(new BorderLayout());
		this.setFocusable(true);




        

       BufferedImage grass = ImageIO.read(new File("images.jpg"));
       Image i = grass.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
       ImageIcon ii = new ImageIcon(i);
       JLabel picLabel = new JLabel(ii);
       picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
       this.add(picLabel);


        print();

        proceed = new JButton("Start");
        proceed.setSize(200, 200);
        this.add(proceed);
        proceed.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                c = new Counter(1);
                GameRunner.frame.initializeCenter();
                proceed.setEnabled(false);
                proceed.setVisible(false);
                update();

            }
        });
        
    }
    public void update(){
        this.setVisible(false);
        this.setEnabled(false);
    }

    public void print() {
        text = new JTextPane();
        text.setBackground(new Color (230,202,216));
        text.setFont(new Font("Serif", Font.BOLD, 60)); 
        text.setText(message);
  
        StyledDocument doc = text.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), center, false);

        this.add(text,BorderLayout.SOUTH);
    }


}
