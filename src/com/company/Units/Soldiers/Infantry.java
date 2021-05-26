package com.company.Units.Soldiers;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class Infantry extends Soldiers
{
    public Infantry(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(250, 50, 50, 10, 3, 3, 0.2,1.5, myPosition, id, new OrdinaryMovement(), state,  myTactic);
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/3 Attack.png";
        }else {
            return "/resorce/Units/3 Def.png";
        }

    }


}
