import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener{

    private JButton plant;
    private JButton grow;
    private JButton harvest;
    private JButton remove;
    
	GameFrame(){
        //panel creation
		GamePanel pCenter = new GamePanel();
        JPanel p1 = new JPanel();

        //grid layout setting
        getContentPane().add(pCenter, BorderLayout.CENTER);
		getContentPane().add(p1,BorderLayout.SOUTH);

        //any extra sets 
        p1.setBackground(Color.PINK);
        p1.setPreferredSize(new Dimension(100,100));

        //button creation && adding listenrs to all && adding to panel
        plant = new JButton("PLANT");
        plant.setFocusable(false);
        plant.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GamePanel.canPlant();
                }
            }
        );
        remove = new JButton("REMOVE");
        remove.setFocusable(false);
        remove.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    GamePanel.removeLand();
                }
            }
        );

        grow = new JButton("GROW");
        grow.setFocusable(false);
        grow.addActionListener(
            new ActionListener() {
                //@Override
                public void actionPerformed(ActionEvent e) {
                    p1.setVisible(false);
                    pCenter.setVisible(false);
                    TriviaButton triviaGame = new TriviaButton();
                    triviaGame.setVisible(true);
                    triviaGame.setFocusable(true);
                    getContentPane().add(triviaGame, BorderLayout.CENTER);
                    pack();
                    

                }
            }
        );
        harvest = new JButton("HARVEST");
        harvest.setFocusable(false);
        harvest.addActionListener(
            new ActionListener() {
                //@Override
                public void actionPerformed(ActionEvent e) {
                    
                }
            }
        );
        p1.add(plant);
        p1.add(grow);
        p1.add(harvest);
        p1.add(remove);

        //Button size sets
        plant.setSize(50,50);
        grow.setSize(50,50);
        harvest.setSize(50,50);
        remove.setSize(50,50);
        //frame shit
        this.setTitle("Farm");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);


		
	}

    public void actionPerformed(ActionEvent e) { 
        //no purpose method but it makes java happy
    } 
}
