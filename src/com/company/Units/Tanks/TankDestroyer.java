package com.company.Units.Tanks;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class TankDestroyer extends Tanks
{
    public TankDestroyer(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(1000, 400, 150, 20, 20, 50, 0.5,0.6, myPosition, id, new OrdinaryMovement(), state,  myTactic);
    }

    /*********************************************************
     * 1/12/2020                                             *
     *          1(i-1,j-1) 2(i-1,j) 3(i-1,j+1)               *
     *          4(i,j-1)   U(i,j)   8(i,j+1)                 *
     *          5(i+1,j-1) 6(i+1,j) 7(i+1,j+1)               *
     *********************************************************/

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/20 Attack.png";
        }else {
            return "/resorce/Units/20 Def.png";
        }
    }

}
