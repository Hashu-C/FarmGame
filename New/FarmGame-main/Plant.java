import java.awt.*;

//plant rarity seperated into 7 levels
//first level provides the basis and is what ppl start with
//in the shop panel they can purchase higher level 'seeds' that give more money/take up less space 


public class Plant {
    int progress;  
    boolean readyToHarvest;
    int xCord;
    int yCord;
    Color c;
        int rColor;
        int gColor;
        int bColor;
        int alphaVal;
    int rarity;
    static int value = 5;

    public Plant(int x, int y, int rarity, int value) {
        xCord = x;
        yCord = y;
        progress = 0;
        //max color at 2
        readyToHarvest=false;
        this.rarity = rarity;
        this.value = value;
    }
    
    public Color getColorVal(){
        if (progress == 0) {
            c = new Color(2, 120, 2, 50);
        } else if(progress == 1) {
            c = new Color(86, 191, 86, 100);
        } else {
            c = new Color(2, 120, 2, 200);
        }
        return c;
    }


    //make a update progress upon trivia completion that checks if progress>=3 then updates readyToHarvest
    public void updateProgress(){
        progress++;
        if (progress == 2 ){
            readyToHarvest = true;
        }
    }

    public void harvest(){
        if(this.readyToHarvest){
            GameRunner.frame.moneyCount+=value;
            progress=0;
            readyToHarvest=false;
        }

        GameRunner.frame.money.setText("Money: " + Integer.toString(GameRunner.frame.moneyCount));
    }

    public void setValue(int val){
        value = val;
    }
    public static int getValue(){
        return value;
    }
}
