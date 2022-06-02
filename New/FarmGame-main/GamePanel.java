import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.lang.Math;

public class GamePanel extends JPanel implements ActionListener{

	 static final int SCREEN_WIDTH = 1200;
	 static final int SCREEN_HEIGHT = 600;
	 static final int UNIT_SIZE = 60;
	 final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/(UNIT_SIZE*UNIT_SIZE);
	 final int DELAY = 80;
	 protected int dx;
	 protected int dy;
	 private int plantInUse;
	boolean running = false;
	Timer timer;
	private  int x; 

	private  int y; 

	public ArrayList<Plant> plants = new ArrayList<Plant>();

    
	GamePanel(){
		this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
		this.setBackground(new Color (142, 108, 76));
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		running = true;
		timer = new Timer(DELAY,this);
        timer.start();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		checkCollisions();
		repaint();
	}

	public void draw(Graphics g) {
		//Just heads up this draw method updates CONSTANTLY ALL THE TIME
		//this is such a bad way to implement this but im losing my fucking mind might as well
		if(running) {
			//draws plants based on arraylist data so they stay put in their fucking place aND DONT MOVE
			for(int i = 0; i<plants.size(); i++){
				g.setColor(plants.get(i).getColorVal());
				g.fillRect(plants.get(i).xCord, plants.get(i).yCord, UNIT_SIZE*3, UNIT_SIZE*3);
			}
			g.setColor(new Color(0,0,0));
			//grid lines
			for(int i=0;i<SCREEN_HEIGHT/UNIT_SIZE*2;i++) {
				g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
			}
            for(int i=0;i<SCREEN_WIDTH/UNIT_SIZE;i++) {
                g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
            }
			//player always goes on top
            g.setColor(new Color(165,94,220));
			g.fillOval(x, y, UNIT_SIZE, UNIT_SIZE);
		}
	}

	public void move(){
        x += dx;
        y += dy;
	}

	public void checkCollisions() {
		if(x < 0) {
			x=0;
		}
		if(x >= SCREEN_WIDTH) {
			x=SCREEN_WIDTH-UNIT_SIZE;
		}
		if(y < 0) {
			y=0;
		}
		if(y >= SCREEN_HEIGHT) {
			y=SCREEN_HEIGHT-UNIT_SIZE;
		}
	}


	public void canPlant() {
		boolean validLocation = true;
		boolean vvalid = false;
		for (Plant current : plants){
			if((Math.abs(x-current.xCord)<180) && (Math.abs(y-current.yCord)<180)){
				validLocation = false;
			}
		}
		if((x<=1020 && y <=420) && validLocation){
			System.out.println("Update: stored coordinate data of plant lot");
			vvalid = true;
		} 

		if(vvalid && GameRunner.frame.moneyCount>=Plant.getValue()){
			GameRunner.frame.moneyCount-=Plant.getValue();
			System.out.println(Plant.getValue());

			plants.add(new Plant(x,y,1,5));
			GameRunner.frame.money.setText("Money: " + Integer.toString(GameRunner.frame.moneyCount));
			//change value 1 to increase the rarity of the plant used 
		}
	}

	public  void removeLand(){
		for (Plant current : plants){
			if(current.xCord<=x && x<current.xCord+180){
				if(current.yCord<=y && y<current.yCord+180){
					plants.remove(current);
				}		
			}
		}
	}

	public void updatePlants(){
		for (Plant current : plants){
			current.updateProgress();
		}
	}

	public int getPlantInUse(){
		return plantInUse;
	}

	public void setPlantInUse(int plant){
		plantInUse = plant;
	}





	


	public class MyKeyAdapter extends KeyAdapter{

        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
    
            if (key == KeyEvent.VK_LEFT || key== KeyEvent.VK_A) {
                dx = -UNIT_SIZE;
            }
    
            if (key == KeyEvent.VK_RIGHT|| key== KeyEvent.VK_D) {
                dx = UNIT_SIZE;
            }
    
            if (key == KeyEvent.VK_UP|| key== KeyEvent.VK_W) {
                dy = -UNIT_SIZE;
            }
    
            if (key == KeyEvent.VK_DOWN|| key== KeyEvent.VK_S) {
                dy = UNIT_SIZE;
            }
        }
    
        public void keyReleased(KeyEvent e) {
			System.out.println("X: " + x + "   , Y: " + y);
            int key = e.getKeyCode();
    
            if (key == KeyEvent.VK_LEFT|| key== KeyEvent.VK_A) {
                dx = 0;
            }
    
            if (key == KeyEvent.VK_RIGHT|| key== KeyEvent.VK_D) {
                dx = 0;
            }
    
            if (key == KeyEvent.VK_UP|| key== KeyEvent.VK_W) {
                dy = 0;
            }
    
            if (key == KeyEvent.VK_DOWN|| key== KeyEvent.VK_S) {
                dy = 0;
            }
        }
	}
}