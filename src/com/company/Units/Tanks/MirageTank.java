package com.company.Units.Tanks;

import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Tactic;
import com.company.Units.Structures.GrandCannon;
import com.company.Units.Unit;

public class MirageTank extends Tanks {

    public MirageTank(PositionPair myPosition, int id, boolean state, Tactic myTactic) {
        super(750, 1000, 25, 60, 15, 70, 0.1,1, myPosition, id, new OrdinaryMovement(), state,  myTactic);
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/15 Attack.png";
        }else {
            return "/resorce/Units/15 Def.png";
        }

    }




}
