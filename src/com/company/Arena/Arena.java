package com.company.Arena;

import com.company.PositionPair;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Arena {

    Map< PositionPair , Square > map = new ConcurrentHashMap<>();
    private static int sizeX=10000,sizeY=10000;
    private static Arena instance= new Arena();
    private Arena(){ }
    int getSizeX() {
        return sizeX;
    }
    public void setSizeX(int sizeX) {
        Arena.sizeX = sizeX;
    }
    int getSizeY() {
        return sizeY;
    }
    public void setSizeY(int sizeY) {
        Arena.sizeY = sizeY;
    }

    static Arena getInstance(){
        return instance;
    }

}