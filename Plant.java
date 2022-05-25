public class Plant {
    int progress;  //out of 3
    boolean readyToHarvest;
    int xCord;
    int yCord;

    public Plant() {

    }

    public Plant(int x, int y) {
        xCord = x;
        yCord = y;
        progress = 0;
        readyToHarvest=false;
    }


    //make a update progress upon trivia completion that checks if progress>=3 then updates readyToHarvest
    public void updateProgress(){
        
    }
}
