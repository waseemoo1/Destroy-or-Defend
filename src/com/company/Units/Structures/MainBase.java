package com.company.Units.Structures;

import com.company.AllAboutMove.Movement;
import com.company.AllAboutMove.OrdinaryMovement;
import com.company.PositionPair;
import com.company.Tactics.Attack.RandomAttackTactic;
import com.company.Tactics.Deffend.InRangeTactic;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class MainBase extends Structure {


    public MainBase(PositionPair myPosition, int id)
    {
        super(100000000, 0, 0, 0, 50, 0, 0,0, myPosition, id, null, false ,  null);
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/MainBase.png";
        }else {
            return "/resorce/Units/MainBase.png";
        }
    }


}
