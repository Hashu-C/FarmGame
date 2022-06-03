import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;


public class RarityPanel extends JPanel implements ActionListener{

    //Shop Panel will include border layout that contains 6 of these
    protected JButton use;
    protected JButton buy;

    //int parameter = the rarity and label
    //rarity int starts at 0, then goes from 1 - 6  
    public RarityPanel(int rarity) throws IOException {
        //this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH/2,GamePanel.SCREEN_HEIGHT/3));
		this.setBackground(new Color (154, 211, 247));
		this.setFocusable(false);

        use = new JButton("Equip");
        buy = new JButton("Purchase");

        this.add(use);
        this.add(buy);

        use.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Plant.setPlantInUse(rarity);
                }
        });
        buy.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    
                }
        });

        if (rarity == 1) {
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(goguma));
            this.add(picLabel);
            //picLabel.setBounds(); 
        }
        if (rarity == 2) {
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(goguma));
            this.add(picLabel);
            //picLabel.setBounds(); 
        }
        if (rarity == 3) {
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(goguma));
            this.add(picLabel);
            //picLabel.setBounds(); 
        }
        if (rarity == 4) {
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(goguma));
            this.add(picLabel);
            //picLabel.setBounds(); 
        }
        if (rarity == 5) {
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(goguma));
            this.add(picLabel);
            //picLabel.setBounds(); 
        }
        if (rarity == 6) {
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            JLabel picLabel = new JLabel(new ImageIcon(goguma));
            this.add(picLabel);
            //picLabel.setBounds(); 
        }

    }

    public void actionPerformed(ActionEvent e){

    }



}