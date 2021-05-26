package com.company;


public class PositionPair {
    private int x,y;
    /*********************************************************
     * 1/12/2020                                             *
     *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
     *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
     *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
     *********************************************************/
    private int angle;



    public PositionPair() {
    }
    public PositionPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        PositionPair temp=(PositionPair) obj;
        return temp.getX()==this.getX() && temp.getY()==this.getY();
    }




    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


    @Override
    public String toString() {
        return "PositionPair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public int getAngle() {
        return angle;
    }
}
