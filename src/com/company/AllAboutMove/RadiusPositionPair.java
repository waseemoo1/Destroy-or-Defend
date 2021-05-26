package com.company.AllAboutMove;

import com.company.PositionPair;

public class RadiusPositionPair {
    private PositionPair myPosition;
    private int radius;

    public RadiusPositionPair(PositionPair myPosition, int radius) {
        this.myPosition = myPosition;
        this.radius = radius;
    }

    public RadiusPositionPair() {
    }

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
