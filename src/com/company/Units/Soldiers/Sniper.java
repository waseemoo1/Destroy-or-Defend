package com.company.Units.Soldiers;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Soldiers.Soldiers;
import com.company.Units.Unit;

public class Sniper extends Soldiers {

    public Sniper(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(250, 75, 700, 10, 3, 5, 0.1,0.4, myPosition, id, new OrdinaryMovement(), state,  myTactic);
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Asset 2.png";
        }else {
            return "/resorce/Asset 1.png";
        }
    }
}
