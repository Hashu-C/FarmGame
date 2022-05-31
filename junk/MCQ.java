package junk;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;

public class MCQ extends JButton implements ActionListener {

   int colorVal;
    //0 = nothing
    //1 = red
    //2 = green

    public MCQ(String text) {
        this.setText(text);
        colorVal=0;
    }


    public void actionPerformed(ActionEvent e){

    }

    public int getColorVal(){
        return colorVal;
    }
    public void setColorVal(int v){
        colorVal = v;

        if(colorVal == 1){
            this.setBackground(Color.red);
        } else if(colorVal==2) {
            this.setBackground(Color.green);
        } else {
            this.setBackground(Color.white);
        }
    }





}