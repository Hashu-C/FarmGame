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
    int placePrice;
    int maxprogress;
    //endregion
    static int value = 5;
    static int plantInUse = 0;
    int harvestPrice;

    int marketValue;


    public Plant(String name,int x, int y, int width, int length, int rColor, int gColor, int bColor, int placePrice, int harvestPrice,int maxprogress){
        this.name = name;
        this.xCord = x;
        this.yCord=y;
        this.width=width;
        this.length=length;
        this.rColor=rColor;
        this.gColor=gColor;
        this.bColor=bColor;
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
        Plant temp = new Plant("grass", Hori, Vert, 3, 3, 140,170,240, 5, 1,3 );
        if(Plant.getPlantInUse()==1){
             temp =new Plant("rice", Hori, Vert,3, 3, 210, 205, 150, 5, 5, 3);
        }
        if(Plant.getPlantInUse()==2){
             temp =new Plant("sweet potato",Hori,Vert,3, 3, 192,158,208, 5,5, 3);
        }
        if(Plant.getPlantInUse()==3){
             temp =new Plant("cabbage",Hori,Vert,3, 3, 170,208,150, 5,5, 3);
        }
        if(Plant.getPlantInUse()==4){
             temp =new Plant("edamme",Hori,Vert,3, 3, 112,195,113, 5, 5,3);
        }
        if(Plant.getPlantInUse()==5){
             temp =new Plant("papaya",Hori,Vert,3, 3, 235,175,90, 5,5, 3);
        }
        if(Plant.getPlantInUse()==6){
             temp =new Plant("nectarines",Hori,Vert,3, 3, 240,175,215, 5, 5,3);
        }
        if (Plant.getPlantInUse() == 7){
            temp = new Plant("mango",Hori,Vert,3,3,237,237,130,5,5,3);
        }
        return temp;
    }
}
