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
    int placePrice;
    int maxprogress;
    //endregion
    static int value = 5;
    static int plantInUse = 0;
    int harvestPrice;

    int marketValue;


    public Plant(String name,int x, int y, int width, int length, int rColor, int gColor, int bColor, int alphaVal, int placePrice, int harvestPrice,int maxprogress){
        this.name = name;
        this.xCord = x;
        this.yCord=y;
        this.width=width;
        this.length=length;
        this.rColor=rColor;
        this.gColor=gColor;
        this.bColor=bColor;
        this.alphaVal=alphaVal;
        this.placePrice = placePrice;
        this.maxprogress = maxprogress;
        this.progress = 1;
        this.readyToHarvest = false;
        this.harvestPrice = harvestPrice;
        
    }


    public Plant(int x, int y) {
        xCord = x;
        yCord = y;
        //max color at 2
        readyToHarvest=false;

    }
    



    //make a update progress upon trivia completion that checks if progress>=3 then updates readyToHarvest
    public void updateProgress(){
        if (progress+1>maxprogress) {
            progress = progress;
        } else if (progress+1==maxprogress){
            progress++;
            readyToHarvest=true;
        } else {
            progress++;
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



    public static int getPlantInUse(){
        return plantInUse;
	}

	public static void setPlantInUse(int plant){
		plantInUse = plant;
	}


    public boolean plantingCost() {
        if (GameRunner.frame.moneyCount>=placePrice){
            return true;
        } else {
            return false;
        }
    }
    

    //returns market value only used in one instance 
    public static int getPlantMarketPrice(int rarity) {
        if (rarity == 0) {
            
        }
        if (rarity == 1) {
            
        }
        if (rarity == 2) {
            
        }
        if (rarity == 3) {
            
        }
        if (rarity == 4) {
            
        }
        if (rarity == 5) {
            
        }
        if (rarity == 6) {
            
        }
        if (rarity == 7) {
            
        }
        return 0;
    }

    public static Plant getPlant(int Hori, int Vert) {
        Plant temp = new Plant("grass",Hori,Vert,3, 3, 0, 200, 0, 240, 5, 1,3 );
		if(Plant.getPlantInUse()==0){
             temp =new Plant("grass",Hori,Vert,3, 3, 0, 200, 0, 240, 5,5, 3);
        }
        if(Plant.getPlantInUse()==1){
             temp =new Plant("rice",Hori,Vert,3, 3, 0, 0, 200, 240, 5,5, 3);
        }
        if(Plant.getPlantInUse()==2){
             temp =new Plant("sweet potato",Hori,Vert,3, 3, 0, 200, 0, 240, 5,5, 3);
        }
        if(Plant.getPlantInUse()==3){
             temp =new Plant("cabbage",Hori,Vert,3, 3, 0, 200, 0, 240, 5,5, 3);
        }
        if(Plant.getPlantInUse()==4){
             temp =new Plant("edamme",Hori,Vert,3, 3, 0, 200, 0, 240, 5, 5,3);
        }
        if(Plant.getPlantInUse()==5){
             temp =new Plant("papaya",Hori,Vert,3, 3, 0, 200, 0, 240, 5,5, 3);
        }
        if(Plant.getPlantInUse()==6){
             temp =new Plant("nectarines",Hori,Vert,3, 3, 0, 200, 0, 240, 5, 5,3);
        }
        if (Plant.getPlantInUse() == 7){
            temp = new Plant("mango",Hori,Vert,3,3,0,0,0,240,5,5,3);
        }
        
         return temp;
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
