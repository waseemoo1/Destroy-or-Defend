package com.company.Units.Tanks;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Tanks.Tanks;
import com.company.Units.Unit;

public class Tesla extends Tanks {

    public Tesla(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(1000, 30, 250, 30, 20, 50, 0.5,0.6, myPosition, id, new OrdinaryMovement(), state,  myTactic);
    }

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
