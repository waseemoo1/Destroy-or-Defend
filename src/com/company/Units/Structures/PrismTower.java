package com.company.Units.Structures;

import com.company.PositionPair;
import com.company.Tactics.Deffend.InRangeTactic;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class PrismTower extends Structure{

    public PrismTower(PositionPair myPosition, int id, boolean state) {
        super(4000, 100, 200, 0, 30, 150, 0.7,0.5, myPosition, id, null, state,  new InRangeTactic());
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/prism Tower Deffend.png";
        }
        else
            {
            return "/resorce/Units/prism Tower Deffend.png";
            }
    }
}
