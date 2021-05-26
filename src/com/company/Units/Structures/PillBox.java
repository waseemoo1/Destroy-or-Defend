package com.company.Units.Structures;

import com.company.PositionPair;
import com.company.Tactics.Deffend.InRangeTactic;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class PillBox extends Structure{

    public PillBox(PositionPair myPosition, int id, boolean state) {
        super(400, 100, 200, 0, 40, 150, 0.7,0.7, myPosition, id, null, state,  new InRangeTactic());
    }


    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/40 Attack.png";
        }else {
            return "/resorce/Units/40 Def.png";
        }
    }
}
