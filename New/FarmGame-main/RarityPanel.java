import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class RarityPanel extends JPanel implements ActionListener{

    //Shop Panel will include border layout that contains 6 of these
    protected JButton use;
    protected JButton buy;

    //int parameter = the rarity and label
    //rarity int starts at 0, then goes from 1 - 6  
    public RarityPanel(int rarity) {
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
                    GameFrame.pCenter.setPlantInUse(rarity);
                }
        });
        buy.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e){
                    
                }
        });
    }

    public void actionPerformed(ActionEvent e){

    }


    /**
     * BufferedImage myPicture = ImageIO.read(new File("path-to-file"));
        JLabel picLabel = new JLabel(new ImageIcon(myPicture));
        add(picLabel);
        picLabel.setBounds(); 
     */
}