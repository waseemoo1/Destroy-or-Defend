package com.company.Obstacles;
import com.company.PositionPair;



public class Vally extends Obstacle{
    public String draw1() {
        return "/resorce/Obstacle/Vally.png";
    }

    public Vally(PositionPair position, int radius) {
        super(position, radius);
    }

}
