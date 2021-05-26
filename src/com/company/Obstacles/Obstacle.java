package com.company.Obstacles;

import com.company.PositionPair;

public abstract class Obstacle {
    private PositionPair myPosition;
    private int radius;

    public Obstacle(PositionPair myPosition, int radius) {
        this.myPosition = myPosition;
        this.radius = radius;
    }
    public abstract String draw1();
    public PositionPair getMyPosition() {
        return myPosition;
    }

    public void setMyPosition(PositionPair myPosition) {
        this.myPosition = myPosition;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
