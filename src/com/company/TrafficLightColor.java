package com.company;

enum colors{Red, Yellow, Green}

class TrafficLights {
    colors tlc = colors.Red;

    public void changeColor(){
        switch (tlc){
            case Red:
                tlc = colors.Green;
                break;
            case Yellow:
                tlc = colors.Red;
                break;
            case Green:
                tlc = colors.Yellow;
                break;

        }
    }
public String toString(){return "" + tlc;}
}

public class TrafficLightColor {

    public static void main(String[] args) {
        TrafficLights t1 = new TrafficLights();
        for (int i = 0; i < 9; i++){
            System.out.println(t1.toString());
            t1.changeColor();
        }
    }
}
