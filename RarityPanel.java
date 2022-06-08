import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;


//Hi hi Lauren Okay so basically ive lost it 
//N E ways, heres all thats left to do
//first : fix the colors... In Plant.java and make them the same as the backgrounds in This class
//Second Make the text in trivia Button wrap around !
//and last, we need better transparent images just add the files and change the file name in rarity Panels
//oh and one more but we need more trivia questions!

public class RarityPanel extends JPanel implements ActionListener{

    //Shop Panel will include border layout that contains 6 of these
    protected JButton use;
    protected JButton exit;
    protected JButton buy;
    private JLabel label;
    Counter c;
    public RarityPanel(int rarity) throws IOException {
        //this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH/2,GamePanel.SCREEN_HEIGHT/3));
		this.setBackground(new Color (154, 211, 247));
		this.setFocusable(false);

        use = new JButton("Equip");
        buy = new JButton("Purchase");
        exit = new JButton("EXIT");
        

            label = new JLabel("Purchase for:" +  Plant.getPlantMarketPrice(rarity));
            this.add(label);

        this.add(buy);
        this.add(use);
        use.setVisible(false);

        use.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    Plant.setPlantInUse(rarity);
                    GameRunner.frame.updatePlantName();

                }
        });
        buy.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    if(GameRunner.frame.moneyCount>=Plant.getPlantMarketPrice(rarity)){

                        //System.out.println("pruchased");
                        GameRunner.frame.moneyCount-=Plant.getPlantMarketPrice(rarity);
                        GameRunner.frame.money.setText("Money: " + Integer.toString(GameRunner.frame.moneyCount));
                        use.setVisible(true);
                        buy.setVisible(false);
                        displayEquip();
                    }
                }
        });
        exit.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    c = new Counter(0);
                }
        });



        if (rarity == 0) {
            //rice
            JLabel name = new JLabel("Grass");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);

            buy.setVisible(false);
            use.setVisible(true);
            this.add(picLabel);
            this.setBackground(new Color (3, 250, 0,250));
            //picLabel.setBounds(); 
            
        }

        if (rarity == 1) {
            //rice
            JLabel name = new JLabel("Rice");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("rice.png"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            this.setBackground(new Color (3, 157, 252,250));
            //picLabel.setBounds(); 
        }
        if (rarity == 2) {
            //sweet p 
            JLabel name = new JLabel("Sweet Potato");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("goguma.jpg"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            this.setBackground(new Color (250, 115, 2,250));
            //picLabel.setBounds(); 
        }
        if (rarity == 3) {
            //cabba
            JLabel name = new JLabel("Cabbage");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("nappaCabbage.png"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            this.setBackground(new Color (0, 250, 140,250));
            //picLabel.setBounds(); 
        }
        if (rarity == 4) {
            //edam
            JLabel name = new JLabel("Edamame");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("edamame.png"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            //picLabel.setBounds(); 
            this.setBackground(new Color (250 , 250, 0,250));
        }
        if (rarity == 5) {
            JLabel name = new JLabel("Papaya");
            this.add(name);
            //papay
            BufferedImage goguma = ImageIO.read(new File("papaya.png"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            this.setBackground(new Color (250, 40, 0,250));
            //picLabel.setBounds(); 
        }
        if (rarity == 6) {
            //nectar
            JLabel name = new JLabel("Nectarine");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("nectarine.png"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            this.setBackground(new Color (160, 20, 250,250));
            //picLabel.setBounds(); 
        }
        if (rarity == 7) {
            //nectar
            JLabel name = new JLabel("Mango");
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("mango.jpg"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            this.add(picLabel);
            this.setBackground(new Color (160, 20, 0,250));
            //picLabel.setBounds(); 
        }
        if (rarity == 10) {
            this.add(exit);
            this.remove(use);
            this.remove(buy);
            this.setBackground(new Color (0, 0, 0,0));
            //picLabel.setBounds(); 
        }

    }

    public void actionPerformed(ActionEvent e){

    }

    public void displayEquip() {
        this.remove(label);
    }


}
