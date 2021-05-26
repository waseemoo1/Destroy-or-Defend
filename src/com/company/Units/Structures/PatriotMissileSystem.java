package com.company.Units.Structures;

import com.company.PositionPair;
import com.company.Tactics.Deffend.InRangeTactic;
import com.company.Tactics.Tactic;
import com.company.Units.Unit;

public class PatriotMissileSystem extends Structure{

    public PatriotMissileSystem(PositionPair myPosition, int id, boolean state) {
        super(2500, 50, 400, 0, 40, 175, 0.2,0.9, myPosition, id, null, state,  new InRangeTactic());
    }

    @Override
    public String draw() {

        if(this.isState())
        {
            return "/resorce/Units/PatriotMissileSystem.png";
        }else {
            return "/resorce/Units/PatriotMissileSystem.png";
        }
    }

}
