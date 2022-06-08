import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.awt.*;

public class Shop extends JPanel implements ActionListener {
    RarityPanel r0= new RarityPanel(0);
    RarityPanel r1= new RarityPanel(1);
    RarityPanel r2= new RarityPanel(2);
    RarityPanel r3= new RarityPanel(3);
    RarityPanel r4= new RarityPanel(4);
    RarityPanel r5= new RarityPanel(5);
    RarityPanel r6= new RarityPanel(6);
    RarityPanel r7 = new RarityPanel(7);
    RarityPanel rExit = new RarityPanel(10);

    public Shop() throws IOException {
        this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH,GamePanel.SCREEN_HEIGHT));
		this.setBackground(new Color (154, 211, 247));

		this.setFocusable(true);

        GridLayout layout = new GridLayout(3,2);

        this.setLayout(layout);
        this.add(r0);
        this.add(r1);
        this.add(r2);
        this.add(r3);
        this.add(rExit);
        this.add(r4);
        this.add(r5);
        this.add(r6);
        this.add(r7);
		



        
    }
    
    public void actionPerformed(ActionEvent e){
        
    }
}
