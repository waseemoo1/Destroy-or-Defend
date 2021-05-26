package com.company.Units.Tanks;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Structures.PrismTower;
import com.company.Units.Unit;

public class PrismTank extends Tanks{

    public PrismTank(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(750, 1000, 25, 60, 15, 70, 0.1,1, myPosition, id, new OrdinaryMovement(), state,  myTactic);
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
