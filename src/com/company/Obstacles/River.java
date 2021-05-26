package com.company.Obstacles;

import com.company.PositionPair;

public class River extends Obstacle{

    public String draw1() {
        return "/resorce/Obstacle/River.png";
    }


    public River(PositionPair position, int radius) {
        super(position, radius);
    }




}
