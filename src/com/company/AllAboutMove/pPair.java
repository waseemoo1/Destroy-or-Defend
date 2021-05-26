package com.company.AllAboutMove;


import com.company.PositionPair;

public class pPair {

    Double f;
    PositionPair position;


    public pPair() {
    }

    public pPair(Double f, PositionPair position) {
        this.f = f;
        this.position = position;
    }

    public PositionPair getPosition() {
        return position;
    }

    public void setPosition(PositionPair position) {
        this.position = position;
    }

    public double getF() {
        return f;
    }

    public void setF(Double f) {
        this.f = f;
    }


    @Override
    public String toString() {
        return "pPair{" +
                "f=" + f +
                ", position=" + position +
                '}';
    }
}
