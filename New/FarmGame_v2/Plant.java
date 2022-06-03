import java.awt.*;

//plant rarity seperated into 7 levels
//first level provides the basis and is what ppl start with
//in the shop panel they can purchase higher level 'seeds' that give more money/take up less space 


public class Plant {
    //region
    String name;
    int progress;  
    boolean readyToHarvest;
    int xCord;
    int yCord;
    int width;
    int length;
    Color c;
        int rColor;
        int gColor;
        int bColor;
        int alphaVal;
    int sellPrice;
    int maxprogress;
    //endregion
    static int value = 5;
    static int plantInUse = 0;
    int harvestPrice;

    public Plant(String name){
        this.name = name;
    }

    public Plant(String name,int x, int y, int width, int length, int rColor, int gColor, int bColor, int alphaVal, int sellPrice, int harvestPrice,int maxprogress, int plantInUse){
        this.name = name;
        this.xCord = x;
        this.yCord=y;
        this.width=width;
        this.length=length;
        this.rColor=rColor;
        this.gColor=gColor;
        this.bColor=bColor;
        this.alphaVal=alphaVal;
        this.sellPrice = sellPrice;
        this.maxprogress = maxprogress;
        this.progress = 1;
        this.readyToHarvest = false;
        this.plantInUse = plantInUse;
        this.harvestPrice = harvestPrice;
        
    }
    public Plant(String name, int width, int length, int rColor, int gColor, int bColor, int alphaVal, int sellPrice, int harvestPrice,int maxprogress, int plantInUse){
        this.name = name;
        this.width=width;
        this.length=length;
        this.rColor=rColor;
        this.gColor=gColor;
        this.bColor=bColor;
        this.alphaVal=alphaVal;
        this.sellPrice = sellPrice;
        this.maxprogress = maxprogress;
        this.progress = 1;
        this.readyToHarvest = false;
        this.harvestPrice = harvestPrice;
        
    }

    public Plant(int x, int y, int plantInUse) {
        xCord = x;
        this.plantInUse = plantInUse;
        yCord = y;
        progress = 1;
        //max color at 2
        readyToHarvest=false;

    }
    



    //make a update progress upon trivia completion that checks if progress>=3 then updates readyToHarvest
    public void updateProgress(){
        progress++;
        if (progress == maxprogress ){
            readyToHarvest = true;
        }
    }

    public void harvest(){
        if(this.readyToHarvest){
            GameRunner.frame.moneyCount+=harvestPrice;
            progress=1;
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

    public static int getPlantInUse(){
        return plantInUse;
	}

	public static void setPlantInUse(int plant){
		plantInUse = plant;
	}


    public boolean plantingCost() {
        if (GameRunner.frame.moneyCount>=sellPrice){
            return true;
        } else {
            return false;
        }
    }



    /** 
    //region
    //all possible plant values
    Plant zero = new Plant(3, 3, 0, 200, 0, 240, 5, 3, 0);
    Plant one = new Plant(width, length, rColor, gColor, bColor, alphaVal, sellPrice, maxprogress, 1);
    Plant two = new Plant(width, length, rColor, gColor, bColor, alphaVal, sellPrice, maxprogress, 2);
    Plant three = new Plant(width, length, rColor, gColor, bColor, alphaVal, sellPrice, maxprogress, 3);
    Plant four = new Plant(width, length, rColor, gColor, bColor, alphaVal, sellPrice, maxprogress,4 );
    Plant five = new Plant(width, length, rColor, gColor, bColor, alphaVal, sellPrice, maxprogress,5);
    Plant six = new Plant(width, length, rColor, gColor, bColor, alphaVal, sellPrice, maxprogress,6);

    public int getWidth(){
        if(getPlantInUse()==0){
            return zero.width;
        }
        if(getPlantInUse()==1){
            return one.width;
        }
        if(getPlantInUse()==2){
            return two.width;
        }
        if(getPlantInUse()==3){
            return three.width;
        }
        if(getPlantInUse()==4){
            return four.width;
        }
        if(getPlantInUse()==5){
            return five.width;
        }
        if(getPlantInUse()==6){
            return six.width;
        }

        return 0;
    }
    public int getLength(){
        if(getPlantInUse()==0){
            return zero.length;
        }
        if(getPlantInUse()==1){
            return one.length;
        }
        if(getPlantInUse()==2){
            return two.length;
        }
        if(getPlantInUse()==3){
            return three.length;
        }
        if(getPlantInUse()==4){
            return four.length;
        }
        if(getPlantInUse()==5){
            return five.length;
        }
        if(getPlantInUse()==6){
            return six.length;
        }

        return 0;
    }
    public int getRColor(){
        if(getPlantInUse()==0){
            return zero.rColor;
        }
        if(getPlantInUse()==1){
            return one.rColor;
        }
        if(getPlantInUse()==2){
            return two.rColor;
        }
        if(getPlantInUse()==3){
            return three.rColor;
        }
        if(getPlantInUse()==4){
            return four.rColor;
        }
        if(getPlantInUse()==5){
            return five.rColor;
        }
        if(getPlantInUse()==6){
            return six.rColor;
        }

        return 0;
    }
    public int getGColor(){
        if(getPlantInUse()==0){
            return zero.gColor;
        }
        if(getPlantInUse()==1){
            return one.gColor;
        }
        if(getPlantInUse()==2){
            return two.gColor;
        }
        if(getPlantInUse()==3){
            return three.gColor;
        }
        if(getPlantInUse()==4){
            return four.gColor;
        }
        if(getPlantInUse()==5){
            return five.gColor;
        }
        if(getPlantInUse()==6){
            return six.gColor;
        }

        return 0;
    }
    public int getBColor(){
        if(getPlantInUse()==0){
            return zero.bColor;
        }
        if(getPlantInUse()==1){
            return one.bColor;
        }
        if(getPlantInUse()==2){
            return two.bColor;
        }
        if(getPlantInUse()==3){
            return three.bColor;
        }
        if(getPlantInUse()==4){
            return four.bColor;
        }
        if(getPlantInUse()==5){
            return five.bColor;
        }
        if(getPlantInUse()==6){
            return six.bColor;
        }

        return 0;
    }
    public int getAlphaVal(){
        if(getPlantInUse()==0){
            return zero.alphaVal;
        }
        if(getPlantInUse()==1){
            return one.alphaVal;
        }
        if(getPlantInUse()==2){
            return two.alphaVal;
        }
        if(getPlantInUse()==3){
            return three.alphaVal;
        }
        if(getPlantInUse()==4){
            return four.alphaVal;
        }
        if(getPlantInUse()==5){
            return five.alphaVal;
        }
        if(getPlantInUse()==6){
            return six.alphaVal;
        }

        return 0;
    }
    public int getSellPrice(){
        if(getPlantInUse()==0){
            return zero.sellPrice;
        }
        if(getPlantInUse()==1){
            return one.sellPrice;
        }
        if(getPlantInUse()==2){
            return two.sellPrice;
        }
        if(getPlantInUse()==3){
            return three.sellPrice;
        }
        if(getPlantInUse()==4){
            return four.sellPrice;
        }
        if(getPlantInUse()==5){
            return five.sellPrice;
        }
        if(getPlantInUse()==6){
            return six.sellPrice;
        }

        return 0;
    }
    public int getMaxProgress(){

        if(getPlantInUse()==0){
            return zero.maxprogress;
        }
        if(getPlantInUse()==1){
            return one.maxprogress;
        }
        if(getPlantInUse()==2){
            return two.maxprogress;
        }
        if(getPlantInUse()==3){
            return three.maxprogress;
        }
        if(getPlantInUse()==4){
            return four.maxprogress;
        }
        if(getPlantInUse()==5){
            return five.maxprogress;
        }
        if(getPlantInUse()==6){
            return six.maxprogress;
        }

        return 0;
    }
    //endregion
    */
}
