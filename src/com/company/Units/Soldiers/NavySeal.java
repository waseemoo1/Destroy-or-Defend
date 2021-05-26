package com.company.Units.Soldiers;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class NavySeal extends Soldiers{

    public NavySeal(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(400, 60, 50, 20, 3, 10, 0.2,2, myPosition, id, new OrdinaryMovement(), state,  myTactic);
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
