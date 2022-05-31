import java.awt.*;



public class Plant {
     int progress;  //out of 3
     boolean readyToHarvest;
    int xCord;
    int yCord;
    Color c;
    

    public Plant(boolean Terminator) {
        if(Terminator){

        }
    }

    public Plant(int x, int y) {
        xCord = x;
        yCord = y;
        progress = 0;
        //max color at 2
        readyToHarvest=false;
    }
    
    public Color getColorVal(){
        if (progress == 0) {
            c = new Color(132, 163, 132);
        } else if(progress == 1) {
            c = new Color(86, 191, 86);
        } else {
            c = new Color(2, 120, 2);
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
}
