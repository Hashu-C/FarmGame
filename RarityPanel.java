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
    protected JButton exit;
    protected JButton buy;
    private JLabel label;
    
    //int parameter = the rarity and label
    //rarity int starts at 0, then goes from 1 - 6  
    public RarityPanel(int rarity) throws IOException {
        //this.setPreferredSize(new Dimension(GamePanel.SCREEN_WIDTH/2,GamePanel.SCREEN_HEIGHT/3));
		this.setBackground(new Color (154, 211, 247));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setFocusable(false);
        
        use = new JButton("Equip");
        use.setAlignmentX(Component.CENTER_ALIGNMENT);
        buy = new JButton("Purchase for " + Plant.getPlantMarketPrice(rarity));
        buy.setAlignmentX(Component.CENTER_ALIGNMENT);
        exit = new JButton("EXIT");
        Font f = new Font("Serif", Font.PLAIN, 30);
        exit.setFont(f);

        exit.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(use);
        use.setVisible(false);

        use.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Plant.setPlantInUse(rarity);
                    GameRunner.frame.updatePlantName();
                }
        });
        buy.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (GameRunner.frame.moneyCount>=Plant.getPlantMarketPrice(rarity)) {

                        System.out.println("pruchased");
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
                public void actionPerformed(ActionEvent e) {
                    Counter c = new Counter(0);
                }
        });

        if (rarity == 0) {
            JLabel name = new JLabel("Grass");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage grass = ImageIO.read(new File("grass.png"));
            Image i = grass.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (140,170,240));
        }

        if (rarity == 1) {
            JLabel name = new JLabel("Rice");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage rice = ImageIO.read(new File("rice.png"));
            Image i = rice.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (210,205,150));
        }

        if (rarity == 2) {
            JLabel name = new JLabel("Sweet Potato");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage goguma = ImageIO.read(new File("gogums.png"));
            Image i = goguma.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (192,158,208));
        }

        if (rarity == 3) {
            JLabel name = new JLabel("Cabbage");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage cab = ImageIO.read(new File("cabbage.png"));
            Image i = cab.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (170,208,150));
        }

        if (rarity == 4) {
            JLabel name = new JLabel("Edamame");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage edam = ImageIO.read(new File("edamame.png"));
            Image i = edam.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel); 
            this.setBackground(new Color (112,195,113));
        }

        if (rarity == 5) {
            JLabel name = new JLabel("Papaya");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage pap = ImageIO.read(new File("papaya.png"));
            Image i = pap.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (235,175,90));
        }

        if (rarity == 6) {
            JLabel name = new JLabel("Nectarine");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage nect = ImageIO.read(new File("nectarine.png"));
            Image i = nect.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (240,175,215));
            
        }

        if (rarity == 7) {
            JLabel name = new JLabel("Mango");
            name.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(name);
            BufferedImage mango = ImageIO.read(new File("mango.png"));
            Image i = mango.getScaledInstance(150, 150, java.awt.Image.SCALE_SMOOTH);
            ImageIcon ii = new ImageIcon(i);
            JLabel picLabel = new JLabel(ii);
            picLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(picLabel);
            this.setBackground(new Color (237,237,130));
        }

        this.add(buy);

        if (rarity == 10) {
            this.add(exit);
            this.remove(use);
            this.remove(buy);
            this.setBackground(new Color (200,225,225)); 
        }

    }

    public void actionPerformed(ActionEvent e){
    }

    public void displayEquip() {
        this.remove(label);
    }
}