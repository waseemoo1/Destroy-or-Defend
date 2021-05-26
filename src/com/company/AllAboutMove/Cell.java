package com.company.AllAboutMove;

import com.company.PositionPair;

public class Cell {
    double g, h ,f;
    PositionPair parent;

    public Cell(double g, double h, double f, PositionPair parent) {
        this.g = g;
        this.h = h;
        this.f = f;
        this.parent = parent;
    }


    public PositionPair getParent() {
        return parent;
    }

    public Cell setParent(PositionPair parent) {
        this.parent = parent;
        return this;
    }

    public Cell() {
    }

    public Cell setF(double f) {
        this.f = f;
        return this;
    }

    public Cell setG(double g) {
        this.g = g;
        return this;
    }

    public Cell setH(double h) {
        this.h = h;
        return this;
    }

    public double getF() {
        return f;
    }

    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }


}
