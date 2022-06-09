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
            return 20;
        }
        if (rarity == 1) {
            return 45;
        }
        if (rarity == 2) {
            return 120;
        }
        if (rarity == 3) {
            return 245;
        }
        if (rarity == 4) {
            return 420;
        }
        if (rarity == 5) {
            return 645;
        }
        if (rarity == 6) {
            return 920;
        }
        if (rarity == 7) {
            return 1245;
        }
        return 0;
    }

    public static Plant getPlant(int Hori, int Vert) {
        Plant temp = new Plant("grass", Hori, Vert, 4, 4, 140,170,240, 5, 2,3 );
        if(Plant.getPlantInUse()==1){
             temp =new Plant("rice", Hori, Vert,1, 1, 210, 205, 150, 10, 5, 4);
        }
        if(Plant.getPlantInUse()==2){
             temp =new Plant("sweet potato",Hori,Vert,2, 2, 192,158,208, 15,8, 5);
        }
        if(Plant.getPlantInUse()==3){
             temp =new Plant("cabbage",Hori,Vert,2, 2, 170,208,150, 20,11, 6);
        }
        if(Plant.getPlantInUse()==4){
             temp =new Plant("edamame",Hori,Vert,3, 3, 112,195,113, 25, 14,7);
        }
        if(Plant.getPlantInUse()==5){
             temp =new Plant("papaya",Hori,Vert,3, 3, 235,175,90, 30,17, 8);
        }
        if(Plant.getPlantInUse()==6){
             temp =new Plant("nectarine",Hori,Vert,4, 4, 240,175,215, 35, 20,9);
        }
        if (Plant.getPlantInUse() == 7){
            temp = new Plant("mango",Hori,Vert,4,4,237,237,130,40,23,10);
        }
        return temp;
    }
}
