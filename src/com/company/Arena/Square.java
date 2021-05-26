package com.company.Arena;

import com.company.Obstacles.Obstacle;
import com.company.Units.Unit;


public class Square {
    Unit unit;
    Obstacle obstacle;


    private Square(Unit unit, Obstacle obstacle) {
        this.unit = unit;
        this.obstacle = obstacle;
    }
    public Square(Obstacle obstacle) {
        this(null , obstacle);
    }

    public Square(Unit unit) {
        this(unit , null);
    }

    public Unit getUnit() {
        return unit;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }



    @Override
    public String toString() {
        return unit.toString();
    }

    public void clean(){
        this.unit=null;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
}
