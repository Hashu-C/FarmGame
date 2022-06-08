import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class GameFrame extends JFrame implements ActionListener{

    public JButton plant;
    private JButton grow;
    private JButton harvest;
    private JButton remove;
    public JButton money;
    static TriviaButton triviaGame;
    public static GamePanel pCenter;
    static JPanel p1;
    public int moneyCount;
    public Shop shopP;
    public GamePanel getPCenter(){
        return pCenter;
    }
    Plant temp;

    
    
    static String centerLayout = BorderLayout.CENTER;
    static String southLayout = BorderLayout.SOUTH;
	public GameFrame() {

        try {
            shopP = new Shop();
        } catch (IOException e1) {
            System.out.println(e1);
        }
        shopP.setVisible(false);

        moneyCount=50999999;
        //panel creation
		pCenter = new GamePanel();
        p1 = new JPanel();

        //grid layout setting
        getContentPane().add(pCenter, BorderLayout.CENTER);
		getContentPane().add(p1,BorderLayout.SOUTH);

        //any extra sets 
        p1.setBackground(Color.PINK);
        p1.setPreferredSize(new Dimension(100,100));

        //button creation && adding listenrs to all && adding to panel
        money = new JButton("Money: " + Integer.toString(moneyCount));
        money.setFocusable(false);
        money.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    p1.setVisible(false);
                    pCenter.setVisible(false);

                    shopP.setVisible(true);
                    shopP.setFocusable(true);
                    getContentPane().add(shopP, BorderLayout.CENTER);
                    pack();
                }
            }
        );

        	
		temp = Plant.getPlant(1,1);
        plant = new JButton("PLANT "+temp.name + " FOR:" + temp.placePrice);
        plant.setFocusable(false);
        plant.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pCenter.canPlant();
                }
            }
        );
        remove = new JButton("REMOVE");
        remove.setFocusable(false);
        remove.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pCenter.removeLand();
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
                    triviaGame = new TriviaButton();
                    triviaGame.setVisible(true);
                    triviaGame.setFocusable(true);
                    getContentPane().add(triviaGame, BorderLayout.CENTER);
                    pack();
                    

                }
          
            }
        );
        
        harvest = new JButton("HARVEST");
        harvest.setFocusable(false);
        harvest.setEnabled(false);
        harvest.addActionListener(
            new ActionListener() {
                //@Override
                public void actionPerformed(ActionEvent e) {
                    for(Plant x : pCenter.plants) {
                        if (x.readyToHarvest) {


                            //do a thing 
                            x.harvest();
                            updateHarvest();
				updateHarvest();
                        }
                    }
                }
            }
        );
        p1.add(plant);
        p1.add(grow);
        p1.add(harvest);
        p1.add(remove);
        p1.add(money);

        //Button size sets
        money.setSize(50,50);
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


    public void updatePlantName(){
        Plant temp = Plant.getPlant(1,1);
        plant.setText("PLANT ["+temp.name + "] FOR: " + temp.placePrice);
    }
	
    public void updateHarvest(){
        boolean canHarvest = false; 
        for(Plant x : pCenter.plants) {
            if (x.readyToHarvest) {
                canHarvest=true;
                break;
            }
        }

        if (canHarvest){
            harvest.setEnabled(true);
        } else {
            harvest.setEnabled(false);
        }
    }

	

}
